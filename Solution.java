import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class Solution {

protected int a=20;
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


	public static void main(String[] args) throws FileNotFoundException {
	//returnDecentNumber();
	//numberOfPerfectSquare();
	cutTheSticks();
	}//end main method

//Given the length of N  sticks, print the number of sticks that are left before each subsequent cut operations.
	private static void cutTheSticks() throws FileNotFoundException{
	File newFile=new File("D:/EcNeon/CodingExamples/src/input.txt");
	Scanner in=new Scanner(newFile);	
	 
     int n = in.nextInt();
     int arr[] = new int[n];
     for(int arr_i=0; arr_i < n; arr_i++){
         arr[arr_i] = in.nextInt();
     }	

     int leftElements,min;
     while(!(isAllElementZero(arr))){
 leftElements=countNonZeroElements(arr);
System.out.println(leftElements);	

min=getMinElement(arr);   

subtractMinFromArray(min,arr);

}//end while loop

}//end  method
	
	
	private static void subtractMinFromArray(int min,int[] a) {
	// TODO Auto-generated method stub
for(int i=0;i<a.length;i++){
	if(a[i]!=0)
	  a[i]=a[i]-min;
}	

}//end subtractMinFromArray

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	    if(root==null) return null;
	    if(root.val>p.val && root.val>q.val){          //if two nodes at left of root
	    	root=lowestCommonAncestor(root.left, p, q);
	        return root;
	    }
	    
	    if(root.val<p.val && root.val<q.val){          //if two nodes at right of root
	    	root=lowestCommonAncestor(root.right, p, q);
	        return root;
	    }
		
		
	    return root;    
	}
	
	
public int reverseDigit() {
        
    
return 0;
}//end method	
//count non-Zero elements in array
	private static int countNonZeroElements(int a[]){
		int count=0;
		for(int i=0;i<a.length;i++){
			if(a[i]!=0){
				count++;
			}
		}
	return count;	
	}

// To check all elements in Array are zero or not
private static boolean isAllElementZero(int[] a){
	boolean flag=false;
	for(int i=0;i<a.length;i++){
		if(a[i]==0){
			flag=true;
		}
		else return false;
	}
	
return flag;
}

	private static int getMinElement(int[] a) {
	// TODO Auto-generated method stub
	int min=0;
		for(int i=0;i<a.length;i++){
		if(a[i]!=0){
			min=a[i];
			break;
		}
	}
	
	for(int i=1;i<a.length;i++){
		if(a[i]!=0 && a[i]<=min){
			min=a[i];
		}
	}
return min;
	}//end getMinElement method


	//Sherlock and Squares
private static void numberOfPerfectSquare() throws FileNotFoundException{
	File newFile=new File("D:/EcNeon/CodingExamples/src/input.txt");
	Scanner scan=new Scanner(newFile);
    int numberOfTestCases =scan.nextInt();

    for(int counter=0;counter<numberOfTestCases;counter++){
      int n1=scan.nextInt();
        int n2=scan.nextInt();
        int count=0;
        for(int number=n1;number<=n2;number++){
            if((int)Math.sqrt(number)*(int)Math.sqrt(number)==number){
                count++;
            }
            
        }//inner for loop
      System.out.println(count);
    
    
    }//outer for loop 
	
}
	
	
	//Sherlock and The Beast
private static void returnDecentNumber() throws FileNotFoundException{
	File newFile=new File("D:/EcNeon/CodingExamples/src/input.txt");
	Scanner scan=new Scanner(newFile);
    int numberOfTestCases =scan.nextInt();

 for(int counter=0;counter<numberOfTestCases;counter++){
	
	StringBuilder output=new StringBuilder();
	 int number=scan.nextInt();
	//for loop for Number of test cases
	 for(int i=0;i<=number;i++){
		if(i%3==0&&(number-i)%5==0){       //fulfill conditions 1 to 3 of decent number
		     
			for(int j=0;j<i;j++){
				output.append("5");    //i%3 So i/3 gives number of 5 in the output.
			}	
		
			for(int j=0;j<(number-i);j++){     
			output.append("3");       //(number-i)%5 So (number-i)/5 gives number of 5 in the output.
		}
		break;
		
		}//if loop
		
	}//inner for loop
	 if(output.length()==0) System.out.println("-1");	
		else 
			System.out.println(output);
	
}
 
 
 scan.close();
	

}
	
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

