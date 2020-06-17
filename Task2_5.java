package com.mikhailovskii.task1_5;

public class Task2_5 {

    public static void main(String[] args) {
        Node firstNode = new Node(6);
        firstNode = firstNode.addNode(1);
        firstNode = firstNode.addNode(7);

        firstNode.showAllNodes(firstNode);

        System.out.println();
        System.out.println();

        Node secondNode = new Node(2);
        secondNode = secondNode.addNode(9);
        secondNode = secondNode.addNode(5);

        secondNode.showAllNodes(secondNode);

        System.out.println();
        System.out.println();

//        int sum = firstNode.reverseNodesSum() + secondNode.reverseNodesSum();
//
//        Node resultNode = Node.numberToNode(sum);
//
//        resultNode.showAllNodes(resultNode);

        int sum = firstNode.nodesSum() + secondNode.nodesSum();

        Node resultNode = Node.numberToNode(sum);

        resultNode.showAllNodes(resultNode);


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

        int reverseNodesSum() {
            int sum = 0;
            Node node = this;

            while (true) {
                if (node.next == null) {
                    sum = sum * 10 + node.value;
                    break;
                } else if (node.next.next == null) {
                    sum = sum * 10 + node.next.value;
                    node.next = null;
                    node = this;
                } else {
                    node = node.next;
                }
            }

            return sum;
        }

        int nodesSum() {
            int sum = 0;
            Node node = this;

            while (node != null) {
                sum = sum * 10 + node.value;
                node = node.next;
            }

            return sum;
        }

        static Node numberToNode(int number) {
            Node node = null;
            while (number != 0) {
                int numberLength = String.valueOf(number).length() - 1;
                if (node == null) {
                    node = new Node((int) (number / Math.pow(10, numberLength)));
                } else {
                    node.addNode((int) (number / Math.pow(10, numberLength)));
                }
                number = number % (int) Math.pow(10, numberLength);
            }
            return node;
        }


    }

}
