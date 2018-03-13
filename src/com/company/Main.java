package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static File leaderBoardFile = new File("leader-board.txt");

    public static void main(String[] args) {
        ArrayList<GameResult> leaderboard = new ArrayList<>();
        loadLeaderBoard(leaderboard);
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

                System.out.println("Do you want to keep playing? yes/no");
                answer = askAnswer();

            } while (answer.equals("yes"));

            System.out.println("Leader Board:");

            leaderboard.sort(Comparator.comparingLong(g -> g.time + g.attempts));
            printLeaderBoard(leaderboard);
            saveLeaderBoard(leaderboard);

            System.out.println("Good bye, have a nice day!");

        } catch (NoSuchElementException e) {
            System.out.println("Goodbye, you've pressed leave combination");
        }
    }

    private static void loadLeaderBoard(ArrayList<GameResult> leaderboard) {
        if (!leaderBoardFile.exists()) {
            return;
        }
        try (Scanner in = new Scanner(leaderBoardFile)) {
            while (in.hasNext()) {
                GameResult r = new GameResult();
                r.userName = in.next();
                r.attempts = in.nextInt();
                r.time = in.nextLong();
                leaderboard.add(r);
            }
        } catch (IOException e) {
            System.out.println("Something wrong. Can't read file leader-board.txt");
        }
    }

    private static void saveLeaderBoard(ArrayList<GameResult> leaderboard) {
        try (PrintWriter out = new PrintWriter(leaderBoardFile)) {
            for (GameResult r : leaderboard) {
                out.printf("%s %d %d\n", r.userName, r.attempts, r.time);
            }
        } catch (IOException e) {
            System.out.println("Something wrong. Can't write file leader-board.txt");
        }
    }

    private static void printLeaderBoard(ArrayList<GameResult> leaderboard) {
//        String fileName = "./leader-board.txt";
//        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
//            stream
//                    .limit(5)
//                    .forEach(System.out::println);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        for (int i = 0; i<=4; i++) {
            GameResult r = leaderboard.get(i);
            System.out.println(r.userName + "\t" + r.attempts + "\t" + r.time / 1000.0);
        }
    }

    private static GameResult DoGame(String userName) {
        int myNum = random.nextInt(100) + 1;

        System.out.println("I've thought of number from 1 to 100, try to guess it.");

        GameResult result = new GameResult();
        result.userName = userName;

        System.out.println("debug " + myNum);
        long t1 = System.currentTimeMillis();
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
                    long t2 = System.currentTimeMillis();
                    result.time = t2 - t1;
                    return result;
                }
            }
        }
        System.out.println("You lost...");
        return null;
    }

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

