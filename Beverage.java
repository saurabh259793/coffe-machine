package com.company.dunzo.coffee_vending_machine;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Beverage {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Beverage(String name, Recipe recipe) {
        this.name = name;
        this.recipe = recipe;
    }

    private Recipe recipe;
}
