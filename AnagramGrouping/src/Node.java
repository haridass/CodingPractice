
import java.util.*;
public class Node implements Comparable<Node>{
    String orgStr= null;
    String sortedStr = null;
    Node(String orgStr) {
        this.orgStr = orgStr;
        char[] chararry = orgStr.toCharArray();
        Arrays.sort(chararry);
        sortedStr = new String(chararry);
    }
    @Override
    public int hashCode(){
        int sum = 0;
        for(char ch:this.orgStr.toCharArray()){
            sum = sum + ch;
        }
        return sum;
    }
    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true;
        if(!(obj instanceof Node))
            return false;
        int compare= orgStr.compareTo(((Node) obj).orgStr);
        return (compare==0?true:false);
    }

    @Override
    public int compareTo(Node o){
        return sortedStr.compareTo(((Node) o).sortedStr);
    }


}