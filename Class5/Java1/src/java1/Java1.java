package java1;

import java.util.*;

public class Java1 {
    public static void main(String[] args) {
        
        float result;
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter you grade point : ");

        while (true) {
            result = in.nextFloat();
            if (result >= 2 && result < 3) {
                System.out.println("Your grade is C.");
            } else if (result >= 3 && result < 3.5) {
                System.out.println("Your grade is B.");
            } else if (result >= 3.5 && result < 4) {
                System.out.println("Your grade is A-.");
            } else if (result >= 4 && result < 5) {
                System.out.println("Your grade is A.");
            } else if (result == 5) {
                System.out.println("Your grade is A+.");
            } else {
                System.out.println("You failed.");
            }
        }

    }

}
