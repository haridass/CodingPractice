/*************************\
 * FACEBOOK interview question, given a map of countries and population, write a function to retrieve a random country weighted by population.
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

class CountryStats{
	String name= "";
	int cumSum=0;
	public CountryStats(String name, int cumSum){
		this.name = name;
		this.cumSum = cumSum;
	}
}
public class WeightedCountryProbability {

	public static void main(String[] args) {
		HashMap<String,Integer> mp = new HashMap<String,Integer>();
		mp.put("IL", 70);
		mp.put("MI", 50);
		mp.put("LA", 80);
		System.out.println(getRandomCountry(mp));
	}
	public static String getRandomCountry(HashMap<String,Integer> mp){
		String[] countryNames = new String[mp.size()+1];
		/**********************
		 * Creating a array with cummulative sum. For example if there an array 70,120,200 and a random number
		 *  is chosen between 0-200, then the probability of number 0-70 is 70/20, 70-120 is 50/200 and 120-200 is 80/200
		 */
		int[] cummlativePop = new int[mp.size()+1];
		countryNames[0]="";
		Iterator<Entry<String,Integer>> itr = mp.entrySet().iterator();
		int i=1;
		while(itr.hasNext()){
			Entry<String,Integer> itm = itr.next();
			countryNames[i] = itm.getKey();
			cummlativePop[i] = itm.getValue() + cummlativePop[i-1];
			i++;
		}
		int total = cummlativePop[cummlativePop.length-1]; 
		int randomNum = (int)Math.round(Math.random()*(total-1));
		int indx = binarySearchInCumArry(cummlativePop,0,cummlativePop.length,randomNum);
		return countryNames[indx];
	}
	public static int binarySearchInCumArry(int[] arry,int left,int right,int num){
		if(left>=right){
			return -1;
		}
		int mid = (left+right)/2;
		if(arry[mid] <= num && num < arry[mid+1]){
			return mid+1;
		}else{
			if(num < arry[mid]){
				return binarySearchInCumArry(arry,0,mid,num);
			}else{
				return binarySearchInCumArry(arry,mid+1,right,num);
			}
		}
		
	}
	

}
