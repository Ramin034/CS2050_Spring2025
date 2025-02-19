
public class SelectionSortTDD
{
	public static void main(String[] args)
	{
		System.out.println("Testing Selection Sort");

		int[][] testCases = { 
				{ 4, 2, 7, 1, 5 }, // Regular case
				{}, // Empty array
				{ 5 }, // Single element
				{ 1, 2, 3, 4, 5 }, // Already sorted
				{ 9, 7, 5, 3, 1 }, // Reverse sorted
				{ 4, 2, 7, 2, 5 } // Array with duplicates
		};

		for (int i = 0; i < testCases.length; i++)
		{
			System.out.println("Test Case " + (i + 1) + ": Before Sorting:");
			printArray(testCases[i]); 
			selectionSort(testCases[i]);
			System.out.println("After Sorting:");
			printArray(testCases[i]);
			System.out.println();
		}
	}



	public static void selectionSort(int[] array)
	{
	    for(int i = 1; i< array.length; i++) {
	    	int key = array[i];
	    	int j = i;
	    	while(j > 0 && array[j-1] > key) {
	    		array[j] = array[j-1];
	    		j--;
	    	}
	    	array[j] = key;
	    }
	}

	public static void printArray(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}


}