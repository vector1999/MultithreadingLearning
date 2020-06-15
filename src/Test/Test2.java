package Test;


import java.util.concurrent.Semaphore;

public class Test2 {
    private static Semaphore full = new Semaphore(1);
    private static Semaphore empty = new Semaphore(0);
    private static Semaphore mutex = new Semaphore(1);
    private static volatile int num;
    public static void main(String[] args) {
        class ProduceThread extends Thread{
            @Override
            public void run(){
                for( ; ;){
                    try {
                        full.acquire();
                        mutex.acquire();
                        num = (int)(Math.random() * 100);
                        System.out.println("produce num : " + num);
                        mutex.release();
                        empty.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        class ComsumeThread extends Thread{
            @Override
            public void run(){
                for( ; ;){
                    try {
                        empty.acquire();
                        mutex.acquire();
                        System.out.println("consume num :" + num);
                        mutex.release();
                        full.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        ProduceThread produceThread = new ProduceThread();
        ComsumeThread comsumeThread = new ComsumeThread();
        produceThread.start();
        comsumeThread.start();
    }
}
