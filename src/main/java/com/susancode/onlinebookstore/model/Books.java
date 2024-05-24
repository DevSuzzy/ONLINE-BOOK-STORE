package com.susancode.onlinebookstore.model;

import com.susancode.onlinebookstore.enums.BookStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Books extends AbstractAuditingEntity<Books> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid;
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Author is required")
    private String author;
    private String description;
    private double price;
    private int quantity;
    private String category;
    private boolean available = true;
    @Enumerated(EnumType.STRING)
    private BookStatus status = BookStatus.AVAILABLE;


}
