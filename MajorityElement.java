import java.util.ArrayList;

//Find if array contains majority element. What is that number 
public class MajorityElement {

	public static void main(String[] args) {
		int[] array={2,2,2,6,6,6,6,6,6,6,7,8};
		int element=findMajorityElement(array);
       
		if(isMajorityElement(array,element)){
        	  System.out.println("Yes: Element is: "+element);
          }
          else System.out.println("No such element");
	}

	private static boolean isMajorityElement(int[] array, int element) {
		int n=array.length;
		int counterElement=0;
		for(int i=0;i<array.length-1;i++)
		if(array[i]==element){
			counterElement++;			
		}
	if(counterElement>(n/2)) return true;
		return false;
	}

	private static int findMajorityElement(int[] array) {
		int n=array.length-1;
		int majorityElement_index=0; int count=1;
		for(int i=1;i<n;i++){
		if(array[majorityElement_index]==array[i]){
			count++;
		}else count--;
		if(count==0){
			majorityElement_index=i;
			count=1;
		}
						
		}//end for loop
		
		return array[majorityElement_index];
	}//end function

}
