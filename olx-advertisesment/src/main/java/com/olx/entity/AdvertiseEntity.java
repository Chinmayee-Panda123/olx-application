package com.olx.entity;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "ADVERTISES")
public class AdvertiseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(name = "category", nullable = false)
    private int category;   //categoryId

    @Column(name = "status", nullable = false)
    private int status; //statusId

    @Column(nullable = false)
    private double price;

    @Column(nullable = false, length = 100)
    private String description;

    @Lob
    private byte[] photo;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private LocalDate createdDate;

    @Column(name = "modified_date")
    @Temporal(TemporalType.DATE)
    private LocalDate modifiedDate;

    @Column(name = "active", length = 1)
    private String active;

    @Column(name = "posted_by", length = 45)
    private String postedBy;

    @Column(name = "username", length = 255)
    private String username;

    public AdvertiseEntity() {}

    public AdvertiseEntity(int id, String title, int category, int status, double price, String description, byte[] photo, LocalDate createdDate, LocalDate modifiedDate, String active, String postedBy, String username) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.status = status;
        this.price = price;
        this.description = description;
        this.photo = photo;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.active = active;
        this.postedBy = postedBy;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
