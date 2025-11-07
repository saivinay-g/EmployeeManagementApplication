package dev.saivinay.employeepayrollmanagementsystem;

import dev.saivinay.employeepayrollmanagementsystem.model.Employee;
import dev.saivinay.employeepayrollmanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        EmployeeService empService = context.getBean(EmployeeService.class);
        while (true){
            System.out.println("\n===== Employee Payroll Management System =====");
            System.out.println("1. Add New Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee by ID");
            System.out.println("4. View All Employees");
            System.out.println("5. Find Employee by ID");
            System.out.println("6. View Highest Paid Employee");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(bf.readLine());
            switch (choice) {
                case 1:
                    Employee e1 = context.getBean(Employee.class);
                    System.out.println("Enter the Employee Name:");
                    String ename = bf.readLine();
                    e1.setEname(ename);
                    System.out.println("Enter the Department Name: ");
                    String department = bf.readLine();
                    e1.setDepartment(department);
                    System.out.println("Enter the role:");
                    String designation = bf.readLine();
                    e1.setDesignation(designation);
                    System.out.println("Enter Salary: ");
                    float salary = Float.parseFloat(bf.readLine());
                    e1.setSalary(salary);
                    System.out.println("Enter Date of Joining: yyyy-MM-dd");
                    LocalDate doj = LocalDate.parse(bf.readLine());
                    e1.setDoj(doj);
                    empService.addEmployee(e1);
                    break;
                case 2:
                    boolean exitUpdateMenu = false;
                    while(!exitUpdateMenu){
                        System.out.println("\n===== Update Employee Details =====");
                        System.out.println("1. Update Name");
                        System.out.println("2. Update Department");
                        System.out.println("3. Update Designation");
                        System.out.println("4. Update Salary");
                        System.out.println("5. Update Date of Joining");
                        System.out.println("6. Back to Main Menu");
                        System.out.print("Enter your choice: ");
                        int uChoice = Integer.parseInt(bf.readLine());
                        int id = 0;
                        if(uChoice!=6){
                            System.out.println("Enter the Employee id:");
                            id = Integer.parseInt(bf.readLine());
                        }
                        switch (uChoice){
                            case 1:
                                System.out.println("Enter the updated Name: ");
                                String uname = bf.readLine();
                                empService.updateEmployeeName(id, uname);
                                System.out.println("Updated Name");
                                break;
                            case 2:
                                System.out.println("Enter the updated Department Name: ");
                                String udept = bf.readLine();
                                empService.updateEmployeeDepartment(id, udept);
                                System.out.println("Updated Department");
                                break;
                            case 3:
                                System.out.println("Enter the updated Designation: ");
                                String udesignation = bf.readLine();
                                empService.updateEmployeeDesignation(id, udesignation);
                                System.out.println("Updated Designation");
                                break;
                            case 4:
                                System.out.println("Enter the Salary to be updated");
                                empService.updateEmployeeSalary(id, Float.parseFloat(bf.readLine()));
                                System.out.println("Updated salary");
                                break;
                            case 5:
                                System.out.println("Enter the updated Date Of Joining (yyyy-MM-dd)");
                                empService.updateEmployeeDoj(id, LocalDate.parse(bf.readLine()));
                                System.out.println("Updated DOJ");
                                break;
                            case 6:
                                exitUpdateMenu=true;
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the Id of the Employee to delete");
                    int id = Integer.parseInt(bf.readLine());
                    empService.deleteEmployeeById(id);
                    break;
                case 4:
                    System.out.println(empService.getEmployees());
                    break;
                case 5:
                    System.out.println("Enter the Employee Id: ");
                    int eid = Integer.parseInt(bf.readLine());
                    System.out.println(empService.getEmployeeById(eid));
                    break;
                case 6:
                    System.out.println(empService.getHighestPaidEmployee());
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Enter a valid choice");
            }

        }
    }

}
