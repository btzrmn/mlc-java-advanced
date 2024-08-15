package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return this.employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        if (this.employees.size() == 0) {
            return null;
        } else {
            Employee oldest = this.employees.get(0);
            int age = this.employees.get(0).getAge();
            for (Employee employee : this.employees) {
                if (employee.getAge() > age) {
                    oldest = employee;
                    age = employee.getAge();
                }
            }
            return oldest;
        }
    }

    public Employee getEmployee(String name) {
        return this.employees.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder str = new StringBuilder();
        str.append("Employees working at Bakery ")
                .append(this.name)
                .append(":")
                .append(System.lineSeparator());
        this.employees.forEach(e -> str.append(e).append(System.lineSeparator()));
        return str.toString();
    }
}
