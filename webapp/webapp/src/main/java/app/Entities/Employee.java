package app.Entities;

public class Employee {
    private String Full_name;
    private String Department;
    private int Phone;
    private int Salary;


    public String getFull_name() {
        return Full_name;
    }

    public void setFull_name(String full_name) {
        Full_name = full_name;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        this.Phone = phone;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        this.Salary = salary;
    }

    @Override
    public String toString()
    {
        return this.Full_name + " " + this.Department + " " + this.Phone + " " + this.Salary;
    }

}
