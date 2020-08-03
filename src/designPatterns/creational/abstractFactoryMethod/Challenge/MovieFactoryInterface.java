package designPatterns.creational.abstractFactoryMethod.Challenge;

interface MovieFactoryInterface {
    HollywoodMovieInterface getHollywoodMovie();
    BollywoodMovieInterface getBollywoodMovie();
}

class ActionMoviefactory implements MovieFactoryInterface{

    @Override
    public HollywoodMovieInterface getHollywoodMovie() {
        return new HollywoodActionMovie();
    }

    @Override
    public BollywoodMovieInterface getBollywoodMovie() {
        return new BollywoodActionMovie();
    }
}

class ComedyMoviefactory implements MovieFactoryInterface{

    @Override
    public HollywoodMovieInterface getHollywoodMovie() {
        return new HollywoodComedyMovie();
    }

    @Override
    public BollywoodMovieInterface getBollywoodMovie() {
        return new BollywoodComedyMovie();
    }
}
