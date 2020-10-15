import java.util.Date;

public class Task {

   private String taskName;
   private String projectName;
   private String status;
   private Date taskDate;

   public Task(String projectName, Date taskDate, String taskName, String status)
   {
       this.taskName = taskName;
       this.projectName= projectName;
       this.status = status;
       this.taskDate = taskDate;
   }

   public String getTaskName()
   {
       return taskName;
   }

   public String getProjectName()
   {
       return projectName;
   }

   public String getStatus()
   {
       return status;
   }

   public Date getTaskDate()
   {
       return taskDate;
   }

    /**
     * @set/modify the Status
     */
    public void setStatus(String setStatus)
    {
        status = setStatus;
    }

    /**
     * @set/modify the Task name
     */
    public void setTaskName(String setTaskName)
    {
        taskName = setTaskName;
    }

    /**
     * @set/modify the Task Description
     */
    public void setProjectName(String setProjectName)
    {
        projectName = setProjectName;
    }

    /**
     * @set/modify the Task Date
     */
    public void setTaskDate(Date setTaskDate)
    {
        taskDate = setTaskDate;
    }


}
