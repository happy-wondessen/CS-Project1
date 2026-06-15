package com.example.demo.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock_addition")
public class StockAddition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company; // The supplier providing the parts

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store; // The specific garage branch receiving the delivery

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item; // The specific part being delivered

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double basePrice; // The wholesale cost paid to the supplier per unit

    private LocalDateTime dateAdded;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }
    public Store getStore() { return store; }
    public void setStore(Store store) { this.store = store; }
    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Double getBasePrice() { return basePrice; }
    public void setBasePrice(Double basePrice) { this.basePrice = basePrice; }
    public LocalDateTime getDateAdded() { return dateAdded; }
    public void setDateAdded(LocalDateTime dateAdded) { this.dateAdded = dateAdded; }
}