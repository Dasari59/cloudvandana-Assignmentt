import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class employeeManagementSystem {
    static class Employee {
        private int id;
        private String name;
        private BigDecimal salary;

        public Employee(int id, String name, BigDecimal salary) {
            this.id = id;
            this.name = name;
            setSalary(salary); 
        }

        public void displayDetails() {
            System.out.println("Employee Details:");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.printf("Salary: $%,.2f%n", salary);
            System.out.println("-------------------");
        }

        public void setSalary(BigDecimal salary) {
            if (salary.compareTo(BigDecimal.ZERO) > 0) {
                this.salary = salary;
            } else {
                System.out.println("Invalid salary. Salary must be positive.");
                this.salary = BigDecimal.ZERO;
            }
        }

        
        public int getId() { return id; }
        public String getName() { return name; }
        public BigDecimal getSalary() { return salary; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.println("Enter details for 3 employees:");

        for (int i = 0; i < 3; i++) {
            System.out.println("\nEmployee " + (i + 1) + ":");
            
            
            int id = -1;
            while (true) {
                try {
                    System.out.print("Enter ID: ");
                    id = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID. Please enter a number.");
                }
            }

            
            String name = "";
            while (true) {
                System.out.print("Enter Name: ");
                name = scanner.nextLine();
                if (!name.trim().isEmpty()) {
                    break;
                } else {
                    System.out.println("Name cannot be empty!");
                }
            }

           
            BigDecimal salary = BigDecimal.ZERO;
            while (true) {
                try {
                    System.out.print("Enter Salary: ");
                    salary = new BigDecimal(scanner.nextLine());
                    if (salary.compareTo(BigDecimal.ZERO) > 0) break;
                    System.out.println("Salary must be positive.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid salary. Please enter a number.");
                }
            }

            employees.add(new Employee(id, name, salary));
        }

        System.out.println("\nEmployee List:");
        for (Employee emp : employees) {
            emp.displayDetails();
        }

       
    }
}