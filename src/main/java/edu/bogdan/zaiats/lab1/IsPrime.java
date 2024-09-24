package edu.bogdan.zaiats.lab1;

/**
 * Tells if the number is prime or not
 */
public final class IsPrime {
    /**
     * Tells if the number is prime or not
     *
     * @param num any whole positive number
     * @return boolean
     */
    public static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

