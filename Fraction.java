/**
 * Mandaran Krishnakumar
 * This Java Class (Fraction) performs various operations with fractions 
 * (eg. add/subtract, multiply/divide, reciprocal, exponents, Arithmetic/Geometric sequences, etc.)
 */

public class Fraction {
	private int numerator;	// integer variable for the numerator
	private int denominator;	// integer variable for the denominator
	
	/**
	 * Setting numerator and denominator to 0 and 1, respectively.
	 */
	public Fraction()
	{
		numerator = 0;
		denominator = 1;
	}
	/**
	 * Assigns numerator and denominator to the values of a and b, respectively.
	 * @param a the numerator of a fraction
	 * @param b the denominator of a fraction
	 */
	public Fraction(int a, int b)
	{
		numerator = a;
		denominator = b;
		if(b == 0)		// if the denominator is 0, the fraction is undefined
			System.out.println("ERROR, fraction undefined.");
	}
	/**
	 * Creating fraction f (the second fraction)
	 * @param f fraction object
	 */
	public Fraction(Fraction f)
	{
		numerator = f.numerator;
		denominator = f.denominator;
	}
	
	
	
	/**
	 * Adds Fraction f to the original fraction.
	 * @param f the second Fraction, to be added.
	 * @return the sum as a Fraction in lowest terms.
	 */
	public Fraction add(Fraction f)
	{
		int f_den = denominator*f.denominator;	// common denominator: the product of both denominators
		int f_num = numerator*f.denominator;
		int s_den = f.denominator*denominator;
		int s_num = f.numerator*denominator;
		int num = f_num+s_num;	// adding both numerators
		
		Fraction sum = new Fraction(num, f_den);
		sum = sum.simplify();	// fraction in lowest terms
		return sum;
	}
	/**
	 * Subtracts Fraction f from the original fraction.
	 * @param f the second Fraction, to be subtracted.
	 * @return the difference as a Fraction in lowest terms.
	 */
	public Fraction subtract(Fraction f)
	{
		int f_den = denominator*f.denominator;	// common denominator: the product of both denominators
		int f_num = numerator*f.denominator;
		int s_den = f.denominator*denominator;
		int s_num = f.numerator*denominator;
		int num = f_num-s_num;	// subtracting both numerators
		
		Fraction difference = new Fraction(num, f_den);
		difference = difference.simplify();
		return difference;
	}
	/**
	 * Multiplies Fraction f from the original fraction.
	 * @param f the second Fraction, to be multiplied.
	 * @return the product as a Fraction in lowest terms.
	 */
	public Fraction multiply(Fraction f)
	{
		int num = numerator*f.numerator;	// multiplying both numerators and both denominators
		int den = denominator*f.denominator;
		Fraction product = new Fraction(num, den);
		product = product.simplify();
		return product;
	}
	/**
	 * Divides Fraction f from the original fraction.
	 * @param f the second Fraction, to be divided.
	 * @return the quotient as a Fraction in lowest terms.
	 */
	public Fraction divide(Fraction f)
	{
		int num = numerator*f.denominator;	// first fraction multiplied by the reciprocal of Fraction f
		int den = denominator*f.numerator;
		Fraction quotient = new Fraction(num, den);
		quotient = quotient.simplify();
		return quotient;
	}
	/**
	 * Changes the Fraction to its reciprocal fraction.
	 * @return the reciprocal of this Fraction.
	 */
	public Fraction reciprocal()
	{
		int num = denominator;	// switching places of the numerator and denominator
		int den = numerator;
		
		Fraction recip = new Fraction(num, den);
		recip = recip.simplify();
		return recip;
		
	}
	/**
	 * The original Fraction raised to the power of e.
	 * @param e an integer representing the exponent.
	 * @return the Fraction raised to the power of e, in lowest terms.
	 */
	public Fraction pow(int e)
	{
		int num = numerator;
		int den = denominator;
		
		int p_num = (int) Math.pow(num, Math.abs(e));		// numerator and denominator to the power e
		int p_den = (int) Math.pow(den, Math.abs(e));
		
		int e_num = p_num;	// numerator and denominator with exponents
		int e_den = p_den;
		if(e < 0)		// if exponent is negative, get reciprocal of fraction
			e_num = p_den;
			e_den = p_num;
		
		Fraction power = new Fraction(p_den, p_num);
		power = power.simplify();
		return power;
	}
	/**
	 * Simplifies the Fraction (into lowest terms).
	 * @return the Fraction in simplified form (lowest terms).
	 */
	public Fraction simplify()
	{
		Fraction fraction = new Fraction(numerator, denominator);
		Fraction one = new Fraction(1, 1);	// in case Fraction = 1
		if(numerator == denominator)	// if numerator = denominator, return 1/1
			return one;
		int low_num = 0;
		// finding the lower (absolute value) number between the numerator and denominator
		if(Math.abs(numerator) < Math.abs(denominator))
			low_num = numerator;
		else if(Math.abs(numerator) > Math.abs(denominator))
			low_num = denominator;
		else
			// if fraction = 1 (numerator and denominator are same absolute value number), return the fraction
			return fraction;
		
		while(low_num > 1)
		{
			// if either numerator or denominator isn't divisible by the lower number of the two,
			// decrease the low number variable by 1
			if(numerator%low_num != 0)
				low_num = low_num - 1;
			else if(denominator%low_num != 0)
				low_num = low_num - 1;
			else
				break;	// if both are divisible (greatest common divisor), exit loop
		}
		
		int s_num = numerator / low_num;	// dividing both numerator and denominator by the low_num (to get lowest terms)
		int s_den = denominator / low_num;
		
		
		Fraction simplified = new Fraction(s_num, s_den);
		return simplified;
	}
	/**
	 * Determines whether a Fraction is proper or not proper.
	 * @return true if Fraction is proper, false if not proper.
	 */
	public boolean proper()
	{
		// if numerator is less than denominator, then fraction is proper
		if(numerator < denominator)
			return true;
		else
			return false;
	}
	/**
	 * Finds out if two Fractions are equal to each other.
	 * @param f the second Fraction, to be compared to the first fraction.
	 * @return true if both Fractions are equal, false if not equal.
	 */
	public boolean isEqual(Fraction f)
	{
		// converting both fractions to decimal numbers to determine if they are equal
		double f_fraction = (double) numerator / denominator;
		double s_fraction = (double) f.numerator / f.denominator;
		if(f_fraction == s_fraction)
			return true;
		else
			return false;
	}
	/**
	 * Finds out if the original fraction is greater than Fraction f.
	 * @param f the second Fraction, to to be compared to the first fraction.
	 * @return true if the original fraction is greater, false if not greater.
	 */
	public boolean isGreater(Fraction f)
	{
		// converting both fractions to decimal numbers, 
		// to determine if the first decimal is greater than the second decimal
		double f_fraction = (double) numerator / denominator;
		double s_fraction = (double) f.numerator / f.denominator;
		if(f_fraction > s_fraction)
			return true;
		else
			return false;
	}
	/**
	 * Finds out if the original fraction is less than Fraction f.
	 * @param f the second Fraction, to to be compared to the first fraction.
	 * @return true if the original fraction is less, false if not less.
	 */
	public boolean isLess(Fraction f)
	{
		// converting both fractions to decimal numbers, 
		// to determine if the first decimal is less than the second decimal
		double f_fraction = (double) numerator / denominator;
		double s_fraction = (double) f.numerator / f.denominator;
		if(f_fraction < s_fraction)
			return true;
		else
			return false;
	}
	/**
	 * Calculates the sum of an array of Fractions.
	 * @param f the array of Fractions.
	 * @return the fraction sum of the array of Fractions, in lowest terms.
	 */
	public Fraction sum(Fraction[] f)
	{
		Fraction f1 = new Fraction(numerator, denominator);
		for(int i = 0; i < f.length; i++)
		{
			f1 = f1.add(f[i]);	// a loop to add each element to the total sum of the array
		}
		f1 = f1.simplify();
		return f1;
	}
	/**
	 * Calculates the product of an array of Fractions.
	 * @param f the array of Fractions.
	 * @return the fraction product of the array of Fractions, in lowest terms.
	 */
	public Fraction product(Fraction[] f)
	{
		int num = 1;
		Fraction f1 = new Fraction(num, denominator);
		for(int i = 0; i < f.length; i++)
		{
			f1 = f1.multiply(f[i]);		// a loop to multiply each element to the total product of the array
		}
		f1 = f1.simplify();
		return f1;
	}
	/**
	 * Gets the String representation of the Fraction.
	 * @return the string representation of the Fraction.
	 */
	public String toString()
	{
		// a string consisting of the numerator and denominator with a "/" between
		String strFraction = "";
		strFraction = strFraction + numerator + "/" + denominator;
		return strFraction;
	}
	/**
	 * Converts the Fraction into a mixed fraction and gets the string representation.
	 * @return the string representation of the Fraction in mixed form.
	 */
	public String toStringMixed()
	{
		int whole_num = numerator / denominator;	// rounds down to an integer number
		int num = numerator % denominator;			// the remainder of the integer number above
		int den = denominator;
		Fraction fract = new Fraction(num, den);	
		fract = fract.simplify();					// simplifying the fraction
		// space in between whole number and fraction
		String mixed = whole_num + " " + fract.numerator + "/" + fract.denominator;
		return mixed;
	}
	
	
	
