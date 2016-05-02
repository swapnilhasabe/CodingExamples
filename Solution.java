import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class Solution {

//Using hashtable: extra space O(n)  // Time O(n)
	public static boolean isAnagram(String str1, String str2) {
		//create hashtable to keep count of occurence of each character in string 1
		Hashtable<Character, Integer> anagram=new Hashtable<>();
		int count=0;
		//if Both strings lengths are equal then go for other conditions checking
		if(str1.length()==str2.length()){
			// store each character and their occurence
			for(int i=0;i<str1.length();i++){
				if(!anagram.containsKey(str1.charAt(i))){
					count=1;
					anagram.put(str1.charAt(i),count );
				}
				else{
					count=anagram.get(str1.charAt(i));
					count++;
					anagram.replace(str1.charAt(i), count);
				}
			}//end for loop
			// Now compare string2 with hashtable character		
			for(int i=0;i<str2.length();i++){
				if(!anagram.containsKey(str2.charAt(i))){   //if hashtable does not contain character then return false
					return false;
				}
				else{
					count=anagram.get(str2.charAt(i));	  //if yes then decrease its count for each occurence
					count--;
					anagram.replace(str2.charAt(i), count);
				}

			}		
			for(int i=0;i<str1.length();i++){            //check all the counts of every character zero
				if(anagram.get(str1.charAt(i))!=0){return false;}  //if not then false
			}
			return true;	                                       //otherwise its true
		}//end if
		return false;     //if lengths are not equal



	}


	public static void main(String[] args) {

		
	Scanner scan=new Scanner(System.in);
    
    scan.close();
	}//end main method

private static int searchCircularArray(int[] a, int low, int high, int x) {
		// TODO Auto-generated method stub
while(low<=high){
	int mid=(low+high)/2;
	//if x is middle element
	if(x==a[mid]) return mid;
	//if x is in the sorted right subset
	else if(a[mid]<=a[high]){
		if(x>a[mid] && x<=a[high]) low=mid+1;
		else high=mid-1;
	}
	//if x is in the sorted left subset
	else if(a[low]<=a[mid]){
		if(x>a[low]&&x<=a[mid]) high=mid-1;
		else low=mid+1;
	}
}		
return -1;	
}


//merge elements in B into A in sorted order
	private static void merge(int[] a, int[] b, int m, int n) {
		// TODO Auto-generated method stub
	int i=m-1,j=n-1,k=a.length-1;	
	 
	while(i>=0 && j>=0){
		if(a[i]>b[j]){
			a[k]=a[i];
		i--;
		}
		else {
			a[k]=b[j];
		     j--;
		}
		
		    k--;
	}
	while(i>=0){
		a[k]=a[i];
		k--;i--;
	}
	while(j>=0){
		a[k]=b[j];
		k--;j--;
	}
	
	
	
	}//end function



}//end class

