package com.scanbook.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name="books")
@Data
@Setter
@Getter
public class Book {
    @Id
    @Column(name="Isbn")
    private int isbn;

    @Column(name="Title")
    private String title;

    @Column(name="Author")
    private String author;

    @Column(name="Pages")
    private int pages;

    @Column(name="Completed")
    private boolean completed;

    @Column(name="Notes")
    private String notes;



}
