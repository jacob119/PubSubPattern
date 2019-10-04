package org.jacob.designpattern.pubsub;

abstract class Post {
    String message;

    Post(String message) {
        this.message = message;
    }
}