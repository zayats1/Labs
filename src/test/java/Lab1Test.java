
import edu.bogdan.zaiats.lab1.FibonacciNumber;
import org.junit.jupiter.api.Test;

import static edu.bogdan.zaiats.lab1.IsPrime.isPrime;
import static org.junit.jupiter.api.Assertions.*;


public class Lab1Test {
    @Test
    public void isPrimeTest (){
        assertTrue(isPrime(2));
        assertTrue(isPrime(3));
        assertTrue(isPrime(5));
        assertTrue(isPrime(7));
        assertTrue(isPrime(47));
    }

    @Test
    public void isNotPrimeTest (){
        assertFalse(isPrime(0));
        assertFalse(isPrime(1));
        assertFalse(isPrime(4));
        assertFalse(isPrime(9));
        assertFalse(isPrime(81));
        assertFalse(isPrime(49));
        assertFalse(isPrime(69));
        assertFalse(isPrime(42));
    }

    @Test
    public void fromIndexFibonacciTest (){
       assertEquals(new FibonacciNumber(0,0), FibonacciNumber.fromIdx(0));
       assertEquals(new FibonacciNumber(1,1), FibonacciNumber.fromIdx(1));
       assertEquals(new FibonacciNumber(1,2), FibonacciNumber.fromIdx(2));
       assertEquals(new FibonacciNumber(2,3), FibonacciNumber.fromIdx(3));
       assertEquals(new FibonacciNumber(3,4), FibonacciNumber.fromIdx(4));
    }


    @Test
    public void nextFibonacciTest (){
        var prev = new FibonacciNumber(1,2);
        var curr = new FibonacciNumber(2,4);
        assertEquals(new FibonacciNumber(4,3), curr.next(prev));
    }
}
