package SocketTest;

import java.util.concurrent.locks.ReentrantLock;

public class GrapRedPocketTest {
    private static volatile double total = 100;
    private static volatile double money = 100;
    private static volatile int cnt = 6;
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        StringBuilder stringBuilder = new StringBuilder("");
                        String string = "abc";
                        string.substring(1,2);
                        lock.lock();
                        if(cnt == 0){
                            System.out.println(Thread.currentThread().getName() + ": runs out");
                        }else{
                            double tmoney;
                            if(cnt == 1){
                                tmoney = money;
                            }else{
                                tmoney = Math.random() * 100;
                                while(tmoney >= money){
                                    tmoney = Math.random() * 100;
                                }
                            }
                            money -= tmoney;
                            cnt--;
                            System.out.println(Thread.currentThread().getName() + "抢到啦，抢到" + tmoney);
                        }
                    }finally {
                        lock.unlock();
                    }
                }
            }, "t" + i).start();
        }
    }
}
