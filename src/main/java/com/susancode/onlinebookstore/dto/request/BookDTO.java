package com.susancode.onlinebookstore.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
