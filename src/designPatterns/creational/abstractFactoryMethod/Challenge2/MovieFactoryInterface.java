package designPatterns.creational.abstractFactoryMethod.Challenge2;

interface MovieFactoryInterface {
    HollywoodMovieInterface getHollywoodMovie(String type);
    BollywoodMovieInterface getBollywoodMovie(String type);
}
// for hollywood vs bollywood
class HollywoodMoviefactory implements MovieFactoryInterface {

    @Override
    public HollywoodMovieInterface getHollywoodMovie(String type) {
        if(type.equalsIgnoreCase("Action")){
            return new HollywoodActionMovie();
        }
        else if(type.equalsIgnoreCase("Comedy")){
            return new HollywoodComedyMovie();
        }
        return null;
    }

    @Override
    public BollywoodMovieInterface getBollywoodMovie(String type) {
        return null;
    }
}

class BollywoodMoviefactory implements MovieFactoryInterface {

    @Override
    public HollywoodMovieInterface getHollywoodMovie(String type) {

        return null;
    }

    @Override
    public BollywoodMovieInterface getBollywoodMovie(String type) {

        if(type.equalsIgnoreCase("Action")){
            return new BollywoodActionMovie();
        }
        else if(type.equalsIgnoreCase("Comedy")){
            return new BollywoodComedyMovie();
        }

        return null;
    }
}
