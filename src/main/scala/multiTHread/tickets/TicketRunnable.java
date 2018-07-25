package multiTHread.tickets;

public class TicketRunnable implements Runnable{
    private int count = 5;

    // synchronized 可以保证这个方法一次只有一个线程去执行
    @Override
    public synchronized void run() {
        while (count > 0) {
            count --;
            System.out.println(Thread.currentThread().getName() + " sold 1 ticket, rest: " + count);
        }
    }


    public static void main(String[] args) {
        TicketRunnable mr = new TicketRunnable();
        Thread t1 = new Thread(mr,"window1");
        Thread t2 = new Thread(mr,"window2");
        Thread t3 = new Thread(mr,"window3");

        // start 是就绪状态， 得到cpu之后才是运行状态
        // join 和 sleep 会进入阻塞状态，解除阻塞后会进入就绪状态而不是直接运行状态
        t1.start();
        t2.start();
        t3.start();

    }
}
