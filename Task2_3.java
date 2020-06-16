package com.mikhailovskii.task1_5;

public class Task2_3 {

    public static void main(String[] args) {
        Node node = new Node(1);

        node = node.addNode(2);
        node = node.addNode(3);
        node = node.addNode(4);
        node = node.addNode(5);
        node = node.addNode(6);
        node = node.addNode(7);

        node.showAllNodes(node);
        System.out.println();
        System.out.println();

        node = node.removeElementFromTheMiddleOfList(1);
        node.showAllNodes(node);

    }

    private static class Node {

        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }

        Node addNode(int value) {
            Node node = this;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(value);
            return this;
        }

        void showAllNodes(Node node) {
            System.out.println(node.value);
            if (node.next != null) {
                showAllNodes(node.next);
            }
        }

        int countElementsAmount() {
            int count = 0;

            Node node = this;

            while (node != null) {
                count++;
                node = node.next;
            }

            return count;
        }

        int searchKFromLastElement(int n, int size) {
            Node node = this;

            n = size - n;

            while (n != 0) {
                node = node.next;
                n--;
            }

            return node.value;
        }

        Node removeElementFromTheMiddleOfList(int element) {
            Node node = this;

            while (node.next != null) {
                if (node.next.value == element) {
                    node.next = node.next.next;
                }
                node = node.next;
            }

            return this;
        }


    }

}
