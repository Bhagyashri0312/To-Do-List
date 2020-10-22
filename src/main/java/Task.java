
/***
 * Task class has the details of ProjectName, TaskName, TaskDate, Status.
 */

import java.util.Date;

public class Task {

    private String taskName;
    private String projectName;
    private String status;
    private Date taskDate;

    public Task(String projectName, Date taskDate, String taskName, String status) {

        this.projectName = projectName;
        this.taskDate = taskDate;
        this.taskName = taskName;
        this.status = status;

    }



    public String getProjectName() {
        return projectName;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }



    /**
     * @set/modify the Status
     */
    public void setStatus(String setStatus) {
        status = setStatus;
    }

    /**
     * @set/modify the Task name
     */
    public void setTaskName(String setTaskName) {
        taskName = setTaskName;
    }

    /**
     * @set/modify the Task Description
     */
    public void setProjectName(String setProjectName) {
        projectName = setProjectName;
    }

    /**
     * @set/modify the Task Date
     */
    public void setTaskDate(Date setTaskDate) {
        taskDate = setTaskDate;
    }


}
