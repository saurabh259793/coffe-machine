package com.company.dunzo.coffee_vending_machine;

import java.util.HashMap;

public class Recipe {

    HashMap<String, Integer> itemsRequired;

    private String process;


    public Recipe() {
        itemsRequired = new HashMap<>();
    }

    public void addRequiredIem(Ingredient ingredient, Integer quantity) {
        Integer quantityPresent = this.itemsRequired.getOrDefault(ingredient, 0);
        this.itemsRequired.put(ingredient.getName(), quantity + quantityPresent);
    }

    public HashMap geRequiredIems() {
        return this.itemsRequired;
    }
}
