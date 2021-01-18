package com.company.dunzo.coffee_vending_machine;

public class Ingredient {

    //Adding only 1 field for simplicity. Can have multiple.
    private String name;

    public Ingredient(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Ingredient compareObject = (Ingredient) obj;
        return this.name.equals(compareObject.getName());
    }
}
