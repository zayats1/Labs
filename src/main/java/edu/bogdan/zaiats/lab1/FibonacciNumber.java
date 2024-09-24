package edu.bogdan.zaiats.lab1;

/**
 * stores value and index of a Fibonacci number
 *
 * @param value a real whole number
 * @param idx   position in the sequence
 **/
public record FibonacciNumber(long value, int idx) {

    /**
     * gets a Fibonacci number from the index
     *
     * @param index Position of the num in the sequence
     *              starts from 0
     * @return FibonacciNumber
     **/
    public static FibonacciNumber fromIdx(int index) {
        if (index <= 0) {
            return new FibonacciNumber(0, 0);
        }

        long prev = 0, next = 1;
        int idx = 1;
        for (; idx < index; idx++) {
            long numSum = next + prev;
            prev = next;
            next = numSum;
        }

        return new FibonacciNumber(next, idx);
    }

    /**
     * <pre>
     * Makes next Fibonacci number if the previous_number is it's previous number in the sequence
     * Otherwise return null
     * </pre>
     *
     * @param previous previous Fibonacci Number
     * @return FibonacciNumber
     **/
    public FibonacciNumber next(FibonacciNumber previous) {
        if (!(idx - previous.idx() == 1)) {
            return null;
        }
        return new FibonacciNumber(previous.value() + value, idx + 1);
    }
}



