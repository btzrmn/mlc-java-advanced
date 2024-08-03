package class06.exercise.companyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee;
            switch (tokens.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if (tokens[4].matches("\\d+")) {
                        int age = Integer.parseInt(tokens[4]);
                        employee = new Employee(name, salary, position, department, age);
                    } else {
                        String email = tokens[4];
                        employee = new Employee(name, salary, position, department, email);
                    }
                    break;
                case 6:
                    String email = tokens[4];
                    int age = Integer.parseInt(tokens[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
                default:
                    employee = new Employee();
                    break;
            }

            if (departments.containsKey(employee.getDepartment())) {
                departments.get(employee.getDepartment()).addEmployee(employee);
            } else {
                Department dep = new Department();
                dep.setName(employee.getDepartment());
                dep.addEmployee(employee);
                departments.put(employee.getDepartment(), dep);
            }
        }

        double maxAverage = 0d;
        String maxAvgSalaryDep = "";

        for (Map.Entry<String, Department> entry : departments.entrySet()) {
            double temp = entry.getValue().calcAverageSalary();
            if (temp > maxAverage) {
                maxAverage = temp;
                maxAvgSalaryDep = entry.getKey();
            }
        }
        Department maxAvgDepartment = departments.get(maxAvgSalaryDep);
        System.out.println("Highest Average Salary: " + maxAvgDepartment.getName());
        maxAvgDepartment.getEmployees().stream()
                .sorted(Comparator.comparing(employee -> employee.getSalary(), Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
}
