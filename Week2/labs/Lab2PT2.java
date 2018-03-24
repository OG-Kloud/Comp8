
import java.util.Scanner;

public class Lab2PT2 {
	//CONSTANT : conversion rate hours to minutes
	public static final double MINUTES_PER_HOUR = 60;
	//CONSTANT : conversion rate days to hours
	public static final double HOURS_PER_DAY = 24;
	/**
	* Assuming standard month size of 30Days
	* Notice that this is not a constant(not final)
	*/
	public static double daysPerMonth = 30;
	//CONSTANT : conversion rate years to months
	public static final double MONTHS_PER_YEAR = 12;
	/**
	* Used to account for the days lost when assuming 		* standard 30 day months
	*/
	//CONSTANT : accounts for the 31 day in a month
	public static final double YEAR_VARIENCE = 5;
	/**
	* Holds a reference of out Scanner object
	* so that we can access user input
	*/
	public static final Scanner SCAN = new Scanner(System.in);
	// boolean value weather to account for the day varience in		//calculations
	public static boolean varience = true;
	/**
	* @Parm "31daymonths"
	*
	* if no parmiter specified assume months are 30 days and include day variance
	*/
	public static void main(String[] args) {
		if(args.length >= 1) {
			System.out.println(args[0]);
			for(String s : args) {
				if(s.equals("31daymonths")) {
					daysPerMonth = 31;
					varience = false;
				}
			}
			System.out.println(daysPerMonth);
		}
		System.out.println("Please enter a number");
		double years = SCAN.nextDouble();
//		System.out.println(years);
		System.out.println("There are " + calculateNumberOfMinutes(years) + " minutes in " + 
		years + " years");
	}
	/**
	* returns the calculation of the nuber of minutes in a year
	*
	* @parm number of yearsto calculate into minutes
	*/
	public static double calculateNumberOfMinutes(double numberOfYears) {
		double yearsToMonths = numberOfYears * MONTHS_PER_YEAR;
		double monthsToDays = yearsToMonths * daysPerMonth;
		double daysToHours = monthsToDays * HOURS_PER_DAY;
		double hoursToMinutes = daysToHours * MINUTES_PER_HOUR;
//		double minutesToSeconds = hoursToMinutes * SECONDS_PER_MINUTE;
//		double includingVariance = YEAR_VARIENCE * 60 * 60;
		double includingVariance = YEAR_VARIENCE * 24 * 60;
		if(varience) return includingVariance + hoursToMinutes;
		else return hoursToMinutes;
	}
}