package org.jacob.designpattern;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TheadApp {
    public static void main(String[] args) {
        Table table = new Table(100);
        new producerThread(table).start();
        new consumerThread(table).start();
        new consumerThread(table).start();
    }
}

class Table {
    private final BlockingQueue<String> buffer;

    public Table(int count) {
        this.buffer = new ArrayBlockingQueue<String>(10);
    }

    public void put(String packet) throws InterruptedException {
        Thread.sleep(1000);
        buffer.put(packet);
    }

    public String take() throws InterruptedException {
        return buffer.take();
    }
}

class producerThread extends Thread {
    private static int id = 0;
    Table table;

    public producerThread(Table table) {
        this.table = table;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                String packet = "No : " + nextId();
                table.put(packet);  // 큐에 추가
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}

 class consumerThread extends Thread {
    private final Table table;
    public consumerThread(Table table) {
        this.table = table;
    }

    public void run() {
        while (true) {
            String packet = null;   // 큐에서 가져옴
            try {
                packet = table.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(currentThread().getName() + " consumer : " + packet);

        }

    }

}