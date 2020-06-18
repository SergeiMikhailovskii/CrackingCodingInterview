package com.mikhailovskii.task1_5;

public class Task2_6 {

    public static void main(String[] args) {
        Node node = new Node(1);
        node = node.addNode(2);
        node = node.addNode(3);
        node = node.addNode(2);
        node = node.addNode(1);

        node.showAllNodes(node);

        System.out.println(node.isPalindrome());

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

        boolean isPalindrome() {
            boolean isPalindrome = true;
            Node startNode = this;

            while (true) {
                Node endNode = startNode;

                if (endNode == null || endNode.next == null) {
                    break;
                }

                while (endNode.next.next != null) {
                    endNode = endNode.next;
                }

                if (endNode.next.value != startNode.value) {
                    isPalindrome = false;
                    break;
                } else {
                    endNode.next = null;
                    startNode = startNode.next;
                }

            }

            return isPalindrome;
        }


    }

}