	/**
	 * Creates the Arithmetic Sequence using the parameters given.
	 * @param a the starting fraction of the sequence.
	 * @param d the common difference between fractions.
	 * @param n the number of fractions in the sequence.
	 * @return Fraction Arithmetic Sequence array (in lowest terms) from the parameters.
	 */
	public Fraction[] arithmeticSequence(Fraction a, Fraction d, int n)
	{
		Fraction[] arrArithmetic = new Fraction[n];
		arrArithmetic[0] = a;	// the first term in the sequence
		for(int i = 1; i < arrArithmetic.length; i++)
		{
			a = a.add(d);	// creating the next term in the sequence
			arrArithmetic[i] = a;
		}
		
		return arrArithmetic;
	}
	/**
	 * Creates the Geometric Sequence using the parameters given.
	 * @param a the starting fraction of the sequence.
	 * @param r the common ratio between fractions.
	 * @param n the number of fractions in the sequence.
	 * @return Fraction Geometric Sequence array (in lowest terms) from the parameters.
	 */
	public Fraction[] geometricSequence(Fraction a, Fraction r, int n)
	{
		Fraction[] arrGeometric = new Fraction[n];
		arrGeometric[0] = a;	// the first term in the sequence
		for(int i = 1; i < arrGeometric.length; i++)
		{
			a = a.multiply(r);	// creating the next term in the sequence
			arrGeometric[i] = a;
		}
		
		return arrGeometric;
	}
	/**
	 * Calculates the sum of a given Arithmetic Sequence.
	 * @param f Arithmetic Sequence array with Fraction terms.
	 * @return the sum of the Arithmetic Sequence Fraction terms (in lowest terms).
	 */
	public Fraction arithmeticSeries(Fraction[] f)
	{
		int num = numerator;
		int den = denominator;
		Fraction sum = new Fraction(num, den);
		for(int i = 0; i < f.length; i++)
		{
			sum = sum.add(f[i]);	// adding each term in the sequence to the total sum
		}
		sum = sum.simplify();
		return sum;
	}
	/**
	 * Calculates the sum of a given Geometric Sequence.
	 * @param f Geometric Sequence array with Fraction terms.
	 * @return the sum of the Geometric Sequence Fraction terms (in lowest terms).
	 */
	public Fraction geometricSeries(Fraction[] f)
	{
		int num = numerator;
		int den = denominator;
		Fraction sum = new Fraction(num, den);
		for(int i = 0; i < f.length; i++)
		{
			sum = sum.add(f[i]);	// adding each term in the sequence to the total sum
		}
		sum = sum.simplify();
		return sum;
	}
	
	
}
