package az.edu.turing.module01.lesson07;

import java.util.Scanner;

public class WeekPlanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] weekPlanner = new String[7][2];
        fillTheMatrix(weekPlanner);
        System.out.println("Commands: Get, Schedule, Reschedule, List week");
        while (true) {
            System.out.println("What do you want to do?");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            } else if (input.toLowerCase().startsWith("get")) {
                getDay(weekPlanner, input);
            } else if (input.toLowerCase().startsWith("schedule")) {
                scheduleDay(sc, weekPlanner, input);
            }
            else if(input.toLowerCase().startsWith("reschedule")) {
                String[] inputs = input.split(" ", 2);
                String day = inputs[1];
                boolean shouldcontinue = false;
                for (String[] strings : weekPlanner) {
                    if (day.equalsIgnoreCase(strings[0])) {
                        if (strings[1].equalsIgnoreCase("No Plans")) {
                            System.out.println("You have no plans for " + strings[0] + ". Please try schedule command.");
                            shouldcontinue = true;
                            break;
                        }
                    }
                }
                if(shouldcontinue) {
                    continue;
                }
                scheduleDay(sc, weekPlanner, input);
            }
            else if (input.toLowerCase().startsWith("list")) {
                listTheWeek(weekPlanner);
            } else {
                System.out.println("Sorry, i don't understand you");
            }
        }
    }

    public static void getDay(String[][] weekPlanner, String input) {
        String[] inputs = input.split(" ", 2);
        if(inputs.length < 2) {
            System.out.println("Please enter a day. For example: get Monday\n");
            return;
        }
        String day = inputs[1].trim();
        for (String[] strings : weekPlanner) {
            if (day.equalsIgnoreCase(strings[0])) {
                break;
            }
            System.out.println("There is no such day");
            return;
        }
        switch (day.trim().toLowerCase()) {
            case "monday":
                System.out.println("Your plan for " + day.toLowerCase() + " is: " + weekPlanner[0][1] + ".");
                break;
            case "tuesday":
                System.out.println("Your plan for " + day.toLowerCase() + " is: " + weekPlanner[1][1] + ".");
                break;
            case "wednesday":
                System.out.println("Your plan for " + day.toLowerCase() + " is: " + weekPlanner[2][1] + ".");
                break;
            case "thursday":
                System.out.println("Your plan for " + day.toLowerCase() + " is: " + weekPlanner[3][1] + ".");
                break;
            case "friday":
                System.out.println("Your plan for " + day.toLowerCase() + " is: " + weekPlanner[4][1] + ".");
                break;
            case "saturday":
                System.out.println("Your plan for " + day.toLowerCase() + " is: " + weekPlanner[5][1] + ".");
                break;
            case "sunday":
                System.out.println("Your plan for " + day.toLowerCase() + " is: " + weekPlanner[6][1] + ".");
                break;
            default:
                System.out.println("Sorry, i don't understand you");
                break;
        }
    }

    public static void scheduleDay(Scanner sc, String[][] weekPlanner, String input) {
        String[] inputs = input.split(" ", 2);
        if(inputs.length < 2) {
            System.out.println("Please enter a day. For example: schedule or reschedule Monday\n");
            return;
        }
        String day = inputs[1].trim();
        for (String[] strings : weekPlanner) {
            if (day.equalsIgnoreCase(strings[0])) {
                System.out.println("What is your plan for " + day.toLowerCase() + "?");
                break;
            }
            System.out.println("There is no such day");
            return;
        }
        String task = sc.nextLine();
        switch (day.trim().toLowerCase()) {
            case "monday":
                weekPlanner[0][1] = task;
                break;
            case "tuesday":
                weekPlanner[1][1] = task;
                break;
            case "wednesday":
                weekPlanner[2][1] = task;
                break;
            case "thursday":
                weekPlanner[3][1] = task;
                break;
            case "friday":
                weekPlanner[4][1] = task;
                break;
            case "saturday":
                weekPlanner[5][1] = task;
                break;
            case "sunday":
                weekPlanner[6][1] = task;
                break;
            default:
                System.out.println("Sorry, i don't understand you");
                break;
        }
    }

    public static void listTheWeek(String[][] weekPlanner) {
        for (String[] strings : weekPlanner) {
            if (strings[1].equals("No plans")) {
                System.out.println("You have no plans for " + strings[0].toLowerCase() + ".");
            } else {
                System.out.println("Plan for " + strings[0].toLowerCase() + " is: " + strings[1] + ".");
            }
        }
    }

    public static void fillTheMatrix(String[][] matrix) {
        matrix[0][0] = "Monday";
        matrix[1][0] = "Tuesday";
        matrix[2][0] = "Wednesday";
        matrix[3][0] = "Thursday";
        matrix[4][0] = "Friday";
        matrix[5][0] = "Saturday";
        matrix[6][0] = "Sunday";
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][1] = "No plans";
        }
    }
}