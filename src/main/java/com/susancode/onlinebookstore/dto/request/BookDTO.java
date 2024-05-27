package com.susancode.onlinebookstore.dto.request;

import com.susancode.onlinebookstore.enums.BookStatus;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * This a Data Transfer Object (DTO) class for representing book request data.
 * it contains fields for book attributes such as title, author, description, price,
 * quantity, category, and availability.
 */



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    @NotBlank(message = "title is required")
    private String title;
    @NotBlank(message = "author is required")
    private String author;
    private String description;
    @Positive(message = "Price must be a positive value")
    private double price;
    @Positive(message = "quantity must be greater than 0")
    private int quantity;
    private String category;
    private boolean available;


}

