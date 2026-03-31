package com.consultancy;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;
    private String clientRole;

    @Column(columnDefinition = "TEXT")
    private String clientMessage;

    // Kotha review ki default ga PENDING status untundi
    private String status = "PENDING";

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getClientRole() { return clientRole; }
    public void setClientRole(String clientRole) { this.clientRole = clientRole; }

    public String getClientMessage() { return clientMessage; }
    public void setClientMessage(String clientMessage) { this.clientMessage = clientMessage; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}