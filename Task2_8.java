package com.mikhailovskii.task1_5;

import java.util.HashSet;
import java.util.Set;

public class Task2_8 {

    public static void main(String[] args) {
        Node node = new Node(1);
        node = node.addNode(2);

        Node thirdNode = new Node(3);
        node.addNode(thirdNode);

        node = node.addNode(4);
        node = node.addNode(new Node(5, thirdNode));

        System.out.println(node.findLoopNode().value);

    }

    private static class Node {

        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
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
            Node node1 = this;
            while (node1.next != null) {
                node1 = node1.next;
            }
            node1.next = node;
            return this;
        }

        void showAllNodes(Node node) {
            System.out.println(node.value);
            if (node.next != null) {
                showAllNodes(node.next);
            }
        }

        Node findLoopNode() {
            Set<Node> nodesSet = new HashSet<>();
            Node node = this;

            while (true) {
                if (nodesSet.contains(node.next)) {
                    return node.next;
                }
                nodesSet.add(node);
                node = node.next;
            }
        }


    }

}
