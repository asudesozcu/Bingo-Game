/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.tombala;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author sozcu
 */
public class AsudeSozcuBıngoMethodsClass {

    AsudeSozcuNodeClass head;
    int size = 0;
      static int[][] ArrayCard = new int[3][9];

    public int[][] generateCard() {
        Random random = new Random();

        while (size < 27) {
            int number;
            switch (size % 9) {
                case 0:
                    number = 1 + random.nextInt(9);
                    break;
                case 1:
                    number = 10 + random.nextInt(10);
                    break;
                case 2:
                    number = 20 + random.nextInt(10);
                    break;
                case 3:
                    number = 30 + random.nextInt(10);
                    break;
                case 4:
                    number = 40 + random.nextInt(10);
                    break;
                case 5:
                    number = 50 + random.nextInt(10);
                    break;
                case 6:
                    number = 60 + random.nextInt(10);
                    break;
                case 7:
                    number = 70 + random.nextInt(10);
                    break;
                default:
                    number = 80 + random.nextInt(10);
                    break;
            }

            boolean isUnique = true;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 9; j++) {
                    if (ArrayCard[i][j] == number) {
                        isUnique = false;
                        break;
                    }
                }
            }

            if (isUnique) {
                int row = size / 9;
                int column = size % 9;
                ArrayCard[row][column] = number;
                size++;
            }
        }
        sortColumns(ArrayCard);
        RandomBlockedNumbers(ArrayCard);
        return ArrayCard;
    }

    public void sortColumns(int[][] card) {
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 2; i++) {
                for (int k = i + 1; k < 3; k++) {
                    if (card[i][j] > card[k][j]) {

                        int temp = card[i][j];
                        card[i][j] = card[k][j];
                        card[k][j] = temp;
                    }
                }
            }
        }
    }

    public void RandomBlockedNumbers(int[][] card) {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int count = 0;
            while (count < 4) {
                int column = random.nextInt(9);

                if (card[i][column] != -1) {
                    card[i][column] = -1;
                    count++;
                }
            }
        }
    }

    public void print(int[][] card) {
        for (int[] row : card) {
            for (int cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }

    public AsudeSozcuNodeClass arrayToMultiLinkedList(int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return null;
        }

        AsudeSozcuNodeClass head = null;
        AsudeSozcuNodeClass temp = null;

        for (int i = 0; i < array.length; i++) {
            AsudeSozcuNodeClass rowHead = null;
            AsudeSozcuNodeClass rowTemp = null;

            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != -1) {
                    if (rowHead == null) {
                        rowHead = new AsudeSozcuNodeClass(array[i][j]);
                        rowTemp = rowHead;
                    } else {
                        rowTemp.next = new AsudeSozcuNodeClass(array[i][j]);
                        rowTemp = rowTemp.next;
                    }
                }
            }

            if (head == null) {
                head = rowHead;
            } else {
                temp = head;
                while (temp.down != null) {
                    temp = temp.down;
                }
                temp.down = rowHead;
            }
        }

        connectDownLinks(head);

        return head;
    }

    void connectDownLinks(AsudeSozcuNodeClass head) {
    AsudeSozcuNodeClass tempRow = head;

    while (tempRow != null) {
        AsudeSozcuNodeClass temp = tempRow;
        AsudeSozcuNodeClass nextRow = tempRow.down;

        if (nextRow != null) {
            while (temp != null && nextRow != null) {
                temp.down = nextRow;
                temp = temp.next;
                nextRow = nextRow.next;
            }
        }

        tempRow = tempRow.down; 
    }
}
  
    private boolean contains(int data) {
        AsudeSozcuNodeClass temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int generateRandomNumber() {
        Random random = new Random();
        int number;
        do {
            number = random.nextInt(90)+1;
        } while (contains(number));
        if (!contains(number)) {
            AsudeSozcuNodeClass newnode = new AsudeSozcuNodeClass(number);
            newnode.next = head;
            head = newnode;
        }
        return number;
    }
    
   /* public static void displayCard(AsudeSozcuNodeClass head) {
        AsudeSozcuNodeClass currentRow = head;
        while (currentRow != null) {
            AsudeSozcuNodeClass currentColumn = currentRow;
            while (currentColumn != null) {
                System.out.print(currentColumn.data + "\t");
                currentColumn = currentColumn.next;
            }
            System.out.println();
            currentRow = currentRow.down;
        }
    
    */
}
