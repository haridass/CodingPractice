
public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"a12345678","a12345678bc","a12345678b","a12345678","a12345678asdflksd"};
		System.out.println(getLongestPrefix(arr));
	}
	
	public static String getLongestPrefix(String[] strArry){
		StringBuffer bf = new StringBuffer();
		int counter =0;
		// Loop will stop when one of the character reached the maximum length
		while(true){
			//Check if any array is greater than maximum length
			if(counter>=strArry[0].length()){
				return bf.toString();
			}
			char firstStringChar = strArry[0].charAt(counter);
			for(int i=1;i<strArry.length;i++){
				//Check if any array is greater than maximum length
				if(counter>=strArry[i].length()){
					return bf.toString();
				}
				char currChar = strArry[i].charAt(counter);
				//The characters are not equal, return the stringBuffer appended so far
				if(firstStringChar!=currChar){
					return bf.toString();
				}
			}
			//Finished checking all the strings, increment the counter to check next character. 
			String s = firstStringChar +"";
			bf.append(s);
			counter++;
			 
		}
	}

}
