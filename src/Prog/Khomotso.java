package Prog;
import javax.swing.JOptionPane;

public class Khomotso 
{
    public static void main(String[] args) 
    {
        Login account = new Login();
        
        // User registration
        while (true) 
        {
            //by using JOptionPane, there is no need to import java scanner because the JOptionPane also allows inputs.
            String username = JOptionPane.showInputDialog("Enter username (contains _ and no more than 5 characters):");
            String password = JOptionPane.showInputDialog("Enter password (at least 8 characters, 1 capital, 1 number, 1 special):");
            String firstName = JOptionPane.showInputDialog("Enter first name:");
            String lastName = JOptionPane.showInputDialog("Enter last name:");

            String registrationMessage = account.registerUser(username, password, firstName, lastName);
            JOptionPane.showMessageDialog(null, registrationMessage);
            if (registrationMessage.equals(" User Successfully captured.")) 
            {
                break;
            }
        }

        // User login
        while (true) 
        {
            String username = JOptionPane.showInputDialog("Enter username to log in:");
            String password = JOptionPane.showInputDialog("Enter password to log in:");
            
            String loginMessage = account.loginUser(username, password);
            JOptionPane.showMessageDialog(null, loginMessage);
            if (loginMessage.equals("Welcome back " +username+ " it's nice to see you again!")) 
            {
                JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
                break;
            }
        }

        // Main menu
        while (true) 
        {
            int option = Integer.parseInt(JOptionPane.showInputDialog("1. Add Tasks\n2. Show Report(coming soon)\n3. Quit"));
            
            if (option == 1) 
            {
                int taskCount = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to enter?"));
                Task[] tasks = new Task[taskCount];
                
                for (int i = 0; i < taskCount; i++)
                {
                    String taskName = JOptionPane.showInputDialog("Enter task name:");
                    int taskNumber = i;
                    String taskDescription = JOptionPane.showInputDialog("Enter task description:");
                    while (!Task.checkTaskDescription(taskDescription)) 
                    {
                        taskDescription = JOptionPane.showInputDialog("Please enter a task description of less than 50 characters:");
                    }
                    String developerDetails = JOptionPane.showInputDialog("Enter developer details:");
                    int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));
                    String taskStatus = JOptionPane.showInputDialog("Select task status:\n1. To Do\n2. Doing\n3. Done");
                    
                    tasks[i] = new Task(taskName, taskNumber, taskDescription, developerDetails, taskDuration, taskStatus);
                    JOptionPane.showMessageDialog(null, tasks[i].printTaskDetails());
                }
                
                int totalHours = 0;
                for (Task task : tasks) 
                {
                    totalHours += task.getTaskDuration();
                }
                JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
            } 
            else if (option == 2) 
            {
                JOptionPane.showMessageDialog(null, "Coming soon");
            }
            else if (option == 3) 
            {
                break;
            }
        }
    }
}