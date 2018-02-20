package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        for (int a = 0; a <= 9999; a++) {
            Random random = new Random();
            Scanner scanner = new Scanner(System.in);

            System.out.println("I've thought of number from 1 to 100, try to guess it.");

            int myNum = random.nextInt(100) + 1;

            //System.out.println(myNum);

            for (int i = 1; i <= 10; i++) {
                if (i<=9) {
                    System.out.println("Number of tries left: " + (11 - i));
                }
                if (i==10) {
                    System.out.println("It's your last try this game.");
                }

                int userNum = scanner.nextInt();

                //System.out.println(userNum);

                if (myNum > userNum) {
                    System.out.println("Your number is smaller then the one I've thought of.");
                }
                if (myNum < userNum) {
                    System.out.println("Your number is bigger then the one I've thought of.");
                }
                if (myNum == userNum) {
                    System.out.println("Congrats, bitch!!!!");
                    break;
                }
            }
        }
    }
}
