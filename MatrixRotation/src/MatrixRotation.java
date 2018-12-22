
public class MatrixRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		printMatrix(matrix);
		rotateMatrix(matrix);
		printMatrix(matrix);
	}
	public static void rotateMatrix(int[][] matrix){
		for(int layer = 0;layer<matrix.length/2;layer++){
			int first = layer;
			int last = matrix.length-1-layer;
			for(int offset =0;offset<(last-first);offset++){
				int top = matrix[first][first+offset];
				matrix[first][first+offset] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[first + offset][last];
				matrix[first + offset][last] = top;
			}
		}
	}
	
	public static void printMatrix(int[][] matrix){
		System.out.println("**************************************");
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println("");
		}
	}

}
