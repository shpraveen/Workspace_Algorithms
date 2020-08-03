package designPatterns.creational.abstractFactoryMethod.Challenge2;

public interface HollywoodMovieInterface {

    String getMovieName();
}

class HollywoodActionMovie implements HollywoodMovieInterface {

    @Override
    public String getMovieName() {
        return "True Lies is a Hollywood Action Movie";
    }
}

class HollywoodComedyMovie implements HollywoodMovieInterface {

    @Override
    public String getMovieName() {
        return "The Jerk is a Hollywood Comedy Movie";
    }
}
