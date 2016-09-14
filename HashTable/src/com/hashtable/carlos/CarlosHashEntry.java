package com.hashtable.carlos;

/**
 * Created by Carlos on 9/11/2016.
 */
public class CarlosHashEntry<K,V> {

    private K key;
    private V value;

    public CarlosHashEntry(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
