package lookAndSay;

public class LookAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="1";
		for(int i=0;i<100;i++) {
		str = lookAndSay(str);
		System.out.println(str.length());
		}
	}
	
	public static String lookAndSay(String str){
		int prev=0;
		int count =1;
		StringBuffer bf = new StringBuffer();
		for(int i=1;i<str.length();i++){
			if(str.charAt(i)!=str.charAt(prev)){
				bf.append(count);
				bf.append(str.charAt(prev));
				count =1;
			}else{
				count = count+1;
			}
			prev =i;
		}
		bf.append(count);
		bf.append(str.charAt(prev));
		return bf.toString();
	}
	
}
