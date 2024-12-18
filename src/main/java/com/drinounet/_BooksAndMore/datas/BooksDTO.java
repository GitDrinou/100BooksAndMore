package com.drinounet._BooksAndMore.datas;

import jakarta.persistence.*;

@Entity
@Table(name = "tbooks")
public class BooksDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbooks_id_gen")
    @SequenceGenerator(name = "tbooks_id_gen", sequenceName = "tbooks_book_id_seq", allocationSize = 1)
    @Column(name = "book_id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 200)
    private String title;

    @Column(name = "author", length = 75)
    private String author;

    @Column(name = "publication_date", length = 10)
    private String publicationDate;

    @Column(name = "isbn", length = 20)
    private String isbn;

    @Column(name = "description", nullable = false, length = Integer.MAX_VALUE)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}