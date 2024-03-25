package org.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CarListTest {

    private CarList carList;

    @Before
    public void setUp() throws Exception {
        carList = new CarArrayList() {
        };
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100elementsThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        carList.removeAt(5);
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        Car toyota = new Car("Toyota", 2);
        carList.add(toyota);
        assertEquals(101, carList.size());
        carList.remove(toyota);
        assertEquals(100, carList.size());
    }

    @Test()
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Car toyota = new Car("Toyota", 2);
        assertFalse(carList.remove(toyota));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException() {
        carList.get(100);
    }

    @Test
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
        assertEquals(0, car.getNumber());
    }

    @Test
    public void insertIntoMiddle() {
        Car car = new Car("BMW", 1);
        carList.add(car, 50);
        Car carFromList = carList.get(50);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoFirstPosition() {
        Car car = new Car("BMW", 1);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoLastPosition() {
        Car car = new Car("BMW", 1);
        carList.add(car, 100);
        Car carFromList = carList.get(100);
        assertEquals("BMW", carFromList.getBrand());

    }
}