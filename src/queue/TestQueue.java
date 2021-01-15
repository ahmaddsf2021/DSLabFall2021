/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

public class TestQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue(1);
        linkedQueue.enqueue(2);
        linkedQueue.enqueue(3);
        linkedQueue.enqueue(4);
        linkedQueue.enqueue(5);

        System.out.println("Linked Queue with 5 values: ");
        linkedQueue.print();

        linkedQueue.dequeue();
        linkedQueue.dequeue();
        System.out.println("Linked Queue after dequeueing twice.");
        linkedQueue.print();
        
        System.out.println("===============================================");
        
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);

        System.out.println("Array Queue Queue with 5 values: ");
        arrayQueue.print();

        arrayQueue.dequeue();
        arrayQueue.dequeue();
        System.out.println("Array Queue after dequeueing twice.");
        arrayQueue.print();
    }

}
