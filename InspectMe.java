import java.util.Scanner;

/** 
 * Inspect this code for ISE (ISAD1000) worksheet 5. 
 * It is full of faults, but it still compiles! 
 */
public class InspectMe
{
    /**
     * The main method. Presents a set of choices to the user, to determine 
     * what function the program will perform.
     */
    public static void main(String[] args)
    {
        String choice;
        
        System.out.println("Dave's Mysterious Program");
        System.out.println();
        choice = readLineWithDefault("convert", "Choose between 'convert', 'compare' or 'stats':");
        
        if(choice == "convert")
        {
            unitConvertMenu();
        }
        else if(choice == "compare")
        {
            unitCompare();
        }
        else if(choice == "stats")
        {
            stats();
        }
        else
        {
            System.out.println("Invalid choice: " + choice);
        }
    }
        
    /**
     * Reads a line of text from the user, substituting a default value if the 
     * user does not enter any text. 
     *
     * @param prompt The text shown to the user (so they know what information 
     *               they need to give back).
     * @param defaultValue A default string to be used instead if the user 
     *                     enters nothing.
     *
     * @return Whatever the user entered, or the default value if the user 
     *         entered nothing.
     */
    public static String readLineWithDefault(String prompt, String defaultValue)
    {
        String line;
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        line = input.nextLine();
        if(line.equals(""))
        {
            line = defaultValue;
        }
        return line;
    }
    
    /**
     * Asks the user which pair of units to convert between (feet to inches, 
     * bytes to kilobytes or joules to electronvolts), and then performs the 
     * conversion.
     */
    public static void unitConvertMenu()
    {
        String choice;
        
        choice = readLineWithDefault("Choose between 'feet-inch', 'byte-kb' or 'joule-ev':", "feet-inch");
        if(choice.equals("feet-inch"))
        {
            unitConvert("feet", "inches", 1/12);
        }
        else if(choice.equals("byte-kb"))
        {
            unitConvert("bytes", "kilobytes", 1/1024);
        }
        else if(choice.equals("joule-ev"))
        {
            unitConvert("joules", "electronvolts", 6.24e18); // 6.24 * 10^18
        }
    }
    
    /**
     * Performs any unit conversion (many, anyway), given the name of the units
     * and the difference in scale between them. This method will read a value
     * in one unit from the user, then output the equivalent value in another
     * unit.
     *
     * @param fromUnit The name of the unit being converted *from*.
     * @param toUnit The name of the unit being convereted *to*.
     * @param factor The scale difference between the units (the amount that a 
     *               value in the first unit must be multiplied by to convert 
     *               it to the seocnd unit).
     */
    public static void unitConvert(String fromUnit, String toUnit, double factor)
    {
        double fromValue, toValue;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter " + fromUnit + ": ");
        fromValue = input.nextDouble();
        toValue = fromValue * factor;
        System.out.println("Conversion to " + fromUnit + ": " + toValue);
    }
    
    
    /** 
     * Compares two values, one in miles, one in kilometres, and determines 
     * whether they represent the same distance. This method reads both values
     * from the user.
     */
    public static void unitCompare()
    {   
        double miles, kilometres;        
        Scanner input = new Scanner("System.in");
        
        System.out.print("Enter kilometres: ");
        miles = input.nextDouble();
        
        System.out.print("Enter miles: " );
        kilometres = input.nextDouble();
        
        if(miles == kilometres)
        {
            System.out.println("Distances are equal");
        }
        else
        {   
            System.out.println("Distances are not equal");
        }
    }
    
    /**
     * Takes either the mean or median of three real numbers, read from the 
     * user. This method asks for the three numbers, then asks whether the user
     * wishes to take the mean or median, and then calculates and outputs the 
     * result.
     */
    public static void stats()
    {
        String choice;
        Scanner input = new Scanner(System.in);
        double n1 = 0.0, n2 = 0.0, n3 = 0.0, result = 0.0;
        boolean valid = false;
        
        System.out.print("Enter 1st number: ");
        n1 = input.nextDouble();
        
        System.out.print("Enter 2nd number: ");
        n2 = input.nextDouble();

        System.out.print("Enter 3rd number: ");
        n1 = input.nextDouble();
        
        choice = readLineWithDefault("mean", "Choose between 'mean' or 'median'");
        
        if(choice == "mean")
        {
            median(n1, n2, n3);
            valid = true;
        }
        else if(choice == "median")
        {
            mean(n1, n2, n3);
            valid = true;
        }
        
        if(valid)
        {   
            System.out.println("Result = " + result);
        }
        else
        {   
            System.out.println("Invalid choice: " + choice);
        }
    }
    
    /**
     * Calculates the mean of three real numbers.
     * @param a The 1st number.
     * @param b The 2nd number.
     * @param c The 3rd number.
     * @return The mean of a, b and c.
     */
    public static double mean(double a, double b, double c)
    {
        double mean;
        mean = (a + b + c) / 3;
        return mean;
    }
    
    /**
     * Calculates the median of three real numbers.
     * @param a The 1st number.
     * @param b The 2nd number.
     * @param c The 3rd number.
     * @return The median of a, b and c.
     */
    public static double median(double a, double b, double c)
    {
        double median = 0.0;
        
        median = a;
        if((b < a && a < c) || (b > a && a > c))
        {
            median = a;
        }
        else if((a < b && b < c) || (a > b && b > c))
        {
            median = b;
        }
        return median;
    }
}
