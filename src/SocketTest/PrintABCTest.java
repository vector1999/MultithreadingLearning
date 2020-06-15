package SocketTest;

import java.util.concurrent.locks.ReentrantLock;
public class PrintABCTest {
    private static ReentrantLock lock = new ReentrantLock();
    private static volatile int state = 1;
    static class ThreadA extends Thread{
        @Override
        public void run(){
            while(true){
                lock.lock();
                try{
                    if(state % 3 == 1){
                        System.out.println("A");
                        state ++;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    static class ThreadB extends Thread{
        @Override
        public void run(){
            while(true){
                lock.lock();
                try{
                    if(state % 3 == 2){
                        System.out.println("B");
                        state ++;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    static class ThreadC extends Thread{
        @Override
        public void run(){
            while(true){
                lock.lock();
                try{
                    if(state % 3 == 0){
                        System.out.println("C");
                        state ++;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        ThreadC c = new ThreadC();
        a.start();
        b.start();
        c.start();
    }
}
