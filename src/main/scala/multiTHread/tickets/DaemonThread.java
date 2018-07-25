package multiTHread.tickets;

import java.io.*;
import java.util.Scanner;

public class DaemonThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Daemon Thread: " + Thread.currentThread().getName());

        writeToFile();

        System.out.println("Quit Daemon Thread: " + Thread.currentThread().getName());
    }

    private void writeToFile(){
        String fileName = "/home/yuqili/daemon.txt";
        File file = new File(fileName);
        try {
            OutputStream os = new FileOutputStream(file, true);
            int count = 0;
            while(count < 999){
                os.write(("hello Word " + count).getBytes());
                System.out.println(Thread.currentThread().getName() + "正在写" + count++);
                Thread.sleep(1000);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Daemon Thread: " + Thread.currentThread().getName());
        DaemonThread demo = new DaemonThread();
        Thread t = new Thread(demo);
        t.setDaemon(true);
        t.start();

        Scanner sc = new Scanner(System.in);
        sc.next();

        System.out.println("Quit Daemon Thread: " + Thread.currentThread().getName());
    }
}
