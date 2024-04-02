/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tombala;

/**
 *
 * @author sozcu
 */
public class AsudeSozcuNodeClass {

    int data;
    AsudeSozcuNodeClass next;
    AsudeSozcuNodeClass  down;
    boolean isFound=false;

    public AsudeSozcuNodeClass(int data) {
        this.data = data;

    }

    public AsudeSozcuNodeClass(int data, AsudeSozcuNodeClass next,  AsudeSozcuNodeClass down) {
        this.data = data;
        this.next = next;
        this.down = down;
    }

    AsudeSozcuNodeClass() {
    }

    

    
    
}
