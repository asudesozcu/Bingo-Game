/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tombala;

import java.util.Arrays;

/**
 *
 * @author sozcu
 */
public class TestArray {

    public static void main(String[] args) {
        bıngoMethods generator = new bıngoMethods();
        int[][] card = generator.generateCard();

        generator.print(card);
        System.out.println("--------------------");
        Node head = generator.arrayToMultiLinkedList(card);
        System.out.println("----------------------------------------");
        generator.displayCard(head);
        System.out.println("----------------------------------------");
        Test.printTable(head);

    }
}
