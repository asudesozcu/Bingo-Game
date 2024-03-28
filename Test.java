/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tombala;

import java.util.Random;

/**
 *
 * @author sozcu
 */
public class Test<T> {

    public static void main(String[] args) {
       // bıngoMethods<Integer> bingo = new bıngoMethods<>();
       // Node<Integer> head = bingo.generateCard();
      //  bıngoMethods.displayCard(head);
        
 Random random = new Random();
    Node head = null;

    while (true) {
        int randomNumber = random.nextInt(90) + 1;
        if (head == null || !contains(head, randomNumber)) {
            Node newNode = new Node(randomNumber);
            newNode.next = head;
            head = newNode;   
            System.out.println("Seçilen sayı: " + randomNumber); 
            break; // Eşsiz bir sayı bulunduğunda döngüyü sonlandır
        }
    }
    }

    
    
    
    
    
     public static boolean contains(Node head, int number) {
    Node temp = head;
    while (temp != null) {
        if (temp.data == number) {
            return true; // Sayı listede bulunduğunda true döndür
        }
        temp = temp.next;
    }
    return false; // Sayı listede bulunamadığında false döndür
}
    
    
    
    // Tabloyu yazdıran metot
    public static <T> void printTable(Node<T> head) {
        Node<T> current = head;
        while (current != null) {
            Node<T> temp = current;
            while (temp != null) {
                System.out.println("Element: " + temp.data);
                System.out.println("Next: " + (temp.next != null ? temp.next.data : "null"));
                System.out.println("Down: " + (temp.down != null ? temp.down.data : "null"));
                System.out.println("----------------------------------");
                temp = temp.next;
            }
            current = current.down; // Sonraki satıra geç
        }
    }
    // Displaying the generated card
    //  bıngoMethods<Integer> generator = new bıngoMethods<>();
    //Node<Integer> card = generator.generateCard();
    //System.out.println("-------------------------");
    //bıngoMethods.displayCard(card);

    //generator.sortColumns();
    //generator.sortRows();;
    // bıngoMethods.displayCard(card);
    //bingo.sortAndMatchDown(head);
    // bingo.generateCard();
    //bingo.sortAndMatchDown();
    // bingo.printBingoCard();
}
