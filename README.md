# Cracking the coding interview

<details>
  <summary> Task 1_5 (One Away) </summary>
  <br>
  
  ```
      One Away: There are three types of edits that can be performed on strings: insert a character,
  remove a character, or replace a character. Given two strings, write a function to check if they are
  one edit (or zero edits) away.
      EXAMPLE
      pale, ple -> true
      pales, pale -> true
      pale, bale -> true
      pale, bake -> false
  ```
  
  </details>
  
  <details>
  <summary> Task 1_6 (String Compression) </summary>
  <br>
  
  ```
String Compression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).
  ```
  
  </details>
   
  <details>
  <summary> Task 1_7 (Rotate Matrix) </summary>
  <br>
  
  ```
Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
  ```
  
  </details>
  
  <details>
  <summary> Task 1_8 (Zero Matrix) </summary>
  <br>
  
  ```
Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.
  ```
  
  </details>
  
  <details>
  <summary> Task 1_9 (String Rotation) </summary>
  <br>
  
  ```
String Rotation:Assume you have a method isSubstring which checks if one word is a substring
of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
  ```
  
  </details>
  
  <details>
  <summary> Task 2_1 (Remove dups) </summary>
  <br>
  
  ```
Remove Dup: Write code to remove duplicates from an unsorted linked list.
  ```
  
  </details>

  <details>
  <summary> Task 2_2 (Return Kth to Last) </summary>
  <br>
  
  ```
Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
  ```
  
  </details>
  
  </details>

  <details>
  <summary> Task 2_3 (Delete Middle Node) </summary>
  <br>
  
  ```
Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
that node.
EXAMPLE
lnput:the node c from the linked lista->b->c->d->e->f
Result: nothing is returned, but the new linked list looks like a->b->d->e- >f
  ```
  
  </details>

