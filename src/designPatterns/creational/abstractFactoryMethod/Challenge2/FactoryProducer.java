package designPatterns.creational.abstractFactoryMethod.Challenge2;

public class FactoryProducer {

    public static MovieFactoryInterface getFactory(String choice){

        if(choice.equalsIgnoreCase("HollywoodMovie")) {
            return new HollywoodMoviefactory();
        }
        else if(choice.equalsIgnoreCase("BollywoodMovie")){
            return new BollywoodMoviefactory();
        }

        return null;
    }
}
