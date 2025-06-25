package com.iauro.problem.service;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class ShippingService {
    public int calculateMinimumContainers(List<Integer> shipments, List<Integer> containerLimits) {
        int totalUnits = shipments.stream().mapToInt(Integer::intValue).sum();
        Collections.sort(containerLimits, Collections.reverseOrder());
        int containerCount = 0;
        int usedCapacity = 0;

        for (int limit : containerLimits) {
            usedCapacity += limit;
            containerCount++;
            if (usedCapacity >= totalUnits) {
                return containerCount;
            }
        }

        return -1; 
    }
}

