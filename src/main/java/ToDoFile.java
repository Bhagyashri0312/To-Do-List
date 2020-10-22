/***
 * TodoFile Reads the inputFile text file. It Adds new Todo Task details to Arraylist.
 * Edit the existing Task details.
 * Delete the existing Task details. Also Write the details back to text file
 */


import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;


public class ToDoFile {
    static String fileName = "ToDoList.txt";
    static Scanner input = new Scanner(System.in);
    private final ArrayList<Task> task = new ArrayList<>();
    private int statusOpen = 0;
    private int statusClosed = 0;
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");


    /* Display the ToDo list data from arraylist*/

    public void showInput() {
        int counter = 0;
        int choice;

        System.out.println("Please enter your choice for sorting:");
        System.out.println("1. Sort based on Date");
        System.out.println("2. Sort based on Project Name");
        choice = input.nextInt();
        if (choice == 1) {
            task.sort(Comparator.comparing(Task::getTaskDate));
        } else if (choice == 2) {
            task.sort(Comparator.comparing(Task::getProjectName));
        }

        String format1 = "%-15s %-38s %-33s %-38s %-15s";
        System.out.printf((format1) + "%n", "Task Number", " Project Name", "Date", "Task Name", "Status");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");

        for (Task file : task) {
            counter = counter + 1;

            System.out.printf((format1) + "%n", counter, file.getProjectName(), file.getTaskDate(), file.getTaskName(), file.getStatus());
            String changeCase = file.getStatus();
            if (changeCase.equals("Open")) {
                statusOpen = statusOpen + 1;
            } else if (changeCase.equals("Closed")) {
                statusClosed = statusClosed + 1;
            }
        }
        System.out.println("Number of tasks open: " + statusOpen);
        System.out.println("Number of tasks closed: " + statusClosed);
        statusOpen = 0;
        statusClosed = 0;


    }

    public void fileReader() throws FileNotFoundException {
        Date date = null;

        BufferedReader inFile = new BufferedReader(new FileReader(fileName));
        String str;
        try {
            while ((str = inFile.readLine()) != null) {
                String[] arr = str.split(" ; ");
                try
                {
                    date = format.parse(arr[1]);
                }
                catch (ParseException p)
                {
                    System.out.println("Error while reading the Date field");
                }

                task.add(new Task(arr[0], date, arr[2], arr[3]));

            }
            inFile.close();
            System.out.println();
        }
        catch (IOException ioe)
        {
            System.out.println("Can't access file.");
        }


    }

    public void fileWriter() throws IOException {

        try {

            PrintWriter outFile = new PrintWriter(new FileWriter(fileName));

            for (Task out : task) {
                outFile.print(out.getProjectName() + " ; " +   format.format(out.getTaskDate())  + " ; " + out.getTaskName() + " ; " + out.getStatus() +"\n");
            }

            outFile.close();
            System.out.println();
        }
        catch (IOException ioe)
        {
            System.out.println("Can't access file.");
        }


    }

    // Add record to the file
    public void addRecord(String projectName, Date taskDate, String taskName, String status) throws IOException, ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //* Get the current date. Consider only the Date portion for comparison

        Date today = new Date();
        Date todayDate = format.parse(format.format(today));
        Date inputDate = format.parse(format.format(taskDate));

        if (inputDate.compareTo(todayDate) < 0) {
            System.out.println("Date Entered should be greater than today");
        } else {
            task.add(new Task(projectName, taskDate, taskName, status));
        }

    }

    // Edit record in the file
    public void editRecord(int editIndex, String inputField, int changeField) throws IOException, ParseException {
        Date date = null;

        if (changeField == 1) {
            task.set(editIndex, new Task(inputField, task.get(editIndex).getTaskDate(), task.get(editIndex).getTaskName(), task.get(editIndex).getStatus()));
        }

        if (changeField == 2) {

            try {
                date = format.parse(inputField);
            } catch (ParseException p) {
                System.out.println(" Error occurred while editing the arraylist record");
            }

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            // Get the current date. Consider only the Date portion for comparison

            Date today = new Date();
            Date todayDate = format.parse(format.format(today));
            Date inputDate = format.parse(format.format(date));

            if (inputDate.compareTo(todayDate) < 0) {
                System.out.println("Date Entered should be greater than today");
            } else {
                task.set(editIndex, new Task(task.get(editIndex).getProjectName(), date, task.get(editIndex).getTaskName(), task.get(editIndex).getStatus()));
            }
        }
        if (changeField == 3) {
            task.set(editIndex, new Task(task.get(editIndex).getProjectName(), task.get(editIndex).getTaskDate(), inputField, task.get(editIndex).getStatus()));
        }
        if (changeField == 4) {
            task.set(editIndex, new Task(task.get(editIndex).getProjectName(), task.get(editIndex).getTaskDate(), task.get(editIndex).getTaskName(), inputField));
        }
    }


    // Delete record in the file
    public void deleteRecord(int removeIndex) throws IOException {
        task.remove(removeIndex);

        System.out.println("Record deleted successfully ");
    }


}

