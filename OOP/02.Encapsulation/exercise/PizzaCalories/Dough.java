package oop01.exercise.PizzaCalories;

public class Dough {
    private static final double BASE_CALORIES = 2;
    private static final String FLOUR_WHITE = "White";
    private static final double FLOUR_WHITE_VAL = 1.5;
    private static final String FLOUR_WHOLEGRAIN = "Wholegrain";
    private static final double FLOUR_WHOLEGRAIN_VAL = 1;
    private static final String BAKING_TECH_CRISPY = "Crispy";
    private static final double BAKING_TECH_CRISPY_VAL = 0.9;
    private static final String BAKING_TECH_CHEWY = "Chewy";
    private static final double BAKING_TECH_CHEWY_VAL = 1.1;
    private static final String BAKING_TECH_HOMEMADE = "Homemade";
    private static final double BAKING_TECH_HOMEMADE_VAL = 1;


    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals(FLOUR_WHITE) && !flourType.equals(FLOUR_WHOLEGRAIN)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals(BAKING_TECH_CRISPY) && !bakingTechnique.equals(BAKING_TECH_CHEWY) && !bakingTechnique.equals(BAKING_TECH_HOMEMADE)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return BASE_CALORIES * this.weight * this.getModifierValue(this.flourType) * this.getModifierValue(this.bakingTechnique);
    }

    private double getModifierValue(String modifier) {
        double modifierValue = 0;
        switch (modifier) {
            case FLOUR_WHITE:
                modifierValue = FLOUR_WHITE_VAL;
                break;
            case FLOUR_WHOLEGRAIN:
                modifierValue = FLOUR_WHOLEGRAIN_VAL;
                break;
            case BAKING_TECH_CRISPY:
                modifierValue = BAKING_TECH_CRISPY_VAL;
                break;
            case BAKING_TECH_CHEWY:
                modifierValue = BAKING_TECH_CHEWY_VAL;
                break;
            case BAKING_TECH_HOMEMADE:
                modifierValue = BAKING_TECH_HOMEMADE_VAL;
                break;
        }
        return modifierValue;
    }
}
