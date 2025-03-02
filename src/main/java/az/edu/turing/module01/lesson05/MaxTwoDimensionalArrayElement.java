package az.edu.turing.module01.lesson05;

import java.util.Scanner;

public class MaxTwoDimensionalArrayElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter rows");

        int row = scanner.nextInt();
        System.out.println("Enter columns");
        int column = scanner.nextInt();
        int[][] multiArray = new int[row][column];
        System.out.println("Enter the elements");

        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length; j++) {
                multiArray[i][j] = scanner.nextInt();
            }
        }
        int max = multiArray[0][0];
        int min = max;
        for (int[] ints : multiArray) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
                if (anInt < min) {
                    min = anInt;
                }
            }
        }
        System.out.println("The maximum element is: " + max);
        System.out.println("The minimum element is: " + min);
    }
}
