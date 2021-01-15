/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singly_linked_list;

public class TestSLL {
    
    public static void testMergeFunction (SLL firstList){
        SLL secondList = new SLL();
        secondList.add("Sirin");
        secondList.add("Hassan");
        secondList.add("Ahmad");

        SLL mergedList = SLL.merge(firstList, secondList);
        mergedList.print();
    }

    /**
     * @param args the command line arguments //Testing my code here in main
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SLL myList = new SLL("Marc");
        myList.add("Mahdi");
        myList.add("Khodor");
        myList.add("Zeina");

        System.out.println(myList.get(3));
        System.out.println(myList.get(1));

        System.out.println(myList.indexOf("Khodor"));
        
        System.out.println(myList.size());
        
        myList.print();
        
        //function to test if our merge two linked lists function is working
//        testMergeFunction(myList);
        
        //Testing of remove functions:
        
        //Try myList.remove(-1) to test function behavior if index is out of bounds
        //Try myList.remove("Bader") which is a non-existing element
        
        myList.remove();
        myList.print();
        
        myList.remove(1);
        myList.print();
        
        myList.remove(0);
        myList.print();
        
        myList.remove("Khodor");
        myList.print();
    }

}
