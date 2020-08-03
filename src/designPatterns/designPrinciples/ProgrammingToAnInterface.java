package designPatterns.designPrinciples;

interface displayModule{
    public void display();
}

class Monitor implements displayModule{
    public void display(){
        System.out.println("Display through Monitor");
    }
}

class Projector implements displayModule{
    public void display(){
        System.out.println("Diaplay through Projector");
    }
}

public class ProgrammingToAnInterface {
    displayModule dm;

    public void setDisplayModule(displayModule dm){
        this.dm=dm;
    }

    public void display(){
        dm.display();
    }

    public static void main(String[] args) {
        ProgrammingToAnInterface pm = new ProgrammingToAnInterface();
        displayModule dm = new Monitor();
        displayModule dm1 = new Projector();

        pm.setDisplayModule(dm);
        dm.display();
        pm.setDisplayModule(dm1);
        dm1.display();

    }
}
