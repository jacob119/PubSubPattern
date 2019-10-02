package org.jacob.designpattern;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Producer p = new Producer();
        Consumer c = new Consumer();
        int result = p.produce();
        c.consume(result);
    }
}

class Producer {
    int id = 0;

    int produce() {
        return nextId();
    }

    int nextId() {
        return id = id + 1;
    }
}

class Consumer {
    void consume(int id) {
        System.out.println("ID : " + id);
    }
}