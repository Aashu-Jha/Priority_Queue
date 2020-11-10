package com.meow;

import java.util.ArrayList;

public class PriorityQueue<E extends Comparable<E>> implements Comparable<PriorityQueue<E>> {
    ArrayList<E> elements;

    //constructor
    public PriorityQueue(){
        elements = new ArrayList<E>();
    }

    @Override
    public int compareTo(PriorityQueue<E> o) {
        return this.peek().compareTo(o.peek());
    }


    /*
        Insert elements in PriorityQueue in O(log n) time.
        *throw a exceptions if it reaches its maxsize.
     */
    public void add(E e) {
        elements.add(e);
        upHeapify(elements.size() - 1);
    }

    /*
        remove function removes the smallest element in the list in O(log n) time.

     */
    public E remove() throws  Exception{
        if( isEmpty( ) )
            throw new Exception("Invalid operation. Cannot find head of empty queue");
        else{
            swap(0, elements.size() - 1);
            E val = elements.remove(elements.size() - 1);
            downHeapify(0);
            return val;
        }

    }

    /*
        *return first element in priority queue
     */
    public E peek()
    {
        if( !isEmpty( ) )
            return elements.get(0);
        return null;

    }

    /*
        compares parent leaf with both child leaf and swap if found smaller.
        Repeat until no child has found or child elements value is smaller than parent
     */

    private void downHeapify(int position){
        int current = position;

        int left = 2 * position + 1;
        if(isValidChild(left) && isSmaller(left, current))
            current = left;

        int right = 2 * position + 2;
        if(isValidChild(right) && isSmaller(right, current))
            current = right;

        if(current != position){
            swap(position, current);
            downHeapify(current);
        }

    }

    private boolean isValidChild(int position)
    {
        return (position < elements.size());
    }


    /*
        compare both curr_element and its parent element and if its small then swap will call.
        *takes parameter position from add
     */
    private void upHeapify(int position){
        if(position == 0) return;

        int parent = parent(position);
        if(isSmaller(position, parent)){
            swap(position, parent );
            upHeapify(parent);
        }
    }

    private int parent(int position){    //to find the upper element
        if(position==0)
            return 0;
        return (int)Math.floor((position-1)/2D);
    }

    private boolean isSmaller(int i, int j){
        E ith = elements.get(i);
        E jth = elements.get(j);

        return ith.compareTo( jth) < 0;
    }

    private void swap(int i, int j){
        E ith = elements.get(i);
        E jth = elements.get(j);

        elements.set(i, jth);
        elements.set(j, ith);
    }

    public int size() {
        return elements.size();
    }



    // check for empty Priority queue
    public boolean isEmpty()
    {
        return elements.isEmpty();
    }

    //Set Priority queue to 0 i.e, removes all elements from queue
    public void clear(){
        elements.clear();
    }

    //check for elements in priority queue
    public boolean contains(E e){
        return elements.contains(e);
    }
}
