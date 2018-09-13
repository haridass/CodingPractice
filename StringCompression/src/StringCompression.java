
public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		compressString("aabbccd");
	}
	
	public static void compressString(String str){
		char[] chrArry = str.toCharArray();
		StringBuffer bf = new StringBuffer();
		int count = 1;
		for(int i=1;i<chrArry.length;i++){
			if(chrArry[i-1]!= chrArry[i]){
				bf.append(chrArry[i-1]);
				bf.append(count);
				count =1;
			}else{
				count = count +1;
			}
		}
		bf.append(chrArry[chrArry.length-1]);
		bf.append(count);
		System.out.println(bf.toString());
	}

}
