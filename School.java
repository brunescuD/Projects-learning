package schoolManagementSystem;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Scanner;

/**This class will corroborate the other two classes
 *
 */
public class School {
    @Getter
    private ArrayList<Teacher> teachers;
    @Getter ArrayList<Student> students;
    private static int totalMoneyReceived =0, totalMoneySpent =0, totalMoneyExpected=0;

    public School(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the number of students to be added: ");
        int numberOfInitialStudents = in.nextInt();

        this.students = new ArrayList<>();

        //create and add the student objects to the students ArrayList
        for (int n=0; n<numberOfInitialStudents; n++){
            Student student = new Student();
            students.add(student);
            student.enroll();
            student.payFee();
        }

        Scanner inTeach = new Scanner(System.in);
        System.out.println("Please enter the number of teachers ");
        int numTeach = inTeach.nextInt();

        this.teachers = new ArrayList<>();

        //create and add the teacher objects to the teacher ArrayList
        for (int n=0; n<numTeach; n++){
            Teacher teacher = new Teacher();
            teachers.add(teacher);
        }
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public static void receiveMoney(int amount){
        totalMoneyReceived+=amount;
    }

    public static void paySalary(int amount){
        totalMoneySpent+=amount;
    }

    public static void accrueMoney(int amount){
        totalMoneyExpected+=amount;
    }


}
