package model;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class MainClass {
	
	private static String arraySize;	
	private static byte dataTipe;	
	private static byte howItWillBe;	
	private static byte aleatoryPorcentage;	
	
	public MainClass() {
		
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
    
    public static void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
	
	public static void main(String[] args) throws IOException {
		
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
		
		if(arraySize.length() > 0 && arraySize.length() <= 2147483647) {
			int size = Integer.parseInt(arraySize);
			if(dataTipe == 2) {
				
				int array[] = new int[size];
				
				if(howItWillBe == 2) {					
					array = randomInts(size);
				}	
				
				sort(array, 0, size - 1);
											
				for (int i : array) {
					System.out.println(i);
				}
			}
				
			}
		
	}

}
