package sideProject;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
    private static boolean isRunning;
    public static Scanner scanner;
    public static ArrayList<String> toDoList = new ArrayList<>();

    private static void addTask() throws NullPointerException {
        System.out.println("Wpisz nazwę taska: ");
        String addTask = scanner.nextLine();
        toDoList.add(addTask);
    }

    private static void deleteTask(){
        System.out.println("Usuń task wpisując jego numer");
        System.out.println(toDoList);
        int deleteTask = scanner.nextInt();
        toDoList.remove(deleteTask);
    }

    public static void showToDoList(){
        int i = 0;
        for (String element : toDoList){
            System.out.println(i + ": " + element);
            i++;
        }
    }

    private static void closeToDoApplication(){
        isRunning = false;
    }


    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("Witaj w aplikacji ToDoAplication!");

        isRunning = true;
        while (isRunning) {
            System.out.println("Wpisz 1, żeby dodać task");
            System.out.println("Wpisz 2, żeby usunąć task");
            System.out.println("Wpisz 3, żeby wyświetlić listę tasków");
            System.out.println("Wpisz 4, żeby zamknąć program");
            System.out.println("Poniżej wpisz liczbę i wciśnij enter");
            String action = scanner.nextLine();

            switch (action) {
                case "1" -> addTask();
                case "2" -> deleteTask();
                case "3" -> showToDoList();
                case "4" -> closeToDoApplication();
            }
        }
    }
}
