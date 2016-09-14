package com.linkedlist.carlos;

/**
 * Created by Carlos on 9/11/2016.
 */
public class CarlosLinkedList {

    private Node head;
    private int size;

    public int getSize(){
        return size;
    }

    public Node getHead(){
        return head;
    }

    public void insert(Object data){
        if(head == null){
            head = new Node(data);
            size++;
        }
        else {
            Node currentNode = head;
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new Node(data));
            size++;
        }
    }

    public Node remove(int index){
        Node returnValue = null;

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        else {
            if(index == 0){
                returnValue = head;
                head = head.getNext();
                size--;
            }else{
                Node currentNode = head;
                if(currentNode != null){
                    for(int i = 1; i < index; i++){
                        currentNode = currentNode.getNext();
                    }
                    returnValue = currentNode.getNext();
                    currentNode.setNext(currentNode.getNext().getNext());
                    size --;
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
        }
        return returnValue;
    }

    public Node get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        } else {
            if(index == 0){
                return head;
            }else {
                Node currentNode = head;
                if(currentNode != null) {
                    for (int i = 1; i < index; i++) {
                        currentNode = currentNode.getNext();
                    }
                    return currentNode.getNext();
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
        }
    }


    public String toString() {
        String output = "";

        if (head != null) {
            Node currentNode = head;
            while (currentNode != null) {
                output += "[" + currentNode.getData().toString() + "]";
                currentNode = currentNode.getNext();
            }

        }
        return output;
    }


}
