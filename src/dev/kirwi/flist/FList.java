package dev.kirwi.flist;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class FList<T> {
    public abstract T head();
    public abstract FList<T> tail();
    public abstract boolean isEmpty();

    public <U extends T> FList<T> add(U e) {
        return new Cons(e, this);
    }

    public <U extends T> FList<T> concat(FList<U> that) {
        if (that.isEmpty()) {
            return this;
        } else {
            return new Cons(this.head(), this.tail().concat(that));
        }
    }

    public <U extends T> FList<T> insert(int i, U e) {
        if (i < 1 || this.isEmpty()) {
            return new Cons(e, this);
        } else {
            return new Cons(this.head(), this.tail().insert(i-1, e));
        }
    }

    public <U> FList<U> map(Function<T, U> f) {
        if (this.isEmpty()) {
            return (FList<U>) this;
        } else {
            return new Cons<>(f.apply(this.head()), this.tail().map(f));
        }
    }

    public FList<T> filter(Predicate<T> f) {
        if (this.isEmpty()) {
            return this;
        } else if (f.test(this.head())){
            return new Cons(this.head(), this.tail().filter(f));
        } else {
            return this.tail().filter(f);
        }
    }

    public <U> U foldLeft(U acc, BiFunction<T, U, U> f) {
        if (this.isEmpty()) {
            return acc;
        } else {
            return this.tail().foldLeft(f.apply(this.head(), acc), f);
        }
    }
}
