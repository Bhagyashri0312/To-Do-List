
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



    public class ToDoFile {
    static String fileName = "ToDoList.txt";
    static Scanner input= new Scanner(System.in);
    private ArrayList<Task> task= new ArrayList<Task>();
    private int option;
    private int task_num;
    private int statusOpen=0;
    private int statusClosed=0;
    private boolean setExit= false;
    private String inputText1, inputText2, inputText3 ;
    DateFormat format= new SimpleDateFormat("yyyy-mm-dd");


    /* Display the ToDo list data from arraylist*/

    public void showInput()
    {
        int counter=0;
        int choice;

        System.out.println("Please enter your choice for sorting:");
        System.out.println("1. Sort based on Date");
        System.out.println("2. Sort based on Project Name");
        choice=input.nextInt();
        if(choice == 1)
        {
            task.sort((Task t1, Task t2)-> t1.getTaskDate().compareTo(t2.getTaskDate()));
        }
        else if(choice == 2)
        {
            task.sort((Task t1, Task t2) -> t1.getProjectName().compareTo(t2.getProjectName()));
        }

        String format1 = "%-9s %-40s %-43s %-12s %-15s";
        System.out.println(String.format(format1, "Task Number", " Project Name", "Date", "Task Name", "Status" ));
        System.out.println("------------------------------------------------------------------------------------------------------");

        for(Task file: task)
        {
            counter=counter+1;

            System.out.println(String.format(format1, counter, file.getProjectName(), file.getTaskDate(), file.getTaskName(), file.getStatus()));
            String changeCase= file.getStatus();
            if(changeCase.equals("Open"))
            {
                statusOpen= statusOpen+1;
            }
            else if(changeCase.equals("Closed"))
            {
                statusClosed= statusClosed+1;
            }
        }
        System.out.println("Number of tasks open: " +statusOpen);
        System.out.println("Number of tasks closed: " +statusClosed);
        statusOpen = 0;
        statusClosed = 0;


    }

    public void fileReader()
    {
        Date date=null;
        try
        {
            Scanner inFile = new Scanner(new FileReader(fileName));
            String str;

            int number = 1;
            while ((str= inFile.nextLine()) != null)
            {
                String str1 = str.toString();
                String[] arr = str1.split(" || ");

                try{
                    date= format.parse(arr[3]);
                }
                catch (ParseException p)
                {
                    System.out.println("Error while reading the date");
                }

                task.add(new Task(arr[0], date, arr[2], arr[3]));
            }

            inFile.close();
            System.out.println();
        }

        catch(IOException ioe)
        {
            System.out.println("Can't access file.");
        }


    }

    public void fileWriter() throws IOException
    {

        try
        {

            //Scanner input = new Scanner(System.in);
            PrintWriter outFile = new PrintWriter(new FileWriter(fileName, true));

            for(Task out: task )
            {
                outFile.print(out.getProjectName() +" || " +out.getTaskDate() +" || " +out.getTaskName() +" || " +format.format(out.getTaskDate())+"\n");
            }

            outFile.close();
            System.out.println();
        }
        catch (IOException ioe)
        {
            System.out.println("Can't access file.");
        }


    }


    public void editRecord(int editIndex,String inputField,int changeField) throws IOException, ParseException

    {
        Date date = null;

        if (changeField == 1)
        {
            task.set(editIndex,new Task(inputField,task.get(editIndex).getTaskDate(),task.get(editIndex).getTaskName(),task.get(editIndex).getStatus()));
        }

        if (changeField == 2)
        {

            try
            {
                date = format.parse(inputField);
            }
            catch(ParseException p)
            {
                System.out.println(" Error occurred while editing the arraylist record");
            }

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            // Get the current date. Consider only the Date portion for comparison

            Date today = new Date();
            Date todayWithZeroTime = formatter.parse(formatter.format(today));
            Date inputDateWithZeroTime = formatter.parse(formatter.format(date));

            if (inputDateWithZeroTime.compareTo(todayWithZeroTime)<0)
            {
                System.out.println("Date Entered should be greater than today");
            }
            else
            {
                task.set(editIndex,new Task(task.get(editIndex).getProjectName(),date,task.get(editIndex).getTaskName(),task.get(editIndex).getStatus()));
            }
        }
        if (changeField == 3)
        {
            task.set(editIndex,new Task(task.get(editIndex).getProjectName(),task.get(editIndex).getTaskDate(),inputField,task.get(editIndex).getStatus()));
        }
        if (changeField == 4)
        {
            task.set(editIndex,new Task(task.get(editIndex).getProjectName(),task.get(editIndex).getTaskDate(),task.get(editIndex).getTaskName(),inputField));
        }
    }

        public void deleteRecord(int removeIndex) throws IOException
        {
            task.remove(removeIndex);

            System.out.println("Record deleted successfully ");
        }



}

