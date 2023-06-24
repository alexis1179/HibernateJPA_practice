package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Employee {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="employee_id")
    private int id;
    
    private String name;
    
    @Column(name="last_name")
    private String lastname;
    private int age;
    private float salary;

    public Employee() {
    }
    
    
    public Employee(String name, String lastname, int age, float salary) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.salary = salary;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", lastname=" + lastname + ", age=" + age + ", salary=" + salary + '}';
    }
    
    
    
}
