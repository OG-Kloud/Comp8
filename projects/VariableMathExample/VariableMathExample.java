

public class VariableMathExample {
	
//	Holds the integer amount to use in the math equations
//	storing this in a variable makes it easy to adjust
//	if neccissary
	static int i = 1;


	public static void main(String[] args) {
	      //Generic print to consle ?notice the use of print() instead of println()
	      //to keep the output of the next call on the same line
		System.out.print("The value of the Subtraction method is : ");
	      //Example of storing the return ofa method in 
	      //a variable with the corisponding type
		int x = calcSubtraction(10);
	      //Printing the value of a variable
		System.out.println(x);
	      //Generic print to consle ?notice the use of print() instead of println()
	      //to keep the output of the next call on the same line
		System.out.print("The value of the addition method is : ");
	      //Example : print the return of a method to the
	      //consle without storing the value in a variable
		System.out.println(calcAddition(10));

	}
	/**
	*	calculate the difference of the paramiter and
	*	the value stored in the class variable @<i>
	*/
	public static int calcSubtraction(int var1) {
		return var1 - i;
	}
	/**
	*	calculate the value of the paramiter and the 
	*	value stored in the class variable @<i>
	*/
	public static int calcAddition(int var2) {
		return var2 + i;
	}
}