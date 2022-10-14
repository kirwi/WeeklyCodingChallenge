package dev.kirwi.flist;

import java.util.NoSuchElementException;

public class Nil<T> extends FList<T>{

    public T head() {
        throw new NoSuchElementException("Head of empty list");
    }

    public FList<T> tail() {
        throw new NoSuchElementException("Tail of empty list");
    }

    public boolean isEmpty() {
        return true;
    }

    public Nil() {
        super();
    }
}
