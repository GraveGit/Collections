package org.collections;

public interface CarSet extends CarCollection{
    boolean add(Car car);
    boolean remove(Car car);
    int size();
    void clear();
    boolean contains(Car car);
}
