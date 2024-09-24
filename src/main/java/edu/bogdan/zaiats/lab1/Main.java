package edu.bogdan.zaiats.lab1;

import java.util.ArrayList;
import java.util.Scanner;

import static edu.bogdan.zaiats.lab1.IsPrime.isPrime;

/**
 * <pre>
 * ЛР 1
 * Виконав ст. гр. ОІ-11СП
 * Програма визначає й опрацьовує задані числа Фібоначчі (1, 1, 2, 3, 5, … ) або Люка (1, 3, 4, 7, 11, …).
 * Номер числа та інші вхідні дані користувач має можливість передати через командний рядок,
 * або в іншому випадку вводить з клавіатури.
 * ## індивідуальне завдання
 * Визначити, які числа серед перших N чисел Фібоначчі є простими.
 * Аргументи:
 * --from_idx
 * генерує числа від заданої точки
 * </pre>
 * Ліміт - 69
 *
 * @author Богдан Заяць
 * @version 1.0
 **/
public class Main {
    private static final String FLAG = "--from_idx";
    private static final int LIMIT = 69;

    /**
     * args --from_idx
     */
    public static void main(String[] args) {
        var reader = new Scanner(System.in);
        int idx = 0;

        if (args.length > 1) {
            System.err.println("Too many args");
            return;
        }

        if (args.length == 1) {
            var flag = args[0];
            if (flag.equals(FLAG)) {
                System.out.println("Enter the index of a Fibonacci number");
                idx = reader.nextInt();

                if (idx < 0) {
                    System.err.println("negative index");
                    return;
                }
            } else {
                System.err.println("incorrect flag");
                return;
            }
        }

        System.out.println("Enter the len of  Fibonacci sequence numbers");
        int seq_len = reader.nextInt();

        if (seq_len <= 0) {
            System.err.println("You get none of the Fibonacci numbers");
            return;
        }
        if (seq_len + idx > LIMIT) {
            System.err.println("You want too much from my pc");
            return;
        }
        var sequence = getFibonacciSequence(idx, seq_len);
        System.out.println("Fibonacci sequence");
        sequence.forEach(i -> {
            var is_prime = isPrime(i.value());
            System.out.printf("index %5d, value %5d, is prime: %b, \n", i.idx(), i.value(), is_prime);
        });
    }

    /**
     * getFibonacciSequence
     *
     * @param seq_len Length of the Fibonacci sequence
     * @return ArrayList<FibonacciNumber>
     **/
    private static ArrayList<FibonacciNumber> getFibonacciSequence(int start_idx, int seq_len) {
        var sequence = new ArrayList<FibonacciNumber>();
        sequence.addFirst(FibonacciNumber.fromIdx(start_idx));

        if (seq_len <= 1) {
            return sequence;
        }

        sequence.add(FibonacciNumber.fromIdx(start_idx + 1));

        for (int i = 2; i < seq_len; i++) {
            var current = sequence.get(i - 1).next(sequence.get(i - 2));
            sequence.add(current);
        }
        return sequence;
    }
}
