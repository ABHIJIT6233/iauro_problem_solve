package com.iauro.problem.model;
import java.util.List;
public class ShippingRequest {
    private List<Integer> shipments;
    private List<Integer> containerLimits;

    public List<Integer> getShipments() {
        return shipments;
    }

    public void setShipments(List<Integer> shipments) {
        this.shipments = shipments;
    }

    public List<Integer> getContainerLimits() {
        return containerLimits;
    }

    public void setContainerLimits(List<Integer> containerLimits) {
        this.containerLimits = containerLimits;
    }
}
