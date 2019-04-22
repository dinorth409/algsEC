// Dalton North
// CSCI 140; Professor Devanny
// Extra Credit Question Two
package questionTwo;
 
import java.util.Random;

public class QuestionTwo {
	
	// Creates list of random numbers based on size input
	int[] makeSequence(int size) {
		int[] list = new int[size];
		Random rand = new Random();
		
		for (int i = 0; i < size; i++) {
			
			list[i] = rand.nextInt(50);
		}
		
		return list;
	}
	
	// Base 10 RadixSort: https://www.reddit.com/r/javaexamples/comments/73rbk0/radix_sort_using_base10_and_base16/
	public void radixSort(int array[]) {
	    int digitPlace = 1;
	    int n = array.length;
	    int result[] = new int[n];

	    int max = 0;

	    while ( digitPlace == 1 || max / digitPlace > 0) {
	        int count[] = new int[10];

	        for (int each : array) {
	        	
	            if (digitPlace == 1) {
	                if (each > max) {
	                    max = each;
	                }
	            }

	            count[(each / digitPlace) % 10]++;
	        }

	        for (int i = 1; i < 10; i++) {
	            count[i] += count[i - 1];
	        }

	        for (int i = n - 1; i >= 0; i--) {
	            
	            int current = (array[i] / digitPlace) % 10;
	            
	            result[count[current] - 1] = array[i];
	            count[current]--;
	        }

	        System.arraycopy(result, 0, array, 0, n);

	        digitPlace *= 10;
	    }
	}
	
	// radixSortHex: https://www.reddit.com/r/javaexamples/comments/73rbk0/radix_sort_using_base10_and_base16/
	public void radixSortHex(int[] array) {

	    int pos = 0; 
	    int n = array.length;
	    int[] result = new int[n];
	    int max = 1;

	    while (max >> pos > 0) {
	    
	        int[] count = new int[16];

	        for (int each : array) {
	            if (pos == 0) {
	                if (each > max) max = each;
	            }
	            count[(each >> pos) & 0xf]++;
	        }

	        for (int i = 1; i < 16; i++) {
	            count[i] += count[i - 1];
	        }

	        for (int i = n - 1; i >= 0; i--) {
	            int current = (array[i] >> pos) & 0xf;
	            result[count[current] - 1] = array[i];
	            count[current]--;
	        }

	        System.arraycopy(result, 0, array, 0, n);
	        pos += 4;
	    }
	}
	
	int[] cloneArr(int[] arr) {
		int[] result = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
		
		return result;
	}
	
	//BinaryRadixSort: https://www.cs.hmc.edu/~keller/courses/cs60/s98/examples/Sort/radixsort.java
	public void binaryRadixSort(int array[]) {
	    int buffer[]    = new int[array.length];	
	
	    boolean done = false;		
	
	    for( int shiftAmount = 0; !done; shiftAmount++ )
	      {
	
	      int count = 0;			
	
	      done = true;
	
	      for( int i = 0; i < array.length; i++ )
		{
	        int shifted = (array[i] >> shiftAmount); 
	
	        if( shifted > 0 )			
	          done = false;
	
	        if( shifted % 2 == 0 )
	          count++;				  
		}
	
	      if( done )
	        break;
	
	      int lower = 0, upper = count;		
	
	      for( int i = 0; i < array.length; i++ )
		{
	        int shifted = (array[i] >> shiftAmount);
	
	        if( shifted % 2 == 0 )
	          {
	          buffer[lower++] = array[i];
	          }
	        else
	          {
	          buffer[upper++] = array[i];
	          }
		}
	
	      for( int i = 0; i < array.length; i++ )
		{
	        array[i] = buffer[i];
	        }
	      }
    }

	public static void main(String[] args) {
		
		QuestionTwo test = new QuestionTwo();
		int size = 50;			// Changes list size
		
		int[] range = test.makeSequence(size);
		int[] range2 = test.cloneArr(range);
		int[] range3 = test.cloneArr(range);
		
		// print unsorted arr
        for (int n : range) {
            System.out.print(n + " ");
        }
        
        long startTime = System.nanoTime();
        test.radixSort(range);
        long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		double durationInSecs = (double) duration / 1000000.0;
        
		long startTime2 = System.nanoTime();
        test.radixSortHex(range2);
        long endTime2 = System.nanoTime();
		long duration2 = (endTime2 - startTime2);
		double durationInSecs2 = (double) duration2 / 1000000.0;
		
		long startTime3 = System.nanoTime();
        test.binaryRadixSort(range3);
        long endTime3 = System.nanoTime();
		long duration3 = (endTime3 - startTime3);
		double durationInSecs3 = (double) duration3 / 1000000.0;

		System.out.println("\n");
		
		//print sorted arr
        for (int n : range) {
            System.out.print(n + " ");
        }
        
        System.out.println("\nBase 2: " + durationInSecs3);
        System.out.println("Base 10: " + durationInSecs);
        System.out.println("Base 16: " + durationInSecs2);
        
	}

}
