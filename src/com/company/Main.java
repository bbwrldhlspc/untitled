package com.company;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("Do you want to play a game with me? yes/no");

            String answer = askAnswer();
            Random random = new Random();


            while (answer.equals("yes")) {

                int myNum = random.nextInt(100) + 1;

//            for (int a = 0; a <= 1; a++) {

                System.out.println("I've thought of number from 1 to 100, try to guess it.");

                System.out.println(myNum);

                for (int i = 1; i <= 10; i++) {
                    int userNum = askNumber();
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
                answer = askAnswer();
            }
            System.out.println("Good bye, have a nice day!");


        } catch (NoSuchElementException e) {
            System.out.println("Goodbye, you've pressed leave combintation");

        }
    }

    static String askAnswer() {
        for (; ; ) {
            String answer = scanner.next();
            if (answer.equals("yes")) {
                return answer;
            }
            if (answer.equals("no")) {
                return answer;
            }
            System.out.println("You must enter only yes or no");
        }
    }

    static int askNumber() {

        for (; ; ) {
            try {
                int num = scanner.nextInt();
                if (num <= 100 && num >= 1) {
                    return num;
                }
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("oops. You must enter a number...");
                System.out.println("Wrong number. Must be between 1 and 100");
            }
        }
    }
// static int askNumber() {
//        int num;
//        do {
//            num = scanner.nextInt();
//            if (num > 100 || num < 1) {
//                System.out.println("Numer is somewhere between 1 and 100");
//            }
//        } while (num > 100 || num < 1);
//        return num;
//    }
}

