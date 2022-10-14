package dev.kirwi.flist;

public class Cons<T> extends FList<T> {

    private T h;
    private FList<T> t;

    public T head() {
        return h;
    }

    public FList<T> tail() {
        return t;
    }

    public boolean isEmpty() {
        return false;
    }

    public Cons(T h, FList<T> t) {
        this.h = h;
        this.t = t;
    }
}
