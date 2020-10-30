package com.infoshare.model;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;



@NamedQueries({
        @NamedQuery(
                name = "Category.findCategoryByName",
                query = "SELECT c FROM Category c WHERE c.name like :name"),

        @NamedQuery(
                name = "Category.findCategoryById",
                query = "SELECT c FROM Category c WHERE c.id in :ids"),
        @NamedQuery(
                name = "Category.getCategoryList",
                query = "SELECT c FROM Category c")
})


@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true,length = 50)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Drink> drinkList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }
}
