package java_calculator;

import java.util.*;

public class Java_calculator {

    public static void main(String[] args) {
        float number1, number2;
        String o;
        char[] operator;

        Scanner in = new Scanner(System.in);

        while (true) {
            number1 = in.nextFloat();
            number2 = in.nextFloat();

            o = in.next();

            operator = o.toCharArray();

            switch (operator[0]) {
                case '+':
                    System.out.println(number1 + number2);
                    break;
                case '-':
                    System.out.println(number1 - number2);
                    break;
                case '*':
                    System.out.println(number1 * number2);
                    break;
                case '/':
                    System.out.println(number1 / number2);
                    break;
                default:
                    System.out.println("Wrong input.");
                    break;
            }
        }

    }

}
