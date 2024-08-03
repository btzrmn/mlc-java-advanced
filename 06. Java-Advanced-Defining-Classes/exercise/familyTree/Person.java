package class06.exercise.familyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthday;
    private List<Person> parents = new ArrayList<>();
    private List<Person> children = new ArrayList<>();

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
        child.parents.add(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String toString() {
        return String.format("%s %s", name, birthday);
    }
}
