import java.util.Scanner;

class Employee {

    public String name;
    public int id;
    public double salary;


    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }


    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class Main {
    public static Employee[] employees = new Employee[10];
    public static int employeeCount = 0;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Create Employee");
            System.out.println("2. Modify Employee");
            System.out.println("3. Display Employees");
            System.out.println("4. Remove Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createEmployee();
                    break;
                case 2:
                    modifyEmployee();
                    break;
                case 3:
                    displayEmployees();
                    break;
                case 4:
                    removeEmployee();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void createEmployee() {
        if (employeeCount < 10) {
            System.out.print("Enter employee name: ");
            String name = scanner.next();
            System.out.print("Enter employee ID: ");
            int id = scanner.nextInt();
            System.out.print("Enter employee salary: ");
            double salary = scanner.nextDouble();

            Employee employee = new Employee(name, id, salary);
            employees[employeeCount] = employee;
            employeeCount++;
            System.out.println("Employee created successfully!");
        } else {
            System.out.println("Maximum number of employees reached.");
        }
    }

    public static void modifyEmployee() {
        System.out.print("Enter employee ID to modify: ");
        int id = scanner.nextInt();

        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getId() == id) {
                System.out.print("Enter new name: ");
                String name = scanner.next();
                employees[i].setName(name);
                System.out.print("Enter new salary: ");
                double salary = scanner.nextDouble();
                employees[i].setSalary(salary);
                System.out.println("Employee modified successfully!");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void displayEmployees() {
        if (employeeCount == 0) {
            System.out.println("No employees found.");
        } else {
            for (int i = 0; i < employeeCount; i++) {
                employees[i].displayDetails();
                System.out.println();
            }
        }
    }

    public static void removeEmployee() {
        System.out.print("Enter employee ID to remove: ");
        int id = scanner.nextInt();

        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getId() == id) {
                for (int j = i; j < employeeCount - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employeeCount--;
                System.out.println("Employee removed successfully!");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}