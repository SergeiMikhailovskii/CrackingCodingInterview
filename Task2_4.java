package com.mikhailovskii.task1_5;

public class Task2_4 {

    public static void main(String[] args) {
        Node node = new Node(3);
        node = node.addNode(5);
        node = node.addNode(8);
        node = node.addNode(5);
        node = node.addNode(10);
        node = node.addNode(2);
        node = node.addNode(1);

        node.showAllNodes(node);
        System.out.println();
        System.out.println();

        node = node.partitionList(5);
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

        Node partitionList(int element) {
            Node newNode = null;
            Node node = this;

            while (node != null) {
                if (node.value < element) {
                    if (newNode == null) {
                        newNode = new Node(node.value);
                    } else {
                        newNode.addNode(node.value);
                    }
                }
                node = node.next;
            }

            node = this;
            while (node != null) {
                if (node.value >= element) {
                    newNode.addNode(node.value);
                }
                node = node.next;
            }

            return newNode;
        }


    }

}
