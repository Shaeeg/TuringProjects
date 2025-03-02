package az.edu.turing.module01.lesson04;
import java.util.Scanner;
public class Seasons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the day of the month: ");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the month: ");
        String month = scanner.nextLine();
        System.out.print("The season is: ");
        switch(month) {
            case "January":
                System.out.println("Winter");
                break;
            case "February":
                System.out.println("Winter");
                break;
            case "March":
                System.out.println(day < 20 ? "Winter" : "Spring");
                break;
            case "April":
                System.out.println("Spring");
                break;
            case "May":
                System.out.println("Spring");
                break;
            case "June":
                System.out.println(day < 21 ? "Spring" : "Summer");
                break;
            case "Jule":
                System.out.println("Summer");
                break;
            case "August":
                System.out.println("Summer");
            case "September":
                System.out.println(day < 23 ? "Summer" : "Autumn");
                break;
            case "October":
                System.out.println("Autumn");
                break;
            case "November":
                System.out.println("Autumn");
                break;
            case "December":
                System.out.println(day < 21 ? "Autumn" : "Winter");
            default:
                System.out.println("Wrong date");
                break;
        }
    }
}
