import java.util.Random;
import java.util.Scanner;

public class HeapSort {
	public static int N;
	
	 /* Function to swap two numbers in an array */
    public static void swap(int a[], int i, int j)
    {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp; 
    }    	

public static void sortHeap(int[] a) {
//build max heap from unsorted array	
	 N=a.length-1;
		for(int i=N/2;i>=0;i--){
			max_heapify(a,i);}
//swap elements a[n] with a[0]

	for (int i = N; i > 0; i--)
     {
         swap(a,0, i);
          N= N-1;
         max_heapify(a, 0);
     }
	
	
	
}//end sortHeap

public static void max_heapify(int[] a, int i) {
	
	int left=2*i;
	int right=2*i + 1;
	int max=i; 
	if (left <= N && a[left] > a[i])
         max = left;
     if (right <= N && a[right] > a[max])        
         max = right;
	if(max!=i){
		swap(a,i,max);
		max_heapify(a,max);
	}
}

public static void print(int a[]){
	

	for(int i=0;i<a.length;i++){
		System.out.print(a[i]+" ");
	}

}	
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("Enter the Size of Array");
	Random rand=new Random();
	int n=scan.nextInt();
	int[] a=new int[n];
	for(int i=0;i<n;i++){
		a[i]=rand.nextInt(100);
	}
System.out.println("Unsorted Array: ");			 
print(a);
System.out.println("\nSorted Array: ");
sortHeap(a);
System.out.println("Here is the array");
print(a);
}


}
