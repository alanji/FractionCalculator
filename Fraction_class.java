
public class Fraction //Kesir
{
	private int numerator,denominator;
	
	public Fraction()
	{
		this.numerator=0;
		this.denominator=1;
	}
	
	public Fraction(int number)
	{
		this.numerator=number;
		this.denominator=1;
	}
	
	public Fraction(int numerator, int denominator)
	{
		if(denominator==0)
		{
			System.out.println("Denominator cannot be zero!");
			throw new IllegalArgumentException();
		}
		else {				
			this.numerator=numerator;
			this.denominator=denominator;
		}
	}
	
	public int getNumerator(){
		return this.numerator;
	}
	
	public int getDenominator(){
		return this.denominator;
	}
	
	public String toString(){
		return this.numerator+"/"+this.denominator;
	}
	
	public double toDouble() {
		return (double)this.numerator/(double)this.denominator;
	}
	
	public Fraction add(Fraction other) {
		int tempNum, tempDen;
		
		if(this.denominator==other.denominator)
		{
			tempNum = this.numerator + other.numerator;
			tempDen = this.denominator;
		}
		else {
			tempNum = (this.numerator*other.getDenominator()) + (this.denominator*other.getNumerator());
			tempDen = this.denominator*other.getDenominator();
		}
		Fraction temp = new Fraction(tempNum,tempDen);
		return temp;
	}
	
	public Fraction subtract(Fraction other) {
		int tempNum, tempDen;
		
		if(this.denominator==other.denominator)
		{
			tempNum = this.numerator - other.numerator;
			tempDen = this.denominator;
		}
		else {
			tempNum = (this.numerator*other.getDenominator()) - (this.denominator*other.getNumerator());
			tempDen = this.denominator*other.getDenominator();
		}
		Fraction temp = new Fraction(tempNum,tempDen);
		return temp;
	}

	public Fraction multiply(Fraction other) {

		if(other.getDenominator()==0)  //Denominator cannot be zero
			throw new IllegalArgumentException();
		
		int tempNum = this.numerator*other.getNumerator();
		int tempDen = this.denominator*other.getDenominator();
		
		Fraction temp = new Fraction(tempNum,tempDen);
		return temp;
	}
	
	public Fraction divide(Fraction other) {

		if(other.getNumerator()==0)		//Denominator cannot be zero (it is division, that's why we need to look at numerator of other)
			throw new IllegalArgumentException();
		
		int tempNum = this.numerator*other.getDenominator();
		int tempDen = this.denominator*other.getNumerator();
		
		Fraction temp = new Fraction(tempNum,tempDen);
		return temp;
	}
	
	public boolean equals(Object other) // needs to be adjusted: for example -2/3 == 2/-3 and 2/4 == 1/2
	{
		if ((this.numerator==((Fraction) other).getNumerator()) && (this.denominator==((Fraction) other).getDenominator())) 
			return true;
		else 
			return false;
	}
	
	public void toLowestTerms()
	{		
		int gcd = gcd(this.numerator,this.denominator);
		this.numerator /= gcd;
		this.denominator /= gcd;
	}
	
	public int gcd(int num, int den)
	{
		/*int reminder;
		while (num != 0 && den != 0) 
		{
			reminder = num % den;
			den=num;
			reminder = den;
		}
		
		return num;*/
		
		int greatestNumber = 1;
		int temp;
		if(num>den)
			temp=num;
		else
			temp=den;
		
		for (int i = 1; i < temp/2+1; i++) 
		{
			if(num%i==0 && den%i==0)
				greatestNumber=i;
		}
		
		return greatestNumber;
		
	}
}
