package designPatterns.creational.builder.challenge;

public class Client {

    public static void main(String[] args) {
        System.out.println("*** Builder Pattern for Restaurant Demo ***\n");

        Director director = new Director();

        MealBuilderInterface vegMealBuilder = new VegMealBuilder();
        MealBuilderInterface NonVegMealBuilder = new NonVegMealBuilder();

        // making vegMeal
        director.construct(vegMealBuilder);
        Meal vegMeal = vegMealBuilder.getMeal();

        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Costs: "+vegMeal.getCost());


        // making NonVegMeal
        director.construct(NonVegMealBuilder);
        Meal nonVegMeal = NonVegMealBuilder.getMeal();

        System.out.println("Non Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Costs: "+nonVegMeal.getCost());
    }
}
