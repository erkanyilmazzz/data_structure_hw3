package com.company;

import java.util.Iterator;

public class Iter<E> implements Iterator<E> {
    private E next;
    private E prev;

    @Override
    public boolean hasNext() {
        return next!=null;
    }

    @Override
    public E next() {
        return next;
    }
    private int size;
    private int index;

    public Iter(E next, E prev, int size, int index) {
        this.next = next;
        this.prev = prev;
        this.size = size;
        this.index = index;
    }
    public Iter(){
        next=null;
        prev=null;
        size=0;
        index=0;
    }

    public E get_next() {
        return next;
    }

    public void set_next(E _next) {
        this.next = _next;
    }

    public E get_prev() {
        return prev;
    }

    public void set_prev(E _prev) {
        this.prev = _prev;
    }
}
