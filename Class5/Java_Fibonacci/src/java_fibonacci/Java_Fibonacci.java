package java_fibonacci;

import java.util.*;

public class Java_Fibonacci {

    public static void main(String[] args) {

        int first = 0, second = 1, third, limit;

        Scanner in = new Scanner(System.in);

        while (true) {
            limit = in.nextInt();
            if (limit != 0) {
                if (limit == 2) {
                    System.out.print(first + " " + (first + second) + "\n");
                } else if (limit == 1) {
                    System.out.print(first + "\n");
                } else {
                    System.out.print(first + " " + (first + second) + " ");

                    for (int i = 2; i < limit; i++) {
                        third = first + second;
                        System.out.print(third + " ");
                        first = second;
                        second = third;
                    }
                    System.out.println("");
                }
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

}
