package az.edu.turing.module1.lesson05;
import java.util.Scanner;

public class MaxArrayElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int [] arr = new int[scanner.nextInt()];
        System.out.println("Enter the elements");
        for(int i = 0; i < arr.length; i++){
            arr[i] = scanner.nextInt();
        }
        int max = 0;
        for(int i = 0; i < arr.length; i++ ){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.print("The max element is: ");
        System.out.println(max);
    }
}
