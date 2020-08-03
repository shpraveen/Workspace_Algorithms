package designPatterns.creational.abstractFactoryMethod.Challenge;

public class FactoryProducer {

    public static MovieFactoryInterface getFactory(String choice){

        if(choice.equalsIgnoreCase("Comedy")) {
            return new ComedyMoviefactory();
        }
        else if(choice.equalsIgnoreCase("Action")){
            return new ActionMoviefactory();
        }

        return null;
    }
}
