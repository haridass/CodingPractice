import java.util.LinkedList;
import java.util.Queue;

class Point{
	public int x;
	public int y;
	Point(int x, int y){
		this.x =x;
		this.y = y;
	}
	@Override
	public int hashCode(){
		return x*y;
	}
	public boolean equals(Object o){
		if(!(o instanceof Point)){
			return false;
		}
		Point op = (Point)o;
		if(this.x == op.x && this.y==op.y){
			return true;
		}else
			return false;
	}
}
public class LargestBlob {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] matrix = {{"r","b","b"},
							{"b","b","b"},
							 {"w", "w", "b"}};
		System.out.println(largestBlob(matrix));
	}
	public static int largestBlob(String[][] m){
		Queue<Point> que = new LinkedList<Point>();
		int rowLength = m.length;
		int colLength = m[0].length;
		int maxBlob = Integer.MIN_VALUE;
		
		for(int i=0;i<rowLength;i++){
			for(int j=0;j<colLength;j++){
				int currentBlob = 0;
				if(m[i][j] != null){
					Point p = new Point(i,j);
					String pColor = m[i][j];
					que.add(p);
					while(!que.isEmpty()){
						Point q = que.poll();
						m[q.x][q.y] = null;
						currentBlob = currentBlob +1;
						maxBlob = maxBlob > currentBlob?maxBlob:currentBlob;
						if(q.x -1 >= 0 && q.y>= 0 && m[q.x-1][q.y]!=null && m[q.x-1][q.y] ==  pColor ){
							m[q.x-1][q.y] = null;
							que.add(new Point(q.x-1,q.y));
						}
						if(q.x +1 < rowLength && q.y >= 0 && m[q.x+1][q.y]!=null && m[q.x +1][q.y] ==  pColor){
							m[q.x+1][q.y] = null;
							que.add(new Point(q.x+1,q.y));
						}
						if(q.x >= 0 && q.y -1 >= 0 && m[q.x][q.y-1]!=null && m[q.x][q.y-1] ==  pColor){
							m[q.x][q.y-1] = null;
							que.add(new Point(q.x,q.y-1));
						}
						if(q.x >= 0 && q.y +1 < colLength && m[q.x][q.y+1]!=null && m[q.x][q.y+1] ==  pColor){
							m[q.x][q.y+1] = null;
							que.add(new Point(q.x,q.y+1));
						}
					}
				}
			}
		}
		return maxBlob;
	}
}
