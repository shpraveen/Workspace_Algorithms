package designPatterns.creational.abstractFactoryMethod.Challenge;

public class Client {
    public static void main(String[] args) {
        MovieFactoryInterface actionMovie=FactoryProducer.getFactory("Action");

        HollywoodMovieInterface hAction= actionMovie.getHollywoodMovie();
        hAction.getMovieName();

        BollywoodMovieInterface bAction = actionMovie.getBollywoodMovie();
        bAction.getMovieName();

        System.out.println("\nAction movies are: ");
        System.out.println(hAction.getMovieName());
        System.out.println(bAction.getMovieName());


        MovieFactoryInterface comdeyMovie = FactoryProducer.getFactory("Comedy");

        HollywoodMovieInterface hComedy=comdeyMovie.getHollywoodMovie();
        hComedy.getMovieName();

        BollywoodMovieInterface bComedy = comdeyMovie.getBollywoodMovie();
        bComedy.getMovieName();

        System.out.println("\nComedy movies are: ");
        System.out.println(hComedy.getMovieName());
        System.out.println(bComedy.getMovieName());

    }
}
