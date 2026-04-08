package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String category;

    private String trainerName;
    private String trainerRole;
    private String trainerAvatar;

    private String description;
    private String date;
    private String time;

    private int seatsAvailable;
    private int seatsTotal;

    private double rating;
    private String status;

    private String duration;
    private String level;
    private String price;
    private String mode;

    private int registered;

    private String imageUrl;

    public Workshop() {
    }

    public Workshop(Long id, String title, String category, String trainerName, String trainerRole,
                    String trainerAvatar, String description, String date, String time,
                    int seatsAvailable, int seatsTotal, double rating, String status,
                    String duration, String level, String price, String mode,
                    int registered, String imageUrl) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.trainerName = trainerName;
        this.trainerRole = trainerRole;
        this.trainerAvatar = trainerAvatar;
        this.description = description;
        this.date = date;
        this.time = time;
        this.seatsAvailable = seatsAvailable;
        this.seatsTotal = seatsTotal;
        this.rating = rating;
        this.status = status;
        this.duration = duration;
        this.level = level;
        this.price = price;
        this.mode = mode;
        this.registered = registered;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerRole() {
        return trainerRole;
    }

    public void setTrainerRole(String trainerRole) {
        this.trainerRole = trainerRole;
    }

    public String getTrainerAvatar() {
        return trainerAvatar;
    }

    public void setTrainerAvatar(String trainerAvatar) {
        this.trainerAvatar = trainerAvatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public int getSeatsTotal() {
        return seatsTotal;
    }

    public void setSeatsTotal(int seatsTotal) {
        this.seatsTotal = seatsTotal;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getRegistered() {
        return registered;
    }

    public void setRegistered(int registered) {
        this.registered = registered;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}