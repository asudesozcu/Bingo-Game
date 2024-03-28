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
public class bıngoMethods<T> {

    Node<T> head;
    int size = 0;

    public int[][] generateCard() {
        Random random = new Random();
        int[][] ArrayCard = new int[3][9];

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
        RandomNumbers(ArrayCard);
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

    public void RandomNumbers(int[][] card) {
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

    public Node arrayToMultiLinkedList(int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return null;
        }

        Node head = null;
        Node temp = null;

        for (int i = 0; i < array.length; i++) {
            Node rowHead = null;
            Node rowTemp = null;

            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != -1) {
                    if (rowHead == null) {
                        rowHead = new Node(array[i][j]);
                        rowTemp = rowHead;
                    } else {
                        rowTemp.next = new Node(array[i][j]);
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

    void connectDownLinks(Node head) {
    Node tempRow = head;

    while (tempRow != null) {
        Node temp = tempRow;
        Node nextRow = tempRow.down;

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
    
    

    /*  public void MakeDownConnection(Node head) {
        Node temp = head;
        Node<T> firstbegin = head;
        Node<T> secondRowbegin = null;
        Node<T> thirdRowbegin = null;
        int count = 1;
        if (head == null) {
            System.out.println("Empty list");
        } else {
            while (temp.next != null) {
                if (temp.data < 10 && count == 1) {
                    secondRowbegin = temp;
                    count++;

                } else if (temp.data < 10 && count == 2) {
                    thirdRowbegin = temp;
                }
            }
            temp = temp.next;
        }
       // makeDownConnection(firstbegin, secondRowbegin, thirdRowbegin);
    }

    
   

     public Node<T> generateCard() {
        Random random = new Random();

        Node<T> secondRowBegin = new Node<>();
        Node<T> thirdRowBegin = new Node<>();
        secondRowBegin.down = thirdRowBegin;
        thirdRowBegin.down = null;

        Node<T> tempFirstRow = new Node<>();
        Node<T> tempSecondRow = new Node<>();
        Node<T> tempThirdRow = new Node<>();

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

            Node<T> temp = head;
            while (temp != null) {
                if (temp.data == number) {
                    isUnique = false;
                    break;
                }
                temp = temp.next;
            }

            temp = secondRowBegin;
            while (temp != null) {
                if (temp.data == number) {
                    isUnique = false;
                    break;
                }
                temp = temp.next;
            }

            temp = thirdRowBegin;
            while (temp != null) {
                if (temp.data == number) {
                    isUnique = false;
                    break;
                }
                temp = temp.next;
            }

            if (isUnique) {

                size++;

                Node<T> newNode = new Node<>(number);
                if (size == 1) {
                    head = newNode;
                    tempFirstRow = head;
                } else if (size == 9) {
                    tempFirstRow.next = newNode;
                    newNode.prev = tempFirstRow;
                    tempFirstRow = newNode;

                } else if (size == 10) {
                    secondRowBegin = newNode;
                    tempSecondRow = secondRowBegin;

                } else if (size == 18) {
                    tempSecondRow.next = newNode;
                    newNode.prev = tempSecondRow;
                    tempSecondRow = newNode;

                } else if (size == 19) {
                    thirdRowBegin = newNode;
                    tempThirdRow = thirdRowBegin;

                } else {
                    if (size < 9) {
                        tempFirstRow.next = newNode;
                        newNode.prev = tempFirstRow;
                        tempFirstRow = newNode;
                    } else if (size < 18) {
                        tempSecondRow.next = newNode;
                        newNode.prev = tempSecondRow;
                        tempSecondRow = newNode;
                    } else {
                        tempThirdRow.next = newNode;
                        newNode.prev = tempThirdRow;
                        tempThirdRow = newNode;
                    }
                }

            }
        }

        makeDownConnection(head, secondRowBegin, thirdRowBegin);
        sortColumns(head);
        return head;
    }
    public void makeDownConnection(Node<T> firstRowbegin, Node<T> secondRowbegin, Node<T> thirdRowbegin) {
        Node<T> firstRowCurrent = firstRowbegin;
        Node<T> secondRowCurrent = secondRowbegin;
        Node<T> thirdRowCurrent = thirdRowbegin;

        while (firstRowCurrent != null && secondRowCurrent != null && thirdRowCurrent != null) {
            firstRowCurrent.down = secondRowCurrent;
            secondRowCurrent.down = thirdRowCurrent;

            firstRowCurrent = firstRowCurrent.next;
            secondRowCurrent = secondRowCurrent.next;
            thirdRowCurrent = thirdRowCurrent.next;
        }
    }

    */

    private boolean contains(int data) {
        Node temp = head;
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
            number = random.nextInt(90);
        } while (contains(number));
        if (!contains(number)) {
            Node newnode = new Node(number);
            newnode.next = head;
            head = newnode;
        }
        return number;
    }
    
    public static void displayCard(Node<Integer> head) {
        Node<Integer> currentRow = head;
        while (currentRow != null) {
            Node<Integer> currentColumn = currentRow;
            while (currentColumn != null) {
                System.out.print(currentColumn.data + "\t");
                currentColumn = currentColumn.next;
            }
            System.out.println();
            currentRow = currentRow.down;
        }
    }
}
