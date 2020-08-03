package jvmMemoryMgmt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PahntomReferenceExample {

    public static void main(String[] args) throws IOException {
        ArrayList<Person3> people = new ArrayList<Person3>();
        ArrayList<FinalizePerson> list = new ArrayList<FinalizePerson>();
        ReferenceQueue<Person3> referenceQueue = new ReferenceQueue<Person3>();

        for (int i = 0; i < 10; i++) {
            Person3 p = new Person3();
            people.add(p);
            list.add(new FinalizePerson(p,referenceQueue));

        }

        people=null;
        System.gc();

        for (PhantomReference<Person3> reference: list) {
            System.out.println(reference.isEnqueued());
        }

        Reference<? extends Person3> referenceFromQueue;
        while((referenceFromQueue= referenceQueue.poll())!= null){

            ((FinalizePerson)referenceFromQueue).cleanup();

            referenceFromQueue.clear();
        }

    }

}
final class Person3{

}

class FinalizePerson extends PhantomReference<Person3> {

    public FinalizePerson(Person3 referent, ReferenceQueue<? super Person3> q) {
    super(referent,q);
    }

    public void cleanup(){
        System.out.println("Person is finalizing Resources ");
    }
}