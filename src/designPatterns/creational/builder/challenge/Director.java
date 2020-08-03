package designPatterns.creational.builder.challenge;

class Director {
MealBuilderInterface myBuilder;

public void construct(MealBuilderInterface builder){
    myBuilder=builder;
    myBuilder.buildBerger();
    myBuilder.buildDrink();
        }

}
