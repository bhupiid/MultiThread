import java.time.LocalTime;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
            PrintTasks task1 = new PrintTasks("Thread1",15000);
            PrintTasks task2 = new PrintTasks("Thread2",15000);
            PrintTasks task3 = new PrintTasks("Thread3",15000);
            PrintTasks task4 = new PrintTasks("Thread4",15000);
            PrintTasks task5 = new PrintTasks("Thread5",15000);
            PrintTasks task6 = new PrintTasks("Thread6",15000);

            Thread t1 = new Thread(task1);
            Thread t2 = new Thread(task2);
            Thread t3 = new Thread(task3);
            Thread t4 = new Thread(task4);
            Thread t5 = new Thread(task5);
            Thread t6 = new Thread(task6);


            //task.printTask("BOO");
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            t6.start();

            System.out.println("Thread Started. main ends");

        }
}


class PrintTasks implements Runnable {

    private int sleepTime;
    private String threadName;
    //private Static Random generator = new Random();
    Random generator = new Random();


    PrintTasks(String threadName, int sleepTime) {
        this.threadName = threadName;
        this.sleepTime = generator.nextInt(sleepTime);
    }

    PrintTasks(String threadName) {
        this.threadName = threadName;
        this.sleepTime = generator.nextInt(5000);
    }

    public void run() {
        try {
            System.out.printf(threadName + " going to sleep for : " + sleepTime + " milliseconds \t Current Time: " + "%tT%n", LocalTime.now());
            //System.out.printf("");
            Thread.sleep(sleepTime);
            //System.out.printf("Finished Time: %s", LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

            System.out.printf(threadName + " finished execution : " + sleepTime + " milliseconds \t Current Time: " + "%tT%n", LocalTime.now());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}


