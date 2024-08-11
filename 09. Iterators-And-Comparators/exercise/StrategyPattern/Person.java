package class09.exercise.StrategyPattern;

public class Person {
    private String name;
    private Integer age;

    public Person(String input) {
        this.name = input.split(" ")[0];
        this.age = Integer.parseInt(input.split(" ")[1]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void print() {
        System.out.printf("%s %d%n", this.name, this.age);
    }
}
