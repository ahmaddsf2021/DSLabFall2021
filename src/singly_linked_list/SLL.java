/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singly_linked_list;

public class SLL implements ListInterface {

    private Node head;

    public SLL() {
        this.head = null;
    }

    public SLL(Node head) {
        this.head = head;
    }

    public SLL(Object nodeValue) {
        this.head = new Node(nodeValue);
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
            //you can also check here if head.getNext() == null to return 1
            //but it's not necessary as it will be checked in the loop
        } else {
            Node currentNode = this.head;
            int count = 0;
            while (currentNode != null) {
                currentNode = currentNode.getNext();
                count++;
            }
            return count;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
        //similar to
//        if(this.head == null){
//            return false;
//        } else {
//            return true;
//        }
    }

    //clear linked list
    public void makeEmpty() {
        this.head = null;
    }

    public Node getHeadNode() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty! Can't fetch head.");
        } else {
            return this.head;
        }
    }

    public Object getHeadValue() {
        return this.getHeadNode().getValue();
    }

    public Node getTailNode() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty! Can't fetch tail.");
        }
        //initialize
        Node currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public Object getTailValue() {
        return this.getTailNode().getValue();
    }

    //remove initial conditions
    public Node getNode(int index) {
        //no need since we are throwing default exception after while loop
//        if (index < 0 || index >= size()) {
//            throw new ArrayIndexOutOfBoundsException();
//        } else if (isEmpty()) {
//            throw new RuntimeException("Cannot fetch node, list is empty!");
//        } else {

        Node currentNode = this.head;
        int i = 0;
        while (currentNode != null) {
            if (i == index) {
                return currentNode;
            }
            i++;
            currentNode = currentNode.getNext();
        }
        throw new RuntimeException("Object at given index is not found!");
//        }
    }

    @Override
    public Object get(int index) {
        return this.getNode(index).getValue();
    }

    //similar to contain method
    @Override
    public int indexOf(Object element) {
        Node currentNode = this.head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.getValue().equals(element)) {
                return index;
            }
            index++;
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    @Override
    public void add(Object newElement) {
        if (head == null) { //or if(isEmpty())
            head = new Node(newElement);
        } else {
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new Node(newElement));
        }
    }
    
    //removes the last element of the linked list
    @Override
    public void remove() {
        if (isEmpty()) { //OR if this.head == null //OR if size == 0
            throw new RuntimeException("List is empty.");
        } else if (this.head.getNext() == null) { //OR if size ==1
            this.makeEmpty();
        } else {
            Node tailNode = this.getTailNode();

            Node currentNode = head;
            while (!currentNode.getNext().equals(tailNode)) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(null);
        }
    }

    @Override
    public Object remove(int index) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        } else {
            if (index == 0) {
                return this.removeHead();
            } else {
                Node nodeAtIndex = this.getNode(index);
                Node currentNode = this.head;
                //traversing the linked list to find the node at given index
                while (!currentNode.getNext().equals(nodeAtIndex)) {
                    currentNode = currentNode.getNext();
                }

                currentNode.setNext(nodeAtIndex.getNext());
                return nodeAtIndex.getValue();
            }
        }
    }

    public Object removeHead() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty. Cannot remove head");
        } else {
            Node nodeToDelete = this.head;
            if (this.head.getNext() == null) {
                this.makeEmpty();
            } else {
                Node secondNode = this.head.getNext();
                this.head = secondNode;
            }
            return nodeToDelete.getValue();
        }
    }

    @Override
    public Object remove(Object element) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        } else {
            int indexOfElementToRemove = this.indexOf(element);
            return this.remove(indexOfElementToRemove);
        }
    }

    public static SLL merge(SLL list1, SLL list2) {
        //list1: 1 => 2 => 3
        //list2: 4 => 5 => 6
        //list3: 1 => 2 => 3 => 4 => 5 => 6
        if (list1.isEmpty()) //if list1.head == null
        {
            return list2;
        }
        if (list2.isEmpty()) {
            return list1;
        }

        if (list1.isEmpty() && list2.isEmpty()) {
            throw new RuntimeException();
        }

        //first way
//        SLL mergedList1 = new SLL();
//
//        Node head1 = list1.head; //or list1.getHeadNode();
//        Node head2 = list2.head; //or list2.getHeadNode();
//
//        Node tail1 = list1.getTailNode();
////        Node tail2 = list2.getTailNode(); I didn't use it
//
//        mergedList1.head = head1;
//        tail1.setNext(head2);
        //second way
        SLL mergedList2 = list1;
        mergedList2.getTailNode().setNext(list2.head);

        return mergedList2; //or uncomment first way, comment second way, and return mergedList1 to test first way;
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            Node currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.getValue() + " --> ");
                currentNode = currentNode.getNext();
            }
            System.out.println("");
        }
    }

}
