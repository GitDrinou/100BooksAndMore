package com.drinounet._BooksAndMore.datas;

import jakarta.persistence.*;

@Entity
@Table(name = "tkinds")
public class Kinds {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tkinds_id_gen")
    @SequenceGenerator(name = "tkinds_id_gen", sequenceName = "tkinds_kind_id_seq", allocationSize = 1)
    @Column(name = "kind_id", nullable = false)
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