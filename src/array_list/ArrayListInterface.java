
package array_list;


public interface ArrayListInterface {

    //returns the current size of the arraylist
    public int size();

    //gets the element at the given index
    public Object getElement(int index);

    /*
    this function is similar to the previously implemented contains method
    => contains method returns boolean: true if found, false if not
    => while indexOf method returns the index where the element was found, and -1 if not found
     */
    //get the index of the given element
    public int indexOf(Object element);

    //adds new element to the end of the arraylist
    public void add(Object newElement);

    //removes last element of the arraylist
    public void remove();

    //removes the element at the given index from the arraylist
    public void remove(int index);

    //removes the given element from arraylist
    public void remove(Object oldElement);

    //ADDITIONAL FUNCTION
    //merges another arraylist to the original
    public ArrayList concat(ArrayList l2);
}
