package az.edu.turing.module01.lesson06;

import java.util.Scanner;

public class ArrayPrinter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int[] intArr = new int[sc.nextInt()];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = sc.nextInt();
        }
        printArray(intArr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("index: " + i + " value: " + arr[i]);
            System.out.println();
        }
    }
}
