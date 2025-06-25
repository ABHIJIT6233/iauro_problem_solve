package com.iauro.problem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iauro.problem.model.Node;
import com.iauro.problem.service.CycleDetectorService;

@RestController
@RequestMapping("/api/track")
public class CycleDetectorController {

    @Autowired
    private CycleDetectorService detectorService;

    @GetMapping("/detect")
    public boolean detectCycle(@RequestParam(defaultValue = "true") boolean withCycle) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        if (withCycle) {
            head.next.next.next.next.next = head.next.next;
        }

        return detectorService.hasCycle(head);
    }
}
