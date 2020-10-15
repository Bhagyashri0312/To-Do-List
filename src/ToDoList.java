import java.text.ParseException;
import java.util.Scanner;

public class ToDoList {

    static int menu() throws ParseException
    {
        System.out.println("Welcome to the ToDoLy");
        int choice;
        Scanner input= new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("  %55s", "                To Do List          "));
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("%25s","      1- Display List      "));
        System.out.println(String.format("%25s","      2- Add New Task      "));
        System.out.println(String.format("%25s","      3- Update Task       "));
        System.out.println(String.format("%25s","      4- Save & Exit       "));
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println("Pick an option");
        choice= input.nextInt();
        return choice;


    }
}
