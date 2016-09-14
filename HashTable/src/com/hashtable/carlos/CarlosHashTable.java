package com.hashtable.carlos;

import com.linkedlist.carlos.CarlosLinkedList;
import com.linkedlist.carlos.Node;

/**
 * Created by Carlos on 9/11/2016.
 */
public class CarlosHashTable<K,V> {

    //private static int TABLE_SIZE = 31;
    private static int TABLE_SIZE = 32;
    //private static int TABLE_SIZE = 50;
    //private static int TABLE_SIZE = 64;
    private int size;

    CarlosLinkedList[] hashtable = new CarlosLinkedList[TABLE_SIZE];

    public CarlosHashTable(){
        for(int i = 0; i < TABLE_SIZE; i++){
            hashtable[i] = new CarlosLinkedList();
        }
    }

    public void put(K key, V value){
        // Compute hash
        int tableIndex = computeHash(key.hashCode());
        System.out.println(tableIndex);
        // Insert into table
        CarlosHashEntry<K,V> entry = getHashEntryForKey(key,tableIndex);
        if(entry == null){
            hashtable[tableIndex].insert(new CarlosHashEntry<K, V>(key, value));
            size++;
        }
        else {
            entry.setValue(value);
        }
    }

    // remove key, value pair given a key and return the value that was removed
    public V remove(K key){
        if(!contains(key)){
            return null;
        }

        int tableIndex = computeHash(key.hashCode());
        int index = findKey(key, tableIndex);
        size--;
        return removeValueGivenIndices(tableIndex, index);
    }

    // get value given a key
    public V get(K key){
        if(!contains(key)){
            return null;
        }

        int tableIndex = computeHash(key.hashCode());
        int index = findKey(key, tableIndex);
        return getValueGivenIndices(tableIndex, index);
    }

    private V getValueGivenIndices(int tableIndex, int index){
        return ((CarlosHashEntry<K,V>)hashtable[tableIndex].get(index).getData()).getValue();
    }

    private V removeValueGivenIndices(int tableIndex, int index){
        return ((CarlosHashEntry<K,V>)hashtable[tableIndex].remove(index).getData()).getValue();
    }

    // return number of keys in the hashtable (size of hashtable basically)
    public int getSize(){
        return size;
    }

    private int computeHash(int h){
        //return simpleHash(h);
        return bitwiseHash(h);
    }

    private int simpleHash(int h){
        return h % TABLE_SIZE;
    }

    private int bitwiseHash(int h){
        //int powerOf2InTableSize = Integer.highestOneBit(TABLE_SIZE) << 1;
        int tableMask = TABLE_SIZE - 1;
        int hash = h & tableMask;
        return hash;

    }

    // I didn't come up with this hash function, this is javas way of doing it.
    private int javahash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    // check if hashtable contains key
    public boolean contains(K key){
        int tableIndex = computeHash(key.hashCode());
        if( findKey(key, tableIndex) >= 0){
            return true;
        } else {
            return false;
        }
    }

    // Given a key, return the corresponding CarlosHashEntry object. Return null if the key does not exist in the hashtable
//    private Node findKey(K key, int tableIndex){
//        Node currentNode = hashtable[tableIndex].getHead();
//        while(currentNode != null){
//            // Does this key already exist in the hashtable?
//            if(key.equals( ((CarlosHashEntry<K,V>)currentNode.getData()).getKey() )){
//                return currentNode;
//                //return (CarlosHashEntry<K,V>)currentNode.getData();
//            }
//            currentNode = currentNode.getNext();
//        }
//        return null;
//    }

    private Node getNodeForKey(K key, int tableIndex){
        int index = findKey(key, tableIndex);
        return index >= 0 ? hashtable[tableIndex].get(index) : null;
    }

    private CarlosHashEntry getHashEntryForKey(K key, int tableIndex){
        Node node = getNodeForKey(key,tableIndex);
        return node != null ? (CarlosHashEntry<K,V>)node.getData() : null;
    }

    private int findKey(K key, int tableIndex){
        Node currentNode = hashtable[tableIndex].getHead();
        int index = 0;

        while(currentNode != null){
            // Does this key already exist in the hashtable?
            if(key.equals( ((CarlosHashEntry<K,V>)currentNode.getData()).getKey() )){
                return index;
            }
            currentNode = currentNode.getNext();
            index++;
        }
        return -1;
    }
}
