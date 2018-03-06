package com.company;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        ArrayList<GameResult> leaderboard = new ArrayList<>();
        try {
            String answer;
            do {
                System.out.println("Hello.");
                System.out.println("What is your name?");
                String name = scanner.next();
                GameResult r = DoGame(name);
                if (r != null) {
                    leaderboard.add(r);
                }
//                System.out.println("Do you want to play a game with me? yes/no");

                System.out.println("Do you want to keep playing? yes/no");
                answer = askAnswer();

            } while (answer.equals("yes"));
            System.out.println("Leader Board:");
            for (GameResult r : leaderboard) {
                System.out.println(r.userName + "\t" + r.attempts);
            }
            System.out.println("Good bye, have a nice day!");
        } catch (NoSuchElementException e) {
            System.out.println("Goodbye, you've pressed leave combination");
        }
    }

    private static GameResult DoGame(String userName) {
//        do {
        int myNum = random.nextInt(100) + 1;

        System.out.println("I've thought of number from 1 to 100, try to guess it.");

        GameResult result = new GameResult();
        result.userName = userName;

        System.out.println("debug " +myNum);

        for (int i = 1; i <= 10; i++) {
            int userNum = askNumber();
            if (i <= 9) {
                if (myNum > userNum) {
                    System.out.println("Your number is smaller then the one I've thought of.");
                    System.out.println("Number of tries left: " + (10 - i));
                } else if (myNum < userNum) {
                    System.out.println("Your number is bigger then the one I've thought of.");
                    System.out.println("Number of tries left: " + (10 - i));
                } else {
                    System.out.println("Congrats, you won!!!");
                    result.attempts = i;
                    return result;
                }
            }
        }
        System.out.println("You lost...");
        return null;
        //           answer = askAnswer();
//        } while (answer.equals("yes"));
    }

//    static String askName(){
//        String
//    }

    static String askAnswer() {
        for (; ; ) {
            String answer = scanner.next();
            answer = answer.toLowerCase();
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
                System.out.println("Please enter a number between 1 and 100.");
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("oops. You must enter a number...");
            }
        }
    }
}

