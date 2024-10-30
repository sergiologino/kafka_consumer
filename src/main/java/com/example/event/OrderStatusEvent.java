package com.example.event;

import java.io.Serializable;
import java.time.Instant;

public class OrderStatusEvent implements Serializable {
    private String status;
    private Instant date;

    // Constructors, Getters and Setters
    public OrderStatusEvent() {}

    public OrderStatusEvent(String status, Instant date) {
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
