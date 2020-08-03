package designPatterns.creational.abstractFactoryMethod.Challenge2;

public class Client {
    public static void main(String[] args) {
        MovieFactoryInterface hollywoodMovieFactory= FactoryProducer.getFactory("HollywoodMovie");

        HollywoodMovieInterface hAction= hollywoodMovieFactory.getHollywoodMovie("Action");
        HollywoodMovieInterface hComedy= hollywoodMovieFactory.getHollywoodMovie("Comedy");

        System.out.println("\nAction movies are: ");
        System.out.println(hAction.getMovieName());
        System.out.println(hComedy.getMovieName());

        MovieFactoryInterface bollywoodMovieFactory= FactoryProducer.getFactory("BollywoodMovie");

        BollywoodMovieInterface bAction= bollywoodMovieFactory.getBollywoodMovie("Action");
        BollywoodMovieInterface bComedy= bollywoodMovieFactory.getBollywoodMovie("Comedy");

        System.out.println("\nAction movies are: ");
        System.out.println(bAction.getMovieName());
        System.out.println(bComedy.getMovieName());

    }
}
