import java.util.Random;


public class Practice03Test {

	protected int count = 0;
	protected double [] arr;


	/**
	 * Constructor
	 */
	public Practice03Test (String [] args) {
		try {
			count = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Defaulting array size to 20.");
			count = 20;
		}
		arr = new double[count];
		generate_array();
	}


	/**
	 * print_array: prints the array of doubles... formatted so it fits
	 * ... on many small screens.
	 */
	public void print_array() {
		System.out.println("------------------------------------");
		System.out.println("Array contains the values:");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%.2f ", arr[i]);
			if (i > 0 && i % 9 == 0)
				System.out.println();
		}
		System.out.println("\n------------------------------------");
	}


	/**
	 * Fills the array with random double instances.
	 */
	public void generate_array() {
		Random rand = new Random();
		double min = 1.0;
		double max = 100.0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = min + rand.nextDouble() * (max-min);
		}
	}


	public int find_min_iterative (){
		int m;
		m = 0; 
		for(int i = 0; i<arr.length-1; i++){
			if(arr[i]<=arr[m]){
				m = i; 
			}
		}
	return m;				
	}
	
	public int find_min_recursive(){  // overide
		return find_min_recursive (0,0);
	}

	public int find_min_recursive (int i, int m) {
		if(i == arr.length-1){ //one char in the array
			return m;
		}
		if(arr[m]>= arr[i]){
			return find_min_recursive(i+1, i);
		}
		else 
			return find_min_recursive(i+1, m);
	}
	
	


	/**
	 * print_min: determines the min iteratively and recursively.
	 * ... and prints them both.
	 */
	public void print_min() {
		System.out.println("Iteratively determined min at index " + find_min_iterative());
		System.out.println("Recursively determined min at index " + find_min_recursive());
	}


	/**
	 * main for Practice 03: print the array and determine the min.
	 */
	public static void main(String [] args) {
		Practice03Test test = new Practice03Test(args);
		test.print_array();
		test.print_min();
	}

}
