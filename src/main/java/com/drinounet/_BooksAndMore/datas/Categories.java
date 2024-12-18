package com.drinounet._BooksAndMore.datas;

import jakarta.persistence.*;

@Entity
@Table(name = "tcategories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tcategories_id_gen")
    @SequenceGenerator(name = "tcategories_id_gen", sequenceName = "tcategories_category_id_seq", allocationSize = 1)
    @Column(name = "category_id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}