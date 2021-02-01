package OtherSources;

public class RemoveDupsFromLLinkedList {

    /**
     *
     * You're given the head of a Singly Linked List whose nodes are in sorted order with respect to their values. Write
     * a function that returns modified version of the LinkedList that don't contain any nodes with duplicate values.
     */

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // O(n) time | O(1) space - where n is the number of nodes in the Linked List
    public LinkedList removeDuplicatesFromLinkedList (LinkedList linkedList) {
        LinkedList currentNode = linkedList;
        while (currentNode != null) {
            LinkedList nextDistinctNode = currentNode.next;
            while (nextDistinctNode != null && nextDistinctNode.value == currentNode.value) {
                nextDistinctNode = nextDistinctNode.next;
            }
            currentNode.next = nextDistinctNode;
            currentNode = nextDistinctNode;
        }
        return linkedList;
    }
}
