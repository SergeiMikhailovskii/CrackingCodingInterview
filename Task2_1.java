package com.mikhailovskii.task1_5;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Task2_1 {

    public static void main(String[] args) {
        Node node = new Node(1);
        node = node.addNode(2);
        node = node.addNode(3);
        node = node.addNode(4);
        node = node.addNode(5);
        node = node.addNode(3);
        node = node.addNode(4);

        node.showAllNodes(node);
        System.out.println();
        System.out.println();
        node = node.removeDuplicates();
        node.showAllNodes(node);
    }

    private static class Node {

        private int value;
        private Node next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

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

        Node removeDuplicates() {
            Node node = this;

            Set<Integer> unique = new HashSet<>();

            while (node != null) {
                if (!unique.contains(node.value)) {
                    unique.add(node.value);
                }
                node = node.next;
            }

            Node newNode = null;

            for (Iterator<Integer> it = unique.iterator(); it.hasNext(); ) {
                if (newNode == null) {
                    newNode = new Node(it.next());
                } else {
                    newNode = newNode.addNode(it.next());
                }
            }

            return newNode;
        }


    }

}
