package com.susancode.onlinebookstore.model;

import com.susancode.onlinebookstore.enums.BookStatus;
import jakarta.persistence.*;
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
