package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Do you want to play a game with me? yes/no");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        Random random = new Random();

        while (answer.equals("yes")) {

            int myNum = random.nextInt(100) + 1;

//            for (int a = 0; a <= 1; a++) {

            System.out.println("I've thought of number from 1 to 100, try to guess it.");

//            System.out.println(myNum);

            for (int i = 1; i <= 10; i++) {
                int userNum = scanner.nextInt();
                if (i <= 9) {

                    if (myNum > userNum) {
                        System.out.println("Your number is smaller then the one I've thought of.");
                        System.out.println("Number of tries left: " + (10 - i));
                    }
                    if (myNum < userNum) {
                        System.out.println("Your number is bigger then the one I've thought of.");
                        System.out.println("Number of tries left: " + (10 - i));
                    }
                    if (myNum == userNum) {
                        System.out.println("Congrats, you won!!!");
                        System.out.println("---------------------");
                        break;
                    }

                }
                if (i == 10) {

                    if (myNum == userNum) {
                        System.out.println("Congrats, you won!!!");
                        System.out.println("---------------------");
                    } else {
                        System.out.println("You lost...");
                        break;
                    }

                }

//                int userNum = scanner.nextInt();

                //System.out.println(userNum);

//                if (myNum > userNum) {
//                    System.out.println("Your number is smaller then the one I've thought of.");
//                }
//                if (myNum < userNum) {
//                    System.out.println("Your number is bigger then the one I've thought of.");
//                }
//                if (myNum == userNum) {
//                    System.out.println("Congrats, bitch!!!!");
//                    break;
//                }
            }
//            }
            System.out.println("Do you want to keep playing? yes/no");
            answer = scanner.next();
        }
        System.out.println("Good bye, have a nice day!");
    }
}
