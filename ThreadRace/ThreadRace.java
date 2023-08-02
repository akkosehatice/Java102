package ThreadRace;

import java.util.ArrayList;
import java.lang.Thread;
public class ThreadRace  implements Runnable{
    String threadName = Thread.currentThread().getName();
    ArrayList<Integer> numbers = new ArrayList<>();
    {
        for (int i = 0; i<10000;i++){
            numbers.add(i);
        }
    }
    ArrayList<Integer> evenNumbers = new ArrayList<>();
    ArrayList<Integer> oddNumbers = new ArrayList<>();


    ArrayList<Integer> thread1 = new ArrayList<>();
    ArrayList<Integer> thread2 = new ArrayList<>();
    ArrayList<Integer> thread3 = new ArrayList<>();
    ArrayList<Integer> thread4 = new ArrayList<>();

    {
        for (int i = 0;i<numbers.size()/4;i++){
            thread1.add(i);
        }
        for (int i = numbers.size()/4;i<numbers.size()/2;i++){
            thread2.add(i);
        }
        for (int i = numbers.size()/2;i<numbers.size()*3/4;i++){
            thread3.add(i);
        }
        for (int i = numbers.size()*3/4;i<numbers.size();i++){
            thread4.add(i);
        }
    }
    synchronized void add(int number) {
        if (number % 2 == 0) {
            System.out.println(Thread.currentThread().getName() + ": " + number);
            evenNumbers.add(number);
        } else {
            System.out.println(Thread.currentThread().getName() + ": " + number);
            oddNumbers.add(number);
        }
    }

        @Override
        public void run (){
            if(Thread.currentThread().getName().equals("Thread-0")){
                for(Integer i: thread1){
                    add(i);
                }
            }
            if(Thread.currentThread().getName().equals("Thread-1")){
                for(Integer i: thread2){
                    add(i);
                }
            }
            if(Thread.currentThread().getName().equals("Thread-2")){
                for(Integer i: thread3){
                    add(i);
                }
            }
            if(Thread.currentThread().getName().equals("Thread-3")){
                for(Integer i: thread4){
                    add(i);
                }
            }
        }
}





