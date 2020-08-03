package designPatterns.creational.singleton.challenge;

public class MakeACaptain {
    private MakeACaptain(){}

    private static class SingletonHelper{
        //nested class is referenced after getCaption() is called
        private static final MakeACaptain _captain = new MakeACaptain();
    }

    public static MakeACaptain getCaptain(){
        return SingletonHelper._captain;
    }

    public static void main(String[] args) {

        System.out.println("*** Singleton Pattern Demo ***\n");
        System.out.println("Trying to make a captain for our Team");

        MakeACaptain c1 = MakeACaptain.getCaptain();

        System.out.println("Trying to make another Captain for our Team");
        MakeACaptain c2 = MakeACaptain.getCaptain();

        if(c1 == c2){
            System.out.println("c1 and c2 are same instance");
        }
    }

}
