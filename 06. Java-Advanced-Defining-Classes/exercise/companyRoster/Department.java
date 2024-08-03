package class06.exercise.companyRoster;


import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private double averageSalary;
    private List<Employee> employees;

    public Department() {
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public double calcAverageSalary() {
        this.averageSalary = employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        return this.averageSalary;
    }
}
