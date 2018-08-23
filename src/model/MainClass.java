package model;

import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MainClass {
	
	public static final int maxLength =  800000000;
	
	private static int arraySize;	
	private static byte dataTipe;	
	private static byte howItWillBe;	
	private static byte aleatoryPorcentage;	
	
	public MainClass() {
		
		arraySize = 0;
		dataTipe = 0;
		howItWillBe = 0;
		aleatoryPorcentage = 0;
		
	}
	
	public static void HeapSort(double arr[])
	{
		int n = arr.length;
		
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);
		
		for (int i=n-1; i>=0; i--)
		{
			double temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr, i, 0);
		}
	}	
	
	public static void heapify(double arr[], int n, int i)
	{
		int largest = i;  
		int l = 2*i + 1;  
		int r = 2*i + 2;  
		
		if (l < n && arr[l] > arr[largest])
			largest = l;
		
		if (r < n && arr[r] > arr[largest])
			largest = r;
		
		if (largest != i)
		{
			double swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			
			heapify(arr, n, largest);
		}
	}
	
	public static void radixSort(int arr[], int n)
	{
		int m = getMax(arr, n);
		
		for (int exp = 1; m/exp > 0; exp *= 10.0)
			countSort(arr, n, exp);
	}
	
	public static int getMax(int arr[], int n)
	{
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}
	
	 public static void countSort(int arr[], int n, int exp)
	    {
	        int output[] = new int[n];
	        int i;
	        int count[] = new int[10];
	        Arrays.fill(count,0);
	 
	        for (i = 0; i < n; i++)
	            count[ (arr[i]/exp)%10 ]++;
	 
	        for (i = 1; i < 10; i++)
	            count[i] += count[i - 1];
	 
	        for (i = n - 1; i >= 0; i--)
	        {
	            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
	            count[ (arr[i]/exp)%10 ]--;
	        }
	 
	        for (i = 0; i < n; i++)
	            arr[i] = output[i];
	    }
	
	public static void mergeSort(double arr[], int l, int r){
		if (l < r){
			int m = (l+r)/2;
			
			mergeSort(arr, l, m);
			mergeSort(arr , m+1, r);
			
			merge(arr, l, m, r);
		}
	}
	
    public static void merge(double arr[], int l, int m, int r){
       
        int n1 = m - l + 1;
        int n2 = r - m;
 
        double L[] = new double [n1];
        double R[] = new double [n2];
 
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
 
        while (i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    public static byte[] randomByte() {
    	
    	byte[] array = new byte[arraySize];
    	ThreadLocalRandom.current().nextBytes(array);
    	
    	return array;
    	
    }    
    
    public static short[] randomShort() {
    	
    	short[] array = new short[arraySize];
    	
    	int i = 0;
    	
    	while (i < arraySize) {
    		
    		array[i] = (short)ThreadLocalRandom.current().nextInt(Short.MIN_VALUE + 10, Short.MAX_VALUE -10);
    		
    		i++;
    	}
    	
    	return array;
    	
    }
    
    public static int[] randomInt() {
    	    	
    	int[] array = new int[arraySize];
    	
    	int i = 0;
    	
    	while (i < arraySize) {
    		
    		array[i] = ThreadLocalRandom.current().nextInt();
    		
    		i++;
    	}
    	
    	return array;
    	
    }
    
    public static long[] randomLong() {
    	
    	long[] array = new long[arraySize];
    	
    	int i = 0;
    	
    	while (i < arraySize) {
    		
    		array[i] = ThreadLocalRandom.current().nextLong();
    		
    		i++;
    	}
    	
    	return array;
    	
    }
    
    public static float[] randomFloat() {
    	
    	float[] array = new float[arraySize];
    	
    	int i = 0;
    	
    	while (i < arraySize) {
    		
    		array[i] = ThreadLocalRandom.current().nextFloat();
    		
    		i++;
    	}
    	
    	return array;
    	
    }  
    
    public static double[] randomDouble() {
    	
    	double[] array = new double[arraySize];
    	
    	int i = 0;
    	
    	while (i < arraySize) {
    		
    		array[i] = ThreadLocalRandom.current().nextDouble();
    		
    		i++;
    	}
    	
    	return array;
    	
    }
	
	public static void main(String[] args) throws IOException {
		
		// data reader
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("ingresar numero de elementos a ordenar");
		boolean done = false;

		// verify that the array doesn't be over the possible
		
		while(!done) {
			
			arraySize = Integer.parseInt(in.readLine());
			
			if (arraySize <= maxLength && arraySize > 0) 
				done = true;
			 else 
				System.out.println(" El valor supera los limites del programa o no es valido \n intente nuevamente");
			
		}
		
		//
		
		System.out.println("desea configurar el tipo de datos a ordenar[Y/N]");
		String answer = in.readLine();
		
		if(answer.equals("y") || answer.equals("Y")) {
			System.out.println("que tipo de dato quiere generar \n "
					+ "[{0}Byte, {1}Short, {2}Int, {3}Long, {4}Float, {5}Double]");
		
			dataTipe = Byte.parseByte(in.readLine());
			
			System.out.println("como desea que sean generado los valores \n"
					+ "[{0}Ord. ascendente, {1}ord. descendente, {2}aleatorio, {3}dar porcentaje de aleatoriedad]");
			
			howItWillBe = Byte.parseByte(in.readLine());
			
			if(howItWillBe == 3) {
				System.out.println("ingrese el porcetaje de aleatoriedad");
				
				aleatoryPorcentage = Byte.parseByte(in.readLine());
			}	
			
		}
		
		System.out.println();
		
		int[] array2 = randomInt();
		for (int i : array2) {
			System.out.println(i);
		}
		System.out.println();
		
		radixSort(array2, arraySize);
		for (int i : array2) {
			System.out.println(i);
		}
		
		System.out.println();
		
		double [] array3 = randomDouble();
		for (double d : array3) {
			System.out.println(d);
		}
		
		System.out.println();
		
		HeapSort(array3);
		for (double d : array3) {
			System.out.println(d);
		}
		
		System.out.println();
		
		double [] array = randomDouble();
		for (double d : array) {
			System.out.println(d);
		}
		
		System.out.println();
		
		mergeSort(array, 0, arraySize);
		for (double d : array) {
			System.out.println(d);
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
		
	}

}
