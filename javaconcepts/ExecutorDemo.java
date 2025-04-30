package javaconcepts;

import java.util.concurrent.*;

public class ExecutorDemo{
    public static void main(String[] args){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(()->System.out.println("Task executed using Executor"));
        executor.shutdown();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->System.out.println("Task executed using ExecutorService"));
        executorService.submit(()->System.out.println("Task executed using ExecutorService"));
        
        Callable call = ()->{
            System.out.println("Tasked executed from "+ Thread.currentThread().getName());
            return Thread.currentThread().getName();
            };
        Future<String> future = executorService.submit(call);
        try{
            System.out.println(future.get());
        }catch(InterruptedException | ExecutionException e){
           System.out.println(e);
        }


        executorService.shutdown();
        try{
            executorService.awaitTermination(5,TimeUnit.SECONDS);
            executorService.shutdownNow();
        }catch(Exception e){
            executorService.shutdownNow();
        }


        //ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.schedule(() -> System.out.println("Task executed after delay"), 3, TimeUnit.SECONDS);

        // Schedule a task to run repeatedly with a fixed rate
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("Running task at " + System.currentTimeMillis()), 1, 2, TimeUnit.SECONDS);

        // Schedule a task to run repeatedly with a fixed delay
        scheduledExecutorService.scheduleWithFixedDelay(() -> System.out.println("Task executed with fixed delay"), 1, 2, TimeUnit.SECONDS);

        // Shutdown ScheduledExecutorService after a delay to allow tasks to complete
        scheduledExecutorService.schedule(() -> {
            scheduledExecutorService.shutdown();
            System.out.println("ScheduledExecutorService shutdown");
        }, 10, TimeUnit.SECONDS);

    }
}