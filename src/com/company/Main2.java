package duoxiancheng;

import java.util.Scanner;

class HelloWorld {
    private int n;
    private static Object lock = new Object();
    boolean flag = true;

    public HelloWorld(int n) {
        this.n = n;
    }

    public void hello() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                System.out.print("Hello");
                if (flag) {
                    lock.notify();
                    flag = false;
                }
                lock.wait();
            }
        }
    }

    public void world() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                System.out.println("World!");
                if (!flag) {
                    lock.notify();
                    flag = true;
                }
                lock.wait();
            }
        }
    }
}

class PrintWorld implements Runnable{
    duoxiancheng.HelloWorld helloWorld;
    public PrintWorld(duoxiancheng.HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }
    @Override
    public void run(){
        try {
            helloWorld.world();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PrintHello implements Runnable {
    duoxiancheng.HelloWorld helloWorld;
    public PrintHello(duoxiancheng.HelloWorld helloWorld){
        this.helloWorld = helloWorld;
    }
    @Override
    public void run() {
        try {
            helloWorld.hello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        duoxiancheng.HelloWorld helloWorld = new duoxiancheng.HelloWorld(n);
        duoxiancheng.PrintHello printHello = new duoxiancheng.PrintHello(helloWorld);
        duoxiancheng.PrintWorld printWorld = new duoxiancheng.PrintWorld(helloWorld);
        new Thread(printHello).start();
        new Thread(printWorld).start();
    }
}