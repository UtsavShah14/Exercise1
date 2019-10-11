//Program to search for a variable using thread
import java.util.*;
public class Excersise {
	public static void main(String args[])
	{
		int n=50;
		int list[] = new int [n];
		int j=0, c=0;      //Initialized for checking the o/p loop
		for(int i=0; i<list.length; i++)
			list[i]= (int) (Math.random()*100);
		
//Check for output
		while(j<list.length) { 
			System.out.println(list[j] + " " + c); 
			j++; 
			c++; 
		}
		
		System.out.print("Enter Number for search: "); //scan the number to search
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
//		System.out.print(x); //check if input works
		
//		Creating a thread instance
		Searcher instance1 = new Searcher(list,0,n/2,x);
		Searcher instance2 = new Searcher(list,n/2,n,x);
		
//		Starting the thread instance
		instance1.start();
		instance2.start();
		
//		Try statement to 'try' joining Syncing the thread outputs
		try{
			instance1.join();
			instance2.join();
		}
//		Catch statement to figure out if there are any exceptions
		catch(InterruptedException e) {
		}
//		Printing results here
		boolean found = instance1.getResult() || instance2.getResult();
		System.out.print(found);
	}
}
