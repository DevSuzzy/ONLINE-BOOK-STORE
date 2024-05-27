package com.susancode.onlinebookstore.model;

import com.susancode.onlinebookstore.enums.BookStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * This is an Entity class representing a book in the database.
 * it Contains fields for book attributes such as ID, UUID, title, author,
 * description, price, quantity, category, availability, and status.
 * it is annotated with JPA annotations for entity mapping.
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book extends AbstractAuditingEntity<Book> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid;
    private String title;
    private String author;
    private String description;
    private double price;
    private int quantity;
    private String category;
    private boolean available = true;
    private BookStatus status = BookStatus.AVAILABLE;


}
