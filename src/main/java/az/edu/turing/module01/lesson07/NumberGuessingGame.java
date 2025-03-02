package az.edu.turing.module01.lesson07;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Enter your name");
        String name = sc.nextLine();
        System.out.println("Let the game begin!");

        int target = random.nextInt(101);
        int attempts = 0;
        int[] enteredNumbersArr = new int[1];
        boolean isGameTerminated;

        System.out.println("Guess the number: ");

        while (true) {
            if (!sc.hasNextInt()) {
                System.out.println("Enter an integer again: ");
                sc.nextLine();
                continue;
            }
            int guess = sc.nextInt();

            if (guess < 0 || guess > 100) {
                System.out.println("Your guess is out of range!");
                continue;
            }

            enteredNumbersArr[attempts] = guess;
            attempts++;

            isGameTerminated = checkInput(guess, target, name, false);
            if (isGameTerminated) {
                break;
            }
            enteredNumbersArr = createNewArray(enteredNumbersArr, attempts);
        }
        sc.close();
        sortLargerToSmaller(enteredNumbersArr);

        System.out.println("Your numbers: " + Arrays.toString(enteredNumbersArr));
    }


    public static boolean checkInput(int guess, int target, String name, boolean isGameTerminated) {
        if (guess == target) {
            System.out.println("Congratulations " + name + "!");
            isGameTerminated = true;
        } else if (guess < target) {
            System.out.println("Your number is too small");
        } else {
            System.out.println("Your number is too big");
        }
        return isGameTerminated;
    }

    public static void sortLargerToSmaller(int[] enteredNumbersArr) {
        for (int i = 0; i < enteredNumbersArr.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < enteredNumbersArr.length; j++) {
                if (enteredNumbersArr[j] > enteredNumbersArr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = enteredNumbersArr[i];
            enteredNumbersArr[i] = enteredNumbersArr[minIndex];
            enteredNumbersArr[minIndex] = temp;
        }
    }

    public static int[] createNewArray(int[] enteredNumbersArr, int attempts) {
        int[] newEnteredNumbersArr = new int[attempts + 1];

        for (int i = 0; i < enteredNumbersArr.length; i++) {
            newEnteredNumbersArr[i] = enteredNumbersArr[i];
        }
        return newEnteredNumbersArr;
    }
}