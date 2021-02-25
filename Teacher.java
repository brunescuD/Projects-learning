package schoolManagementSystem;


import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Contract;

import java.util.Scanner;

/**
 We'll use this class to create teachers, using name, id and salary
 */
public class Teacher {
    @Getter final private String teacherId, name;
    @Getter @Setter private int salary;
    private static int id = 500;

    public Teacher(){
        System.out.println("Please enter teacher's name");
        Scanner in = new Scanner(System.in);
        this.name = in.nextLine();
        this.teacherId = generateId();
        id++;
        System.out.println("Please enter teacher's salary:");
        this.salary = in.nextInt();

    }

    public void receiveSalary(){
        School.paySalary(this.salary);
    }

    @Contract(pure = true)
    private String generateId(){
        return id+"";
    }

    @Override
    public String toString(){
        return "Teacher's name is: "+this.name+
                "\nBase salary: $"+this.salary+"\n";
    }
}
