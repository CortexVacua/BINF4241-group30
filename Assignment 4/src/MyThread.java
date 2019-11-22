public class MyThread implements Runnable{

    private boolean running;    // represent the state of the thread
    private int time;           // represent the time of life of the thread


    public MyThread(int timeInMillis){
        time = timeInMillis;
        running = false;
    }


    public MyThread(){
        this(10000);
    }


    public boolean isRunning(){
        return running;
    }


    @Override
    public void run() {
        try {
            running = true;
            Thread.sleep(time);
            running = false;
            System.out.println("The "+Thread.currentThread().getName() + " has finished its program.\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}