package az.edu.turing.module1.lesson05;
import java.util.Scanner;
public class MaxArrayElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arr = new int[3];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scanner.nextInt();
        }
        int max = 0;
        for(int i = 0; i < arr.length; i++ ){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
