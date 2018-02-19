package ru.vorotov.list.cycledetector;

/**
 * Cycle Detector.
 */
public class CycleDetector {

    /**
     * Detect cycle.
     * @param firstNode First node cycle.
     * @return true - Found cycle.
     */
    boolean hasCycle(Node firstNode) {
        Node tortoise = firstNode;
        Node hare = firstNode;
        if (tortoise == null || tortoise.getNext() == null) {
            return false;
        }
        while (hare != null && hare.getNext() != null) {
            tortoise = tortoise.getNext();
            hare = hare.getNext().getNext();
            if (tortoise == hare) {
                return true;
            }
        }
        return false;
    }
}
