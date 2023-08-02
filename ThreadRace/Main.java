package ThreadRace;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadRace threadRace = new ThreadRace();
        Thread thread1 = new Thread(threadRace);
        Thread thread2 = new Thread(threadRace);
        Thread thread3 = new Thread(threadRace);
        Thread thread4 = new Thread(threadRace);

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        thread4.start();
        thread4.join();



        System.out.println("Çift Sayılar : " + threadRace.evenNumbers.toString());
        System.out.println("Tek Sayılar : " + threadRace.oddNumbers.toString());


    }
}
