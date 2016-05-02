import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.TreeMap;
import java.util.Scanner;

public class Count {

	public static void main(String[] args) throws FileNotFoundException {
		TreeMap<String, Integer> wordCount=new TreeMap<String, Integer>();
       readFile(wordCount);
       PrintResult(wordCount);

	}

	private static void PrintResult(TreeMap<String, Integer> wordCount) {
		System.out.println("Word         Count ");
		for(String word:wordCount.keySet()){
			
			System.out.println(word+"            " +wordCount.get(word) );
			
		}
		
	}

	private static void readFile(TreeMap<String, Integer> wordCount) throws FileNotFoundException {
		// TODO Auto-generated method stub
	Scanner scan=new Scanner(new FileReader("D:/EcNeon/Examples/src/input.txt"));	
	int count=0;
	while(scan.hasNext()){
		String input=scan.next();
		
			count=getCount(wordCount,input)+1;
			wordCount.put(input, count);
		
	
	}
	
	}

	private static int getCount(TreeMap<String, Integer> wordCount, String input) {
		if(wordCount.containsKey(input)){
		     return wordCount.get(input);
		}
		else return 0;
	}

}
