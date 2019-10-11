
public class Searcher extends Thread{
	int f[], lb, ub, x;
	boolean found=false;
	
//	Parameterized constructor
	Searcher(int f1[], int a, int b, int x){
		f = f1;
		lb = a;
		ub = b;
		this.x=x;
	}
	
//	Main logical code here
	public void run() {
		for (int i = lb; lb < ub; i++) {
			if(f[i]==x) {
				System.out.println("Found @: "+ i);
				found=true;
			}
			lb++;
		}
	}
	
//	Return Output
	boolean getResult() {
		return found;
	}
}