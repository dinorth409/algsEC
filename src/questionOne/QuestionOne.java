// Dalton North
// CSCI 140; Professor Devanny
// Extra Credit Question One
package questionOne;

import java.util.Random;

public class QuestionOne {
	
	// Creates list of random numbers based on size input
		int[] makeSequence(int size) {
			int[] list = new int[size];
			Random rand = new Random();
			
			for (int i = 0; i < size; i++) {
				
				list[i] = rand.nextInt(size);
			}
			
			return list;
		}
	
	// Insertion sort: https://gist.github.com/felipernb/3307444
	void insertionSort(int[] arr) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            while (j >= 0 && arr[j] > key) { 
            	arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
        } 
    } 
	
	// Merge sort: https://www.geeksforgeeks.org/merge-sort/
	void merge(int arr[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
        int i = 0, j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    void mergeSort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
  
            mergeSort(arr, l, m); 
            mergeSort(arr , m+1, r); 
  
            merge(arr, l, m, r); 
        } 
    } 
    
    int[] cloneArr(int[] arr) {
		int[] result = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		
		return result;
	}
    
	
	public static void main(String[] args) {
		QuestionOne test = new QuestionOne();
		
		int size = 180; 		// TO CHANGE SIZE OF LIST
		
		// base 10 list
		int[] range = test.makeSequence(size);
		int[] range2 = test.cloneArr(range);
		
		// base 2 list
		int[] range3 = test.cloneArr(range);
		int[] range4 = test.cloneArr(range);
		
		// base 16 list
		int[] range5 = test.cloneArr(range);
		int[] range6 = test.cloneArr(range);
		
		// Converts list to base 2
		for (int i = 0; i < range.length; i++) {
			String result = Integer.toString(range[i], 2);
			range3[i] = Integer.parseInt(result);
			range4[i] = Integer.parseInt(result);
		}
		
		// Converts list to base 16
		for (int i = 0; i < range.length; i++) {
			String result = Integer.toString(range[i], 16);
			range5[i] = Integer.parseInt(result, 16);
			range6[i] = Integer.parseInt(result, 16);
		}
		
		// BASE 10
			// insertionSort testing
			
			System.out.println("Base 10:");
			
			long startTime = System.nanoTime();
			test.insertionSort(range);
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			double durationInSecs = (double) duration / 1000000.0;
			
			System.out.println("Insertion: " + durationInSecs);
			
			// mergeSort testing
			
			long startTime2 = System.nanoTime();
			test.mergeSort(range2, 0, range2.length-1);
			long endTime2 = System.nanoTime();
			long duration2 = (endTime2 - startTime2);
			double durationInSecs2 = (double) duration2 / 1000000.0;
			
			System.out.println("Merge: " + durationInSecs2);
			
			if (duration > duration2) {
				System.out.println("Merge is faster");
			} else {
				System.out.println("Insertion is faster");
			}
		
		// BASE 2
			// insertionSort testing
			
			System.out.println("\nBase 2:");
			
			long startTime3 = System.nanoTime();
			test.insertionSort(range3);
			long endTime3 = System.nanoTime();
			long duration3 = (endTime3 - startTime3);
			double durationInSecs3 = (double) duration3 / 1000000.0;
			
			System.out.println("Insertion: " + durationInSecs3);
			
			// mergeSort testing
			
			long startTime4 = System.nanoTime();
			test.mergeSort(range4, 0, range4.length-1);
			long endTime4 = System.nanoTime();
			long duration4 = (endTime4 - startTime4);
			double durationInSecs4 = (double) duration4 / 1000000.0;
			
			System.out.println("Merge: " + durationInSecs4);
			
			if (duration3 > duration4) {
				System.out.println("Merge is faster");
			} else {
				System.out.println("Insertion is faster");
			}
			
		// BASE 16
			// insertionSort testing
			
			System.out.println("\nBase 16:");
			
			long startTime5 = System.nanoTime();
			test.insertionSort(range5);
			long endTime5 = System.nanoTime();
			long duration5 = (endTime5 - startTime5);
			double durationInSecs5 = (double) duration5 / 1000000.0;
			
			System.out.println("Insertion: " + durationInSecs5);
			
			// mergeSort testing
			
			long startTime6 = System.nanoTime();
			test.mergeSort(range6, 0, range6.length-1);
			long endTime6 = System.nanoTime();
			long duration6 = (endTime6 - startTime6);
			double durationInSecs6 = (double) duration6 / 1000000.0;
			
			System.out.println("Merge: " + durationInSecs6);
			
			if (duration5 > duration6) {
				System.out.println("Merge is faster");
			} else {
				System.out.println("Insertion is faster");
			}
	}

}
