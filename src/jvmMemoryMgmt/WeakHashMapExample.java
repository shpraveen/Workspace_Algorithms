package jvmMemoryMgmt;

import java.util.Date;
import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapExample {

    public static void main(String[] args) {
        WeakHashMap<Person1,PersonMetadata> weakHashMap = new WeakHashMap<Person1, PersonMetadata>();

        HashMap<Person1,PersonMetadata> ashMap = new HashMap<Person1, PersonMetadata>();

        Person1 kevin = new Person1();

        weakHashMap.put(kevin, new PersonMetadata());
        PersonMetadata p = weakHashMap.get(kevin);
        System.out.println(p);

        kevin= null;
        System.gc();

        if(weakHashMap.containsValue(p)){
            System.out.println("still contains key");
        }
        else{
            System.out.println("key gone");
        }
    }

}

final class Person1{

}

class PersonMetadata{
    Date date;

    PersonMetadata(){

        date = new Date();
    }

    @Override
    public String toString() {
        return "PersonMetadata{" +
                "date=" + date +
                '}';
    }
}