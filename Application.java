package com.company.dunzo.coffee_vending_machine;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(3);
        Ingredient hot_water = new Ingredient("hot_water");
        Ingredient hot_milk = new Ingredient("hot_milk");
        Ingredient ginger_syrup = new Ingredient("ginger_syrup");
        Ingredient tea_leaves_syrup = new Ingredient("tea_leaves_syrup");
        Ingredient sugar_syrup = new Ingredient("sugar_syrup");

        coffeeMachine.addIngredient(hot_milk, 500);
        coffeeMachine.addIngredient(hot_water, 500);
        coffeeMachine.addIngredient(ginger_syrup, 100);
        coffeeMachine.addIngredient(tea_leaves_syrup, 100);
        coffeeMachine.addIngredient(sugar_syrup, 100);

        Recipe hot_tea_recipe = new Recipe();
        hot_tea_recipe.addRequiredIem(new Ingredient("hot_water"), 200);
        hot_tea_recipe.addRequiredIem(new Ingredient("ginger_syrup"), 10);
        hot_tea_recipe.addRequiredIem(new Ingredient("hot_milk"), 100);
        hot_tea_recipe.addRequiredIem(new Ingredient("sugar_syrup"), 10);
        hot_tea_recipe.addRequiredIem(new Ingredient("tea_leaves_syrup"), 30);
        Beverage hot_tea = new Beverage("hot_tea", hot_tea_recipe);

        Recipe black_tea_recipe = new Recipe();
        black_tea_recipe.addRequiredIem(new Ingredient("hot_water"), 300);
        black_tea_recipe.addRequiredIem(new Ingredient("ginger_syrup"), 30);
        black_tea_recipe.addRequiredIem(new Ingredient("sugar_syrup"), 50);
        black_tea_recipe.addRequiredIem(new Ingredient("tea_leaves_syrup"), 30);
        Beverage black_tea = new Beverage("black_tea", black_tea_recipe);

        Recipe green_tea_recipe = new Recipe();
        green_tea_recipe.addRequiredIem(new Ingredient("hot_water"), 100);
        green_tea_recipe.addRequiredIem(new Ingredient("ginger_syrup"), 30);
        green_tea_recipe.addRequiredIem(new Ingredient("sugar_syrup"), 50);
        green_tea_recipe.addRequiredIem(new Ingredient("green_mixture"), 50);
        Beverage green_tea = new Beverage("green_tea", green_tea_recipe);

        Recipe hot_coffee_recipe = new Recipe();
        hot_coffee_recipe.addRequiredIem(new Ingredient("hot_water"), 100);
        hot_coffee_recipe.addRequiredIem(new Ingredient("ginger_syrup"), 30);
        hot_coffee_recipe.addRequiredIem(new Ingredient("hot_milk"), 400);
        hot_coffee_recipe.addRequiredIem(new Ingredient("sugar_syrup"), 50);
        hot_coffee_recipe.addRequiredIem(new Ingredient("tea_leaves_syrup"), 30);
        Beverage hot_coffee = new Beverage("hot_coffee", hot_coffee_recipe);


        List<Beverage> beverages = new ArrayList<>();
        beverages.add(hot_tea);
        beverages.add(black_tea);
        beverages.add(green_tea);
        beverages.add(hot_coffee);

        beverages.parallelStream().forEach(beverage -> {
            coffeeMachine.getBeverage(beverage);
        });

    }
}
