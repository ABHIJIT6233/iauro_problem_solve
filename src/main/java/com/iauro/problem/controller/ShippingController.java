package com.iauro.problem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.iauro.problem.model.ShippingRequest;
import com.iauro.problem.service.ShippingService;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {
    @Autowired
    private ShippingService shippingService;
    @PostMapping("/minimum-containers")
    public int getMinimumContainers(@RequestBody ShippingRequest request) {
        return shippingService.calculateMinimumContainers(request.getShipments(), request.getContainerLimits());
    }
}

