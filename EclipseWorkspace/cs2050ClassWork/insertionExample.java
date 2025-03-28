import java.util.Arrays;


public class insertionExample {

	 public static void insertionSort(int[] list) {
		 for (int i = 1; i < list.length; i++) {
			 int value = list[i];
	         int position = i;

	         while (position > 0 && list[position - 1] > value) {
	        	 list[position] = list[position - 1];
	             position = position - 1;
	         }
	         list[position] = value;
	     }
	 }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testList = {8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Start point:  " + Arrays.toString(testList));
        insertionSort(testList);
        System.out.println("Final result: " + Arrays.toString(testList));

	}

}
