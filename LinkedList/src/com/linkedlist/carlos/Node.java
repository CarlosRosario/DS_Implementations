package com.linkedlist.carlos;

/**
 * Created by Carlos on 9/11/2016.
 */
public class Node {
    private Node next;
    private Object data;

    public Node(Object data){
        this.data = data;
        next = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {

        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
