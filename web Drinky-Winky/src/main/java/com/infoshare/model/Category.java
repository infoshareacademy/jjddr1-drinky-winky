package com.infoshare.model;

import javax.persistence.*;

@Entity
@Table
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", unique = true, length = 100)
    private String categoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
