//: generics/GenericArray.java
package generics; /* Added by Eclipse.py */

import java.lang.reflect.Array;

public class GenericArray<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai =
                new GenericArray<Integer>(10);
        // This causes a ClassCastException:
        try {
            Integer[] ia = gai.rep();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        // This is OK:
        Object[] oa = gai.rep();
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    // Method that exposes the underlying representation:
    public T[] rep() {
        return array;
    }
} ///:~
