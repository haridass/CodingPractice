import java.util.ArrayList;

public class LongestPathDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = { { 1, 2, 3, 4 },
                { 2, 2, 3, 4 },
                { 3, 2, 3, 4 },
                { 4, 5, 6, 7 } };
		getPath(m);
	}
	
	public static void getPath(int[][] m){
		int[][] opt = new int[m.length][m[0].length];
		for(int i=0;i< m.length;i++){
			for(int j=0;j<m[0].length;j++){
				if(i==0 && j ==0){
					opt[i][j] =1;
					continue;
				}
				int opti_1j, optij_1;
				if(i-1 <0) opti_1j=Integer.MIN_VALUE;
				else opti_1j = m[i][j] >m[i-1][j] ?opt[i-1][j]:Integer.MIN_VALUE;
				if(j-1<0) optij_1=Integer.MIN_VALUE;
				else optij_1 = m[i][j] >m[i][j-1] ?opt[i][j-1]:Integer.MIN_VALUE;
				opt[i][j]=  opti_1j>optij_1?opti_1j+1:optij_1+1;
			}
		}
		
		for(int i=0;i<opt.length;i++){
			for(int j =0;j<opt[0].length;j++ ){
				System.out.print(opt[i][j]);
			}
			System.out.println('\n');
		}
		ArrayList<Integer> al = traceBack(opt);
		for(int i:al){
			System.out.println(i);
		}
	}
	
	public static ArrayList<Integer> traceBack(int[][] opt){
		int i=opt.length-1,j=opt[0].length-1;
		ArrayList<Integer> al = new ArrayList<Integer>();
		while(i>=0 && j>=0){
			al.add(opt[i][j]);
			if(i==0 && j == 0)
				break;
			if(i-1 < 0){
				j=j-1;
				continue;
			}
			if(j-1<0){
				i= i-1;
				continue;
			}
			if(opt[i-1][j] > opt[i][j-1]){
				i=i-1;
			}else{
				j=j-1;
			}
			
		}
		return al;
	}
	

}
