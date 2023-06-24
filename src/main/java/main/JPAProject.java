package main;

import Control.EmployeeController;
import jakarta.transaction.Transactional;
import model.Employee;
import java.util.Scanner;

public class JPAProject {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean cont = true;
        int opt;
        
        while(cont){
            System.out.println("1) Enter employee\n2) Search empployee \n3) Delete Employee \n4) Update Employee ");
            System.out.println("Select an option");
            opt = s.nextInt();
            switch(opt){
                case 1:
                    createEmployee(s);
                    break;
                case 2:
                    searchEmployee(s);
                    break;
            }
            
            
            System.out.println("Do you want to continue? (Y/N): ");
            String r = s.next();
            if(!r.equalsIgnoreCase("Y"))
                cont = false;
            
            
        }
    }
    
    public static void createEmployee(Scanner s){
        System.out.println("------------NEW EMPLOYEE------------");
        System.out.println("Enter name: ");

        String name = s.nextLine();
        System.out.println("Enter last name: ");
        String lastName = s.nextLine();
        System.out.println("Enter age: ");
        int age = Integer.parseInt(s.nextLine());
        System.out.println("Enter salary: ");
        float salary = Float.parseFloat(s.nextLine());

        Employee em = new Employee(name, lastName, age, salary);
        EmployeeController emc = new EmployeeController();
        emc.create(em);
    }
    
    public static void searchEmployee(Scanner s){
        System.out.println("----------SEARCH EMPLOYEE------------");
        System.out.println("Enter id: ");
        int id = s.nextInt();
        EmployeeController emc = new EmployeeController();
        Employee em = emc.getById(id);
        System.out.println(em.toString());
    } 
    
    public static void updateEmployee(Scanner r){
        
    }
    
    public static void deleteEmployee(Scanner r){
        
    }
}
