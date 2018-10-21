package _02_Integer_Stack;

public class IntegerStack {
	//1. create a private array of integers
	private int [] thing;
	//2. complete the constructor by initializing the member array
	//   to a new array of length 0. This prevents null pointer exceptions.
	public IntegerStack() {
		thing=new int[0];
	}
	
	//3. Complete the steps in the push method.
	public void push(int v) {
		//A. create a new array that is one element larger than the member array
		int [] seuss=new int[thing.length+1];
		//B. set the last element of the new array equal to the integer passed into the method
		seuss[thing.length]=v;
		//C. iterate through the member array and copy all the elements into the new array
		for (int i = 0; i < thing.length; i++) {
			seuss[i]=thing[i];
		}
		//D. set the member array equal to the new array.
		thing=seuss;
	}
	
	//4. Complete the steps in the pop method.
	public int pop() {
		//A. create an integer variable and initialize it to the
		//   last element of the member array.
		int wonka=thing[thing.length-1];
		//B. create a new array that is one element smaller than the member array
		int [] chocolate=new int [thing.length-1];
		//C. iterate through the new array and copy every element from the
		//   member array to the new array
		for (int i = 0; i < chocolate.length; i++) {
			chocolate[i]=thing[i];
		}
		//D. set the member array equal to the new array
		thing=chocolate;
		//E. return the variable you created in step A
		return wonka;
	}
	
	//5. Complete the clear method to set the
	//   member array to a new array of length 0
	public void clear() {
		thing=new int [0];
	}
	
	//6. Complete the size array to return 
	//   the length of the member array
	public int size() {
		return thing.length;
	}
}
