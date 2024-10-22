package Prog;
public class Login 
{
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public boolean checkUsername(String username) 
    {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) 
    {
        return password.length() >= 8 &&
               password.chars().anyMatch(Character::isUpperCase) &&
               password.chars().anyMatch(Character::isDigit) &&
               password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));
    }

    public String registerUser(String username, String password, String firstName, String lastName) 
    {
        if (!checkUsername(username)) 
        {
            return "Username not correctly formatted";
        } else if (!checkPasswordComplexity(password)) 
        {
            return "Password not correctly formatted";
        } else 
        {
            this.username = username;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
            return "Successfully captured and pass captured";
        }
    }

    public String loginUser(String username, String password) 
    {
        if (this.username.equals(username) && this.password.equals(password)) 
        {
            return "Welcome "+ username + " It's nice to see you again..";
        } else {
            return "Incorrect information, let's try again";
        }
    }
}