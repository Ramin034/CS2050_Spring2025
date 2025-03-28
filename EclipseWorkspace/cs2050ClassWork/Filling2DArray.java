
public class Filling2DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array1 = new int[3][4];
		int i=0;
		
		for(int row = 0; row < array1.length; row++)
		{
			
			for(int column = 0; column < array1[row].length; column++)
			{
				array1[row][column] = i++;
			}
		}
		

	}

}
