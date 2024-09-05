package class11.lab.StudentSystem;
import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void ParseCommand(String[] args) {
        if (args[0].equals("Create")) {
            this.create(args);
        } else if (args[0].equals("Show")) {
            this.show(args[1]);
        }
    }

    public void create(String[] strArr) {
        var name = strArr[1];
        var age = Integer.parseInt(strArr[2]);
        var grade = Double.parseDouble(strArr[3]);
        if (!repo.containsKey(name)) {
            var student = new Student(name, age, grade);
            repo.put(name, student);
        }
    }

    public void show(String name) {
        if (repo.containsKey(name)) {
            var student = repo.get(name);
            String view = String.format("%s is %s years old.", student.getName(), student.getAge());
            if (student.getGrade() >= 5.00) {
                view += " Excellent student.";
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                view += " Average student.";
            } else {
                view += " Very nice person.";
            }

            System.out.println(view);
        }
    }
}
