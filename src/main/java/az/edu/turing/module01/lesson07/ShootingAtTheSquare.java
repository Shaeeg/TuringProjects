package az.edu.turing.module01.lesson07;

import java.util.Scanner;
import java.util.Random;

public class ShootingAtTheSquare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int size = 5;
        int hits = 0;
        int row;
        int col;
        char[][] square = new char[size][size];
        boolean[][] targetSquare = new boolean[size][size];

        System.out.println("All set, get ready to rumble!");

        makeTheSquare(square);
        displayBoard(square);
        setTarget(targetSquare, random, size);

        while (true) {
            if (hits == 3) {
                System.out.println("Congratulations! You won!\n");
                displayBoard(square);
                break;
            }
            row = getValidInput(sc, "Please enter the row", size);
            col = getValidInput(sc, "Please enter the column", size);
            if(square[row][col] == 'X' || square[row][col] == '*') {
                System.out.println("You already shot here, give it another try.");
                displayBoard(square);
                continue;
            }
            if (targetSquare[row][col]) {
                hits++;
                System.out.println("You got one!\n");
                square[row][col] = 'X';
            } else {
                System.out.println("Bad luck, try again!\n");
                square[row][col] = '*';
            }
            displayBoard(square);
        }

    }

    public static void makeTheSquare(char[][] square) {
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                square[i][j] = '-';
            }
        }
    }

    public static void setTarget(boolean[][] targetSquare, Random random, int size) {
        boolean horizontal = random.nextBoolean();
        int row;
        int col;
        if (horizontal) {
            row = random.nextInt(size);
            col = random.nextInt(size - 2);
            for (int i = 0; i < 3; i++) {
                targetSquare[row][col + i] = true;
            }
        } else {
            row = random.nextInt(size - 2);
            col = random.nextInt(size);
            for (int i = 0; i < 3; i++) {
                targetSquare[row + i][col] = true;
            }
        }
    }

    public static int getValidInput(Scanner sc, String message, int size) {
        while (true) {
            System.out.println(message);
            if (sc.hasNextInt()) {
                int input = sc.nextInt();
                if (input >= 1 && input <= size) {
                    return input - 1;
                } else {
                    System.out.println("Please enter a number between 1 and 5.");
                }
            } else {
                System.out.println("Please enter an INTEGER.");
                sc.nextLine();
            }
        }
    }

    public static void displayBoard(char[][] square) {
        System.out.println("0 | 1 | 2 | 3 | 4 | 5 |");

        for (int i = 0; i < square.length; i++) {
            System.out.print((i + 1) + " |");
            for (int j = 0; j < square[i].length; j++) {
                System.out.print(" " + square[i][j] + " |");
            }
            System.out.println();
        }
        System.out.println();
    }

}
