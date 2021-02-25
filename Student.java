package schoolManagementSystem;


import lombok.Getter;
import lombok.Setter;
import java.util.Scanner;


/**We'll keep track of students:
 * id
 * name
 * fees
 * seniority
 */
public class Student {
    @Getter final private String studentId, name;
    @Getter private String courses ="";
    @Getter @Setter private int grade;
    @Getter private int tuitionBalance=0;
    @Setter int courseCost = 100;
    private static int id = 100;

    /**
     we are going to set following parameters:
     *  name - students name
     *  grade - seniority, 1-4
     */
    public Student(){
        System.out.println("Please enter student's name:");
        Scanner in = new Scanner(System.in);
        this.name = in.nextLine();
        System.out.println("Class level codes:\n1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nPlease enter student's class level:");
        this.grade = in.nextInt();
        this.studentId = setStudentId();
        id++;

    }

    private String setStudentId(){
        return id+"";
    }

    public void enroll(){
        String course;
        do {
            System.out.println("Please enter the course to enroll or Q to quit:");
            Scanner in = new Scanner(System.in);
            course = in.nextLine();
            if (!course.equals("Q")){
                courses += "\n" + course;
                tuitionBalance+=courseCost;
                School.accrueMoney(courseCost);
            }
        } while (!course.equals("Q"));
    }

    public void payFee(){
        System.out.println("Amount to be paid: ");
        Scanner in = new Scanner(System.in);
        int paidAmt = in.nextInt();
        this.tuitionBalance -= paidAmt;
        School.receiveMoney(paidAmt);
    }

    @Override
    public String toString(){
        return "Student's name: "+this.name+
                "\nTuition Balance: $"+this.tuitionBalance+"\n";
    }
}
