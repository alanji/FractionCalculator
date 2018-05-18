import java.util.Scanner;

public class FractionCalculator
{
	public static void main(String[] args) 
	{
		intro();
		Scanner input = new Scanner(System.in);	
		
		while(true)
		{
		System.out.println("-----------------------------------------------------------------------------------");
		
		String operation = getOperation(input);
		
		Fraction fraction1 = getFraction(input);
		Fraction fraction2 = getFraction(input);
		
		fraction1 = decision(fraction1,fraction2,operation); //Here code decides which calculation it is going to do

		if(fraction1.getNumerator() == fraction1.getDenominator()) // if they are equal
			System.out.println("The result is: 1");
		else if(fraction1.getDenominator() == 1 ) // if the denominator is 1 then there must be only numerator shown
			System.out.println("The result is: "+fraction1.getNumerator());
		else
		System.out.println("The result is: "+fraction1.getNumerator()+"/"+fraction1.getDenominator());
		}
	}
	
	public static void intro()
	{
		System.out.println("This program is a fractation calculator");
		System.out.println("It will add, subtract, multiply and divide fractations until you type Q to quit.");
		System.out.println("Please enter your fractations in the form a/b, where a and b are integers.");
	}
	
	public static String getOperation(Scanner input)
	{
		String temp;
		do
		{
			System.out.print("Please enter an operation ( +, -, /, *, or Q to quit): ");
			temp = input.next();
			input.nextLine(); //this is extra; to catch next line that is thrown by input.next();
			switch (temp) {
			case "Q":
			case "q": System.out.print("Program terminated successfully..."); System.exit(0);
			case "+":
			case "-":
			case "/":
			case "*": break;
			
			default: System.out.print("Invalid operator. ");
			}
				
		}while(!("q".equalsIgnoreCase(temp) || "+".equals(temp) || "-".equals(temp) || "*".equals(temp) || "/".equals(temp)));
		return temp;
	}
	
	public static Fraction getFraction(Scanner input)
	{
		Fraction obj = null;
		String fraction;
		while(true)
		{
			System.out.print("Please enter a fraction (a/b) or (a), where a and b are integers and b is not zero: ");
		
			fraction=input.nextLine();
		
			if (fraction.contains("/")) // divide it to two strings and convert it to int and then do the calculations
			{
				String numerator = fraction.substring(0,fraction.indexOf('/')); // take numerator
				String denominator = fraction.substring(fraction.indexOf('/')+1);
			
				if(isNumber(numerator) && isNumber(denominator))
				{
					if(Integer.parseInt(denominator)==0) // if denominator is zero than give an error
					{
						System.out.print("Invalid fraction. Denominator cannot be zero! ");
						continue;
					}
					obj = new Fraction(Integer.parseInt(numerator),Integer.parseInt(denominator));
					break;
				}
			} 
			else if(isNumber(fraction)) {
				obj = new Fraction(Integer.parseInt(fraction));
				break;
			}

			System.out.print("Invalid fraction. ");
		}
		
		return obj;
	}
	
	public static boolean isNumber(String str)
	{
		if(str.matches("[0-9]+")) // check if the number consists of only digits
			return true;
		else
			return false;
	}
	
	public static Fraction decision(Fraction fraction1, Fraction fraction2, String operation)
	{
		
		switch (operation) 
		{
			case "+": fraction1 = fraction1.add(fraction2);	     break;
			case "-": fraction1 = fraction1.subtract(fraction2); break;
			case "*": fraction1 = fraction1.multiply(fraction2); break;
			case "/": fraction1 = fraction1.divide(fraction2);	 break;
			default: break;
		}
		
		fraction1.toLowestTerms(); // Return the lowest terms of the fraction
		return fraction1;
	}
}
