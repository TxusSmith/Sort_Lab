package model;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MainClass {
	
	private static String arraySize;	
	private static byte dataTipe;	
	private static byte howItWillBe;	
	private static byte aleatoryPorcentage;	
	
	public MainClass() {
		
	}
	
	// Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
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
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    
    public static void ascendentMergeSort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            ascendentMergeSort(arr, l, m);
            ascendentMergeSort(arr , m+1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    
    public static void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    
    public static void ascendentHeapSort(int arr[])
    {
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    

    // A utility function to get maximum value in arr[]
    public static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    public static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    // The main function to that sorts arr[] of size n using
    // Radix Sort
    public static void ascendentRadixSort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
    
    public static byte[] randomBytes(int size) {
    	
    	byte[] array = new byte[size];
    	
    	int i = 0;
    	
    	while (i < size) {
    		
    		byte x = (byte)ThreadLocalRandom.current().nextInt(0, 120);
    		array[i] = x;
    		
    		i++;
    	}
    	
    	return array;
    	
    }
    
    public static int[] randomInts(int size) {
    	
    	int[] array = new int[size];
    	
    	int i = 0;
    	
    	while (i < size) {
    		
    		int x = ThreadLocalRandom.current().nextInt(0, 2147400000);
    		array[i] = x;
    		
    		i++;
    	}
    	
    	return array;
    	
    }
    
    
    
	
	public static void main(String[] args) throws IOException {
		
		// data reader
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("ingresar numero de elementos a ordenar");
		arraySize = in.readLine();
		
		System.out.println("desea configurar el tipo de datos a ordenar[Y/N]");
		String answer = in.readLine();
		
		if(answer.equals("y") || answer.equals("Y")) {
			System.out.println("que tipo de dato quiere generar \n "
					+ "[{0}Byte, {1}Short, {2}Int, {3}Long, {4}Float, {5}Double]");
		
			answer = in.readLine();
			dataTipe = Byte.parseByte(answer);
			
			System.out.println("como desea que sean generado los valores \n"
					+ "[{0}Ord. ascendente, {1}ord. descendente, {2}aleatorio, {3}dar porcentaje de aleatoriedad]");
			
			answer = in.readLine();
			howItWillBe = Byte.parseByte(answer);
			
			if(howItWillBe == 3) {
				System.out.println("ingrese el porcetaje de aleatoriedad");
				answer = in.readLine();
				aleatoryPorcentage = Byte.parseByte(answer);
			}	
			
		}
		
		// data analysis
		
//		if(arraySize.length() > 0 && arraySize.length() <= 2147483647) {
//			int size = Integer.parseInt(arraySize);
//			if(dataTipe == 2) {
//				
//				int array[] = new int[size];
//				
//				if(howItWillBe == 2) {					
//					array = randomInts(size);
//				}	
//				
//				ascendentMergeSort(array, 0, size - 1);
//											
//				for (int i : array) {
//					System.out.println(i);
//				}
//			}
//				
//			}
		
		for (byte value : randomBytes(5)) {
			System.out.println(value);
		}
		
	}

}
