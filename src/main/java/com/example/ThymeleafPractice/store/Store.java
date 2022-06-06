package com.example.ThymeleafPractice.store;

import com.example.ThymeleafPractice.item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String storeName;
    private int revenue;

    public Store(String storeName, int revenue) {
        this.storeName = storeName;
        this.revenue = revenue;
    }

    @OneToMany (mappedBy = "store")
    private Set<Item> itemSet = new TreeSet<>();


}