<details>
  <summary> Task 2_4 (Partition) </summary>
  <br>
  
  ```
Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
to be after the elements less than x (see below). The partition element x can appear anywhere in the
"right partition"; it does not need to appear between the left and right partitions.
EXAMPLE
Input:
Output:
3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
  ```
  
  </details>
  
  <details>
  <summary> Task 2_5 (Sum Lists) </summary>
  <br>
  
  ```
Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
Output: 2 -> 1 -> 9. That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
EXAMPLE
lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
Output: 9 - > 1 -> 2. That is, 912.
  ```
  
  </details>
  
  <details>
  <summary> Task 2_6 (Palindrome) </summary>
  <br>
  
  ```
Palindrome: Implement a function to check if a linked list is a palindrome.
  ```
  
  </details>
  
  <details>
  <summary> Task 2_7 (Intersection) </summary>
  <br>
  
  ```
Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
node. Note that the intersection is defined based on reference, not value. That is, if the kth
node of the first linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting.
```
  
  </details>
  
  <details>
  <summary> Task 2_8 (Loop Detection) </summary>
  <br>
  
  ```
Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
as to make a loop in the linked list.
EXAMPLE
Input: A -> B -> C - > D -> E -> C [the same C as earlier]
Output: C
```
  
  </details>
  
  <details>
  <summary> Task 3_2 (Stack Min) </summary>
  <br>
  
  ```
Stack Min: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time.
```
  
  </details>

  <details>
  <summary> Task 3_3 (Stack of Plates) </summary>
  <br>
  
  ```
Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack
(that is, pop () should return the same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a specific substack.
```
  
  </details>
  
  <details>
  <summary> Task 3_4 (Queue via Stacks) </summary>
  <br>
  
  ```
Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
```
  
  </details>
  
  <details>
  <summary> Task 3_5 (Sort Stack) </summary>
  <br>
  
  ```
Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
an additional temporary stack, but you may not copy the elements into any other data structure
(such as an array). The stack supports the following operations: push, pop, peek, and is Empty.
```
  
  </details>
  
  <details>
  <summary> Task 3_6 (Animal Shelter) </summary>
  <br>
  
  ```
Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
that type). They cannot select which specific animal they would like. Create the data structures to
maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
and dequeueCat. You may use the built-in Linked list data structure.
```
  
  </details>
  
  <details>
  <summary> Task 4_1 (Route Between Nodes) </summary>
  <br>
  
  ```
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes.
```
  
  </details>
  
  <details>
  <summary> Task 4_2 (Minimal Tree) </summary>
  <br>
  
  ```
Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
algorithm to create a binary search tree with minimal height.
```
  
  </details>
  
  <details>
  <summary> Task 4_3 (List of Depths) </summary>
  <br>
  
  ```
List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
```
  
  </details>
  
  <details>
  <summary> Task 4_4 (Check Balanced) </summary>
  <br>
  
  ```
Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
node never differ by more than one.
```
  
  </details>
  
  <details>
  <summary> Task 4_5 (Validate BST) </summary>
  <br>
  
  ```
Validate BST: Implement a function to check if a binary tree is a binary search tree.
```
  
  </details>
  
  <details>
  <summary> Task 4_6 (Successor) </summary>
  <br>
  
  ```
Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
binary search tree. You may assume that each node has a link to its parent.
```
  
  </details>
  
  <details>
  <summary> Task 4_7 (Build Order) </summary>
  <br>
  
  ```
Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
projects, where the second project is dependent on the first project). All of a project's dependencies
must be built before the project is. Find a build order that will allow the projects to be built. If there
is no valid build order, return an error.
EXAMPLE
Input:
projects: a, b, c, d, e, f
dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
Output: f, e, a, b, d, c
```
  
  </details>
  
  <details>
  <summary> Task 4_8 (First Common Ancestor) </summary>
  <br>
  
  ```
First Common Ancestor: Design an algorithm and write code to find the first common ancestor
of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.
```
  
  </details>
  
  <details>
  <summary> Task 4_9 (BST Sequences) </summary>
  <br>
  
  ```
BST Sequences: A binary search tree was created by traversing through an array from left to right
and inserting each element. Given a binary search tree with distinct elements, print all possible
arrays that could have led to this tree.
EXAMPLE

      2
    1   3
Input:
Output: {2, 1, 3}, {2, 3, 1}
```
  
  </details>
  
  <details>
  <summary> Task 4_11 (Random Node) </summary>
  <br>
  
  ```
Random Node: You are implementing a binary search tree class from scratch, which, in addition
to insert, find, and delete, has a method getRandomNode() which returns a random node
from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
for getRandomNode, and explain how you would implement the rest of the methods.
```
  
  </details>

  <details>
  <summary> Task 4_12 (Paths with Sum) </summary>
  <br>
  
  ```
Paths with Sum: You are given a binary tree in which each node contains an integer value (which
might be positive or negative). Design an algorithm to count the number of paths that sum to a
given value. The path does not need to start or end at the root or a leaf, but it must go downwards
(traveling only from parent nodes to child nodes).
```
  
  </details>
  
  <details>
  <summary> Task 5_1 (Insertion) </summary>
  <br>
  
  ```
Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and
j. Write a method to insert M into N such that M starts at bit j and ends at bit i. You
can assume that the bits j through i have enough space to fit all of M. That is, if
M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for
example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
EXAMPLE
Input: N 10000000000, M
Output: N = 10001001100
```
  
  </details>
  
  <details>
  <summary> Task 5_2 (Binary to String) </summary>
  <br>
  
  ```
Binary to String: Given a real number between O and 1 (e.g., 0.72) that is passed in as a double, print
the binary representation. If the number cannot be represented accurately in binary with at most 32
characters, print "ERROR."
```
  
  </details>
  
  <details>
  <summary> Task 5_3 (Flip Bit to Win) </summary>
  <br>
  
  ```
Flip Bit to Win: You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to
find the length of the longest sequence of ls you could create.
EXAMPLE
Input: 1775
Output: 8
```
  
  </details>
  
  <details>
  <summary> Task 5_4 (Next Number) </summary>
  <br>
  
  ```
Next Number: Given a positive integer, print the next smallest and the next largest number that
have the same number of 1 bits in their binary representation.
```
  
  </details>
  
  <details>
  <summary> Task 5_6 (Conversion) </summary>
  <br>
  
  ```
Conversion: Write a function to determine the number of bits you would need to flip to convert
integer A to integer B.
EXAMPLE
Input: 29 (or: 11101), 15 (or: 01111)
Output: 2
```
  
  </details>
  
  <details>
  <summary> Task 5_7 (Pairwise Swap) </summary>
  <br>
  
  ```
Pairwise Swap: Write a program to swap odd and even bits in an integer with as few instructions as
possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
```
  
  </details>
  
  <details>
  <summary> Task 7_1 (Deck of Cards) </summary>
  <br>
  
  ```
Deck of Cards: Design the data structures for a generic deck of cards. Explain how you would
subclass the data structures to implement blackjack.
```
  
  </details>
  
  <details>
  <summary> Task 7_1 (Deck of Cards) </summary>
  <br>
  
  ```
Deck of Cards: Design the data structures for a generic deck of cards. Explain how you would
subclass the data structures to implement blackjack.
```
  
  </details>
  
  <details>
  <summary> Task 8_1 (Triple Step) </summary>
  <br>
  
  ```
Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
steps at a time. Implement a method to count how many possible ways the child can run up the
stairs.
```
  
  </details>
  
  <details>
  <summary> Task 8_2 (Robot in a Grid) </summary>
  <br>
  
  ```
Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
The robot can only move in two directions, right and down, but certain cells are "off limits" such that
the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
the bottom right.
```
  
  </details>

  <details>
  <summary> Task 8_3 (Magic Index) </summary>
  <br>
  
  ```
Magic Index: A magic index in an array A[ 1 .•. n-1] is defined to be an index such that A[ i]
i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
array A.
```
  
  </details>
  
  <details>
  <summary> Task 8_4 (Power Set) </summary>
  <br>
  
  ```
Power Set: Write a method to return all subsets of a set.
```
  
  </details>
  
  <details>
  <summary> Task 8_5 (Recursive Multiply) </summary>
  <br>
  
  ```
Recursive Multiply: Write a recursive function to multiply two positive integers without using
the * operator (or / operator). You can use addition, subtraction, and bit shifting, but you should
minimize the number of those operations.
```
  
  </details>

  <details>
  <summary> Task 8_6 (Towers of Hanoi) </summary>
  <br>
  
  ```
Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order
of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following
constraints:
(1) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto another tower.
(3) A disk cannot be placed on top of a smaller disk.
Write a program to move the disks from the first tower to the last using Stacks.
```
  
  </details>
  
  <details>
  <summary> Task 8_7 (Permutations without Dups) </summary>
  <br>
  
  ```
Permutations without Dups: Write a method to compute all permutations of a string of unique
characters.
```
  
  </details>
  
  <details>
  <summary> Task 8_8 (Permutations with Dups) </summary>
  <br>
  
  ```
Permutations with Dups: Write a method to compute all permutations of a string whose characters
are not necessarily unique. The list of permutations should not have duplicates.
```
  
  </details>
