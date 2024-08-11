package class09.exercise.EqualityLogic;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private Integer age;

    public Person(String input) {
        this.name = input.split(" ")[0];
        this.age = Integer.parseInt(input.split(" ")[1]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return this.name.equals(person.getName()) && this.age.equals(person.getAge());
    }

    @Override
    public int hashCode() {
        return 1;
//        int hash = 7;
//        int nameHash = this.name.hashCode();
//        hash = 31 * hash + nameHash;
//        int ageHash = this.age;
//        hash = 31 * hash + ageHash;
//        return hash;
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

    @Override
    public int compareTo(Person o) {
        int result = this.name.compareTo(o.getName());
        if (result == 0) {
            result = this.age.compareTo(o.getAge());
        }
        return result;
    }
}
