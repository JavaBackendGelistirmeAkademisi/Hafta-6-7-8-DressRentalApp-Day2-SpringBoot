package com.example.dressrentalapp.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Elbise için DTO sınıfı, id içermiyor
public class DressRequestDTO {

    @NotNull(message = "Dress name cannot be null")
    @Size(min = 2, max = 50, message = "Dress name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Size cannot be null")
    private String size;

    @NotNull(message = "Price cannot be null")
    private double price;

    // Getter ve Setter metodları
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
