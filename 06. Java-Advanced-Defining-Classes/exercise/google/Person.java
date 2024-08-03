package class06.exercise.google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private Car car;

    private List<Pokemon> pokemons;
    private List<Parents> parents;
    private List<Children> childrens;

    public Person() {
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.childrens = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Company getCompany() {
        return this.company;
    }

    public Car getCar() {

        return this.car;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public List<Children> getChildrens() {
        return childrens;
    }
}
