package com.example.ThymeleafPractice.item;

import com.example.ThymeleafPractice.store.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // note: for item, somehow the @GeneratedValue must define strategy to make it work to add values to items repo

    private String itemName;

    private int unitWeight;

    @ManyToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;
}