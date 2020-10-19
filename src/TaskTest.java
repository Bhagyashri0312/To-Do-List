
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TaskTest {

    Date date;
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Task taskTest;

    /*
     * Load ArrayList with data.
     */

    @BeforeEach
    void setup() throws ParseException {
        date = format.parse("2018-10-05");
        Task taskTest = new Task("TestProject", date, "TestName", "Open");
    }

    /*
     * verify whether correct ProjectName has been loaded into the ArrayList
     */

    @Test
    void getProjectName() throws ParseException {
        Task taskTest = new Task("TestProject", date, "TestName", "Open");
        assertEquals("TestProject", taskTest.getProjectName());
    }

    @Test

        /*
         * verify for correct taskName in the Arraylist
         */
    void getTaskName() {
        Task taskTest = new Task("TestProject", date, "TestName", "Open");
        assertEquals("TestName", taskTest.getTaskName());
    }

    @Test
        /*
         * verify for correct Status in the Arraylist
         */

    void getStatus() {
        Task taskTest = new Task("TestProject", date, "TaskName", "Open");
        assertEquals("Open", taskTest.getStatus());
    }

    /*
     * Verify for correct Date in the Arraylist
     */

    @Test
    void getTaskDate() {
        Task taskTest = new Task("TestName", date, "ProjectName", "Open");
        assertEquals(date, taskTest.getTaskDate());
    }

    /*
     * Check whether the set method for TaskName,ProjectName,Status and Date gives expected result.
     */

    @Test
    void setGetTaskName() throws ParseException {
        Task taskTest = new Task("TestProject", date, "TestName", "Open");
        taskTest.setProjectName("TestProject");
        assertEquals("TestProject", taskTest.getProjectName());

        taskTest.setTaskName("TestName");
        assertEquals("TestName", taskTest.getTaskName());

        taskTest.setStatus("open");
        assertEquals("open", taskTest.getStatus());

        date = format.parse("2018-10-01");
        taskTest.setTaskDate(date);
        assertEquals(date, taskTest.getTaskDate());

    }

    /*
     * Check whether the set method for TaskName,ProjectName,Status and Date gives expected result.
     */

    @Test
    void setGetTaskNameFailureCheck() throws ParseException {
        Task taskTest = new Task("TestProject", date, "TestName", "Open");
        taskTest.setProjectName("TestProject");
        assertEquals("testProject", taskTest.getProjectName());

        taskTest.setProjectName("TestName");
        assertEquals("testName", taskTest.getTaskName());

        taskTest.setStatus("open");
        assertEquals("Open", taskTest.getStatus());

        date = format.parse("2018-10-01");
        taskTest.setTaskDate(date);
        assertEquals(date, taskTest.getTaskDate());

    }


}

