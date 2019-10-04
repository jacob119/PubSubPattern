package org.jacob.designpattern.pubsub;

public class Subscriber {
    int id;
    public Subscriber(int id) {
        this.id = id;
    }

    @OnMessage
    private void onMessage(Message message) {
        System.out.println("on Message : " + message.message);
    }
}
