package com.company.dunzo.coffee_vending_machine;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class CoffeeMachine {

    private int outlets;

    private HashMap<String, Integer> ingredientQuantities;

    private ExecutorService executorService;

    public CoffeeMachine(int outlets) {
        this.outlets = outlets;
        ingredientQuantities = new HashMap<>();
        setup();
    }

    private void setup() {
        this.executorService = new ThreadPoolExecutor(this.outlets, this.outlets, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(), Executors.defaultThreadFactory(),
                (runnable, executor) -> {
                    this.executorService.shutdown();
                });
    }

    private Integer getIngredientsQuantity(String ingredient) {

        if (!ingredientQuantities.containsKey(ingredient))
            return -1;

        return ingredientQuantities.get(ingredient);
    }

    private void updateIngredientQuantity(String ingredient, int quantity) {

        if (quantity < 0)
            return;

        ingredientQuantities.put(ingredient, quantity);
    }

    private synchronized void getBeverageUtil(Beverage beverage) {

        if (beverage == null)
            return;

        Recipe recipe = beverage.getRecipe();

        if (recipe == null) {
            System.out.println("No recipe found");
            return;
        }

        HashMap<String, Integer> recipeIngredients = recipe.geRequiredIems();

        for(Map.Entry<String, Integer> entry: recipeIngredients.entrySet()) {
            String ingredient = entry.getKey();
            int quantity = entry.getValue();
            int ingrdientQuantity = this.getIngredientsQuantity(entry.getKey());

            if (ingrdientQuantity == -1) {
                System.out.println(String.format("%s cannot be prepared because %s is not available", beverage.getName(), ingredient));
                return;
            }

            if (ingrdientQuantity < quantity) {
                System.out.println(String.format("%s cannot be prepared because %s is not sufficient", beverage.getName(), ingredient));
                return;
            }

            this.updateIngredientQuantity(ingredient, ingrdientQuantity - quantity);

        }
        System.out.println(String.format("%s is prepared", beverage.getName()));

    }

    public void getBeverage(Beverage beverage) {
        CompletableFuture.runAsync(() -> {
            getBeverageUtil(beverage);
        }, executorService);
    }

    public void addIngredient(Ingredient ingredient, int quantity) {

        int quantityPresent = ingredientQuantities.getOrDefault(ingredient, 0);
        ingredientQuantities.put(ingredient.getName(), quantity + quantityPresent);
    }
}
