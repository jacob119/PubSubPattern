package org.jacob.designpattern.pubsub;

// https://medium.com/easyread/create-your-own-java-pubsub-library-fbee21d0bb44
// http://www.code2succeed.com/pub-sub/
public class PubSubApp {
    public static void main(String[] args) {
        Subscriber subscriber = new Subscriber(1);
        Subscriber subscriber2 = new Subscriber(2);

        Subscriber subscriber3 = new Subscriber(3);
        Subscriber subscriber4 = new Subscriber(4);

        Event.operation.subscribe("action#create", subscriber);
        Event.operation.subscribe("action#create", subscriber2);

        Event.operation.subscribe("action#update", subscriber3);
        Event.operation.subscribe("action#delete", subscriber4);

        Message message = new Message("Create Action");
        Message message2 = new Message("Update Action");

        Event.operation.publish("action#create", message);
        Event.operation.publish("action#update", message2);
    }
}
