


public class Stats
{
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
