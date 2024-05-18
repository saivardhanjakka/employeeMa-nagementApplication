package com.twg.spring.springhibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.twg.spring.springhibernate.business.EmployeeBusiness;
import com.twg.spring.springhibernate.business.EmployeeBusinessImpl;
import com.twg.spring.springhibernate.entities.Employee;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // create spring container
        ApplicationContext context = new ClassPathXmlApplicationContext("configmetadata.xml");

        EmployeeBusiness employeeBusiness = (EmployeeBusinessImpl) context.getBean("employeeBusinessImpl");

        Scanner scanner = new Scanner(System.in);
        
        boolean exit = false;
        
        while (!exit) {
            System.out.println("Enter 1 to insert");
            System.out.println("Enter 2 to findAll");
            System.out.println("enter 3 to update "); 
            System.out.println("enter 4 to delete");
            System.out.println("enter 5 to exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // insert operation
                    Employee newEmployee = new Employee();
                    System.out.println("Enter employee ID:");
                    newEmployee.setId(scanner.nextInt());
                    System.out.println("Enter employee name:");
                    newEmployee.setEname(scanner.next());
                    System.out.println("Enter employee address:");
                    newEmployee.setAddress(scanner.next());
                    System.out.println("Enter employee contact:");
                    newEmployee.setContact(scanner.next());
                    System.out.println("Enter employee experience:");
                    newEmployee.setExp(scanner.nextInt());

                    employeeBusiness.save(newEmployee);
                    System.out.println("Employee inserted successfully.");
                    break;

                 // Inside the while loop, update the case 2 block like this:
                case 2:
                    // findAll operation
                    List<Employee> employees = employeeBusiness.findAll();
                    for (Employee e : employees) {
                        System.out.println("id: " + e.getId());
                        System.out.println("Name: " + e.getEname());
                        System.out.println("Address: " + e.getAddress());
                        System.out.println("Contact: " + e.getContact());
                        System.out.println("Experience: " + e.getExp());
                        System.out.println("------------------------");
                    }
                    break;


                case 3:
                    // update operation
                    System.out.println("Enter employee ID to update:");
                    int employeeIdToUpdate = scanner.nextInt();
                    Employee employeeToUpdate = employeeBusiness.findById(employeeIdToUpdate);

                    if (employeeToUpdate != null) {
                        System.out.println("Enter new employee name:");
                        employeeToUpdate.setEname(scanner.next());
                        System.out.println("Enter new employee address:");
                        employeeToUpdate.setAddress(scanner.next());
                        System.out.println("Enter new employee contact:");
                        employeeToUpdate.setContact(scanner.next());
                        System.out.println("Enter new employee experience:");
                        employeeToUpdate.setExp(scanner.nextInt());

                        employeeBusiness.update(employeeToUpdate);
                        System.out.println("Employee updated successfully.");
                    } else {
                        System.out.println("Employee with ID " + employeeIdToUpdate + " not found.");
                    }
                    break;

                case 4:
                    // delete operation
                    System.out.println("Enter employee ID to delete:");
                    int employeeIdToDelete = scanner.nextInt();
                    Employee employeeToDelete = employeeBusiness.findById(employeeIdToDelete);

                    if (employeeToDelete != null) {
                        employeeBusiness.delete(employeeToDelete);
                        System.out.println("Employee with ID " + employeeIdToDelete + " deleted successfully.");
                    } else {
                        System.out.println("Employee with ID " + employeeIdToDelete + " not found.");
                    }
                    break;

                case 5:
                    // exit
                    exit = true;
                    System.out.println("you exited");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
