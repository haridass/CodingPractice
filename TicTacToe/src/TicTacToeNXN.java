
public class TicTacToeNXN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] m = {{'x',' ','o'},
						{'x','o',' '},
						{'o','o','x'}};
		System.out.println(verifyTicTacToe(m));
	}
	public static char verifyTicTacToe(char[][] m){
		int rowLength = m.length;
		int colLength = m[0].length;
		char wonBy = ' ';
		//Check rows
		int i,j;
		for(i=0;i<rowLength;i++){
			for(j=1;j<colLength;j++){
				if(m[i][j-1]!=m[i][j])
						break;
			}
			if(m[i][0] != ' ' && j==colLength){
				wonBy = m[i][0] =='x'?'x':'o';
				return wonBy;
			}
		}
		//check col
		for(j=0;j< colLength;j++){
			for(i=1;i< rowLength;i++){
					if(m[i-1][j]!=m[i][j])
						break;
			}
			if(m[0][j] != ' ' && i==rowLength){
				wonBy = m[0][j] =='x'?'x':'o';
				return wonBy;
			}
		}
		//check diag
		for(j=1;j< colLength;j++){
					if(m[j-1][j-1]!=m[j][j])
						break;
		}
		if(m[0][0] != ' ' && j==colLength){
				wonBy = m[0][0] =='x'?'x':'o';
				return wonBy;
		}
		//check reverse diag
		for(j=1;j< colLength;j++){
					if(m[j][colLength-j-1]!=m[j-1][colLength-j])
						break;
		}
		if(m[0][colLength-1] != ' ' && j==colLength){
			wonBy = m[0][colLength-1] == 'x'? 'x':'o';
			return wonBy;
		}
		return wonBy;
	}
}


