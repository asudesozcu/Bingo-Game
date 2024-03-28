/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tombala;

/**
 *
 * @author sozcu
 */
public class Node<T> {

    int data;
    Node<T> next;
    Node<T> down;
    boolean isFound=false;

    public Node(int data) {
        this.data = data;

    }

    public Node(int data, Node<T> next,  Node<T> down) {
        this.data = data;
        this.next = next;
        this.down = down;
    }

    Node() {
    }

    

    
    
}
