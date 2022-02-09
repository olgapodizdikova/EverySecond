package main.com.java.olgapoduzdikova;

import java.util.Iterator;

public class EverySecondIterator<T> implements Iterator<T> {
    private final Iterator<T> target;

    EverySecondIterator(Iterator<T> target) {
        this.target = target;
    }

    @Override
    public boolean hasNext() {
        return target.hasNext();
    }

    @Override
    public T next(){
        T next = target.next();
        if(target.hasNext()){
            target.next();
        }
        return next;
    }
}
