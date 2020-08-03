package designPatterns.creational.abstractFactoryMethod.Challenge;

public interface BollywoodMovieInterface {
    String getMovieName();
}

class BollywoodActionMovie implements BollywoodMovieInterface{

    @Override
    public String getMovieName() {
        return "Bang Bang is a Bollywood Action Movie";
    }
}

class BollywoodComedyMovie implements BollywoodMovieInterface{

    @Override
    public String getMovieName() {
        return "Munna Bhai is a Bollywood Comedy Movie";
    }
}
