package class09.exercise.PetClinic;

public class Pet {
    private String name;
    private Integer age;
    private String kind;

    public Pet(String name, Integer age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void print() {
        System.out.printf("%s %d %s%n", this.name, this.age, this.kind);
    }
}
