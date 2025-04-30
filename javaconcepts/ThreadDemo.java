package javaconcepts;

class MyThread extends Thread{
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Thread: "+Thread.currentThread().getName()+" Count: "+i);
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Thread: "+Thread.currentThread().getName()+" Count: "+i);
        }
    }
}

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public  int getCount() {
        return count;
    }
}

public class ThreadDemo{
    public static void main(String[] args) throws InterruptedException{
        // MyThread thread1 = new MyThread();
        // MyThread thread2 = new MyThread();
        
        // Thread thread1 = new Thread(new MyRunnable());
        // Thread thread2 = new Thread(new MyRunnable());

        // thread1.start();
        // thread2.start();

        Counter counter = new Counter();

        // Runnable task = () -> {
        //     for (int i = 0; i < 1000; i++) {
        //         counter.increment();
        //     }
        // };
        

        Runnable task = ()->{
	        try{
	            Thread.sleep(1000);
	            System.out.println("hello from the "+Thread.currentThread().getName());
	        }catch(Exception e){
	            System.out.println("Exception: "+e);
	        }
	        
	    };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final Count: " + counter.getCount());
    }
}