package SocketTest;

public class SellTicket{
    private volatile static int price = 500;
    private volatile static int cnt = 1000;
    static ThreadLocal<Integer> selledCnt = new ThreadLocal<>();
    static ThreadLocal<Integer> selledMoney = new ThreadLocal<>();
    synchronized static void sell(){
        if (cnt > 0) {
            cnt--;

            Integer currCnt = selledCnt.get();
            if (currCnt == null) {
                selledCnt.set(0);
                selledMoney.set(0);
            }
            selledCnt.set(selledCnt.get() + 1);
            selledMoney.set(selledMoney.get() + price);
            System.out.println(Thread.currentThread().getName() + " " + cnt + " " + selledCnt.get() + " " + selledMoney.get() + " " + price);
            //是否涨价？
            if (cnt != 0 && cnt % 100 == 0) {
                price += 100;
            }
        } else {
            System.out.println("selled out!!!");
        }
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Thread.yield();
    }
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                       sell();
                    }
                }
            }, "p" + i).start();
        }
    }
}
