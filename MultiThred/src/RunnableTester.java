import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTester {

    public static void main(String[] args) {
        PrintTasks task1 = new PrintTasks("thread1");
        PrintTasks task2 = new PrintTasks("thread2");
        PrintTasks task3 = new PrintTasks("thread3");
        PrintTasks task4 = new PrintTasks("thread4");
        PrintTasks task5 = new PrintTasks("thread5");
        PrintTasks task6 = new PrintTasks("thread6");

        System.out.println("Starting threads");
        ExecutorService threadExecutor = null;
        try {
            threadExecutor = Executors.newFixedThreadPool(3);

            threadExecutor.execute(task1);
            threadExecutor.execute(task2);
            threadExecutor.execute(task3);
            threadExecutor.execute(task4);
            threadExecutor.execute(task5);
            threadExecutor.execute(task6);
            System.out.println("Thread started main ends\n");
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        } finally {
            threadExecutor.shutdown();
        }


    }
}
