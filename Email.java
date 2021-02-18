package emailApp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String alternateEmail;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength =10;

    //Constructor receives the first and last name
    public Email(String firstName, String lastName){
        this.lastName = lastName;
        this.firstName = firstName;

        //Call a method that returns the department
        this.department = setDepartment();

        //Call a method that returns the password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your default password is " + this.password);

        //combine elements to generate email
        this.email = firstName.toLowerCase(Locale.ROOT) + "." + lastName.toLowerCase(Locale.ROOT) + "@" + this.department + ".companyname.com";
    }

    //Ask the department
    private String setDepartment() {
        System.out.println("Department codes:\n1 for Sales \n2 for Development \n3 for Accounting \n0 for none\nPlease enter the department code:");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if (departmentChoice == 1) {
            return "sales";
        } else if (departmentChoice == 2) {
            return "development";
        } else if (departmentChoice == 3) {
            return "accounting";
        } else {
            return "";
        }
    }

    //Generate random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
        char[] password = new char[defaultPasswordLength];
        for(int i=0; i<length; i++){
            int rand = (int) (Math.random()*passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    //set the mailbox capacity
    public void setMailboxCapacity(int newCapacity){
        this.mailboxCapacity = newCapacity;
    }

    //set the alternate email
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }
    //change the password
    public void changePassword(String newPass){
        this.password = newPass;
    }
    //get method to display, name and mailbox capacity
    public int getMailboxCapacity(){
        return this.mailboxCapacity;
    }

    public String getName(){
        return (this.firstName + " " + this.lastName);
    }

    public String getAlternateEmail(){
        return this.alternateEmail;
    }

    public String getPassword(){
        return this.password;
    }

    public String showInfo(){
        return "Employee Name: "+this.firstName+" "+this.lastName+
                "\nEmail address: "+this.email+
                "\nMailbox capacity: "+this.mailboxCapacity+" mb";
    }
}
