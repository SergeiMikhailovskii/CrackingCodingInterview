package com.mikhailovskii.task1_5;

public class Task2_7 {

    public static void main(String[] args) {
        Node equalNode = new Node(1);
        equalNode = equalNode.addNode(2);
        equalNode = equalNode.addNode(3);
        equalNode = equalNode.addNode(4);

        Node firstNode = new Node(5);
        firstNode = firstNode.addNode(6);
        firstNode = firstNode.addNode(7);
        firstNode = firstNode.addNode(8);
        firstNode = firstNode.addNode(equalNode);

        Node secondNode = new Node(9);
        secondNode = secondNode.addNode(10);
        secondNode = secondNode.addNode(11);
        secondNode = secondNode.addNode(12);
        secondNode = secondNode.addNode(13);
        secondNode.addNode(equalNode);

        Node node = Node.findEqualNode(firstNode, secondNode);
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

        Node addNode(Node node) {
            this.next = node;
            return this;
        }

        void showAllNodes(Node node) {
            System.out.println(node.value);
            if (node.next != null) {
                showAllNodes(node.next);
            }
        }

        static Node findEqualNode(Node firstNode, Node secondNode) {
            while (firstNode != null) {
                Node secondNodeLoop = secondNode;
                while (secondNodeLoop != null) {
                    if (firstNode == secondNodeLoop) {
                        return firstNode;
                    }
                    secondNodeLoop = secondNodeLoop.next;
                }
                firstNode = firstNode.next;
            }
            return null;
        }


    }

}
