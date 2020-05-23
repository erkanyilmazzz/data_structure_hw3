package com.company;

import java.util.Iterator;

public class Stack<E> implements Iterable<E> {

    private Node<E> _head;
    private Node<E> _tail;

    private int _size;
    private Iter<Node<E>> iterator;


    public Stack(){

        _head=null;
        _tail=null;
        _size=0;
    }


    public boolean empty(){
        return !(_size>0);
    }
    public E peek(){
        return _tail.get_data();
    }

    public E pop(){
         if(_size>0){
             E _temp;
             _temp=_tail.get_data();
             _tail=_tail.getPrev();
             _size--;
             return _temp;

         }else{
             _size--;

         }
    return null;
    }

    public E push(E item){
       Node<E> newNode=new Node<>();
       newNode.set_data(item);

       if(_size==0){
            _head=newNode;
            _tail=newNode;
           _tail.setPrev(null);
       }else{

           _tail.setNext(newNode);
           newNode.setPrev(_tail);
           _tail=_tail.getNext();

       }

       _size++;
    //   System.out.println("kuruk"+_tail.get_data()+item);
        return item;
    }


    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) iterator;
    }

    public int get_size() {
        return _size;
    }
}
