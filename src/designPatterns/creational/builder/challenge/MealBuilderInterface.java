package designPatterns.creational.builder.challenge;



interface MealBuilderInterface {

    void buildBerger();
    void buildDrink();
    Meal getMeal();
}

class VegMealBuilder implements MealBuilderInterface{

    private Meal vegMeal = new Meal();

    @Override
    public void buildBerger() {
    vegMeal.addItem(new VegBurger());
    }

    @Override
    public void buildDrink() {
        vegMeal.addItem(new Coke());
    }


    @Override
    public Meal getMeal() {
        return vegMeal;
    }
}

class NonVegMealBuilder implements MealBuilderInterface{

    private Meal NonvegMeal = new Meal();

    @Override
    public void buildBerger() {
        NonvegMeal.addItem(new ChickenBurger());
    }

    @Override
    public void buildDrink() {
        NonvegMeal.addItem(new Pepsi());
    }


    @Override
    public Meal getMeal() {
        return NonvegMeal;
    }
}