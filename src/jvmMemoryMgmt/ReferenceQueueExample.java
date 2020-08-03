package jvmMemoryMgmt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.sql.SQLOutput;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReferenceQueueExample {

    public static void main(String[] args) throws IOException {
        Person2 p = new Person2();

        final ReferenceQueue<Person2> referenceQueue = new ReferenceQueue<Person2>();

        PersonCleaner cleaner = new PersonCleaner();
        PersonWeakReference weakReference = new PersonWeakReference(p,cleaner,referenceQueue);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    PersonWeakReference wr = (PersonWeakReference) referenceQueue.remove();
                    wr.clean();
                }
                catch(Exception e){
                    e.getMessage();
                }
            }
        });


        p =  null;
        System.gc();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Press any key to continue ");
            br.readLine();
            executorService.shutdown();

        }

    }


final class Person2{

}

final class PersonCleaner{
    public void clean(){
        System.out.println("cleaned");
    }
}
class PersonWeakReference extends WeakReference<Person2> {

    PersonCleaner cleaner;
    public PersonWeakReference(Person2 referent, PersonCleaner cleaner, ReferenceQueue<? super Person2> q) {
    super(referent,q);
    this.cleaner=cleaner;
    }

    /*public PersonWeakReference(Person2 p, PersonCleaner cleaner, ReferenceQueue<Person2> referenceQueue) {
        super();
    }*/

    public void clean(){
        cleaner.clean();
    }
}