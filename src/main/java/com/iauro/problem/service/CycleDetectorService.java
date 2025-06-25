package com.iauro.problem.service;
import org.springframework.stereotype.Service;
import com.iauro.problem.model.Node;
@Service
public class CycleDetectorService {
    public boolean hasCycle(Node head) {
        if (head == null || head.next == null) return false;
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
