// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 7; page ??
// Can be run from command line
// See PrintPrimes.num for a numbered version.
// No JUnit tests at this time

/** *****************************************************
 * Finds and prints n prime integers
 * Jeff Offutt, Spring 2003
 ********************************************************* */
public class PrintPrimes
{
    private static boolean isDivisible (int i, int j)
    {
        if (j%i == 0)
            return true;
        else
            return false;
    }

    public static String printPrimes (int n)
    {
        int curPrime;           // Value currently considered for primeness
        int numPrimes;          // Number of primes found so far.
        boolean isPrime;        // Is curPrime prime?
        int [] primes = new int [100]; // The list of prime numbers.

        // Initialize 2 into the list of primes.
        primes [0] = 2;
        numPrimes = 1;
        curPrime  = 2;
        while (numPrimes < n)
        {
            curPrime++;  // next number to consider ...
            isPrime = true;
            for (int i = 0; i <= numPrimes-1; i++)
            {   // for each previous prime.
                if (isDivisible (primes[i], curPrime))
                {  // Found a divisor, curPrime is not prime.
                    isPrime = false;
                    break; // out of loop through primes.
                }
            }
            if (isPrime)
            {   // save it!
                primes[numPrimes] = curPrime;
                numPrimes++;
            }
        }  // End while
        // Print all the primes out.
//        for (int i = 0; i <= numPrimes-1; i++)
//        {
//            System.out.println ("Prime: " + primes[i]);
//        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<= numPrimes - 1; ++i){
            sb.append("Prime: " + primes[i]);
            if(i != numPrimes - 1){
                sb.append("\n");
            }
        }
        return sb.toString();
    }  // end printPrimes
}
