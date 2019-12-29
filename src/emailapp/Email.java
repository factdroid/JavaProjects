package emailapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private String password;
    private String alternateEmail;
    private int mailBoxCapacity;
    private boolean depSet;
    private String companyDomain = "mentlo.com";

    //Done Constructor with starts with firstName and lastName
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("Email Created: "+this.firstName +" "+this.lastName);

        //Done call a method asking for the department on the console: Returns a String
       this.department = getDepartment();
        System.out.println("Department is: "+ this.department);
        this.password = randomPassword(8);
        System.out.println("Password is :"+ this.password);

        //Done combine fields to create the email for the user
        this.email = firstName+"."+lastName+"@"+department+"."+companyDomain;
        System.out.println("Your email address is: "+this.email);
    }

    //Setters for class variables(fields)
    //Done: set method for change password
    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    //Done: method to set mailBoxCapacity
    public void setMailBoxCapacity(int newMailBoxCapacity){
        this.mailBoxCapacity = newMailBoxCapacity;
    }

    //Done: method to set an alternate email address
    public void setAlternateEmail(String newAlternateEmail){
        this.alternateEmail = newAlternateEmail;
    }

    //Done: set department
    public void setDepartment(String newDepartment){
        this.department = newDepartment;
    }

    //Todo: Getters for class variables
    public int getMailBoxCapacity(){
        return mailBoxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    //Done: method which asks for deparmtent and returns a String
    private String getDepartment(){
        System.out.println("Department Codes: \n1 for Sales\n2 for Development\n3 for Accounting\nIf none, leave blank\nEnter Department Code:");
        Scanner in = new Scanner(System.in);
        try {
            int depChoice = in.nextInt();

            //keep checking to make sure user enters the range of expected inputs
            while (!depSet){
                if (depChoice < 1 || depChoice > 3){
                    System.out.println("Invalid, Please enter an integer within the range");
                    depChoice = in.nextInt();
                }else if (depChoice == 1){
                    depSet = true;
                    return "sales";
                }else if (depChoice == 2){
                    depSet = true;
                    return "development";
                }else if (depChoice == 3){
                    depSet = true;
                    return "accounting";
                }else {
                    depSet = true;
                    return "";
                }
            }
        }catch (InputMismatchException exception){
            System.out.println("Please you can only enter an integer");
            //in.next();
        }
        return "";
    }

    //Done: Generate random password
    private String randomPassword (int length){
        String stringSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%^&*";
        char[] password = new char[length];
        for (int i = 0; i < length ; i++) {
           int rand = (int) (Math.random() * stringSet.length());
           password[i] = stringSet.charAt(rand);
        }
        return new String(password).toLowerCase();
    }



    //Todo get method to display the name, email and mailBoxCapacity
    public String showInfo(){
        return "Display Name :"+this.firstName+" "+lastName+"\nCompany Email :"+this.email+"\nMailbox Capacity: "+mailBoxCapacity+"mb";
    }

}
