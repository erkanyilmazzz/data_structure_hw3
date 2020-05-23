package com.company;

public class Node<E> {
    private E _data;
    private Node next;
    private Node prev;


    public Node(){
        next=null;
        prev=null;

    }

    public void set_data(E data){
        _data=data;
    }
    public void setNext(Node<E> newNode){
        next=newNode;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getPrev() {
        return prev;
    }

    public E get_data(){
        return _data;
    }
    public Node getNext(){
        return  next;
    }


}
