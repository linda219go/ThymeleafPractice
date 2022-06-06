package com.example.ThymeleafPractice.drone;

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
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String droneNumber;
    private int capacity;
    private int remainCapacity;
    private int numOfOrders;
    private int tripsLeft;

    @ManyToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

    public Drone(String droneNumber, int capacity, int tripsLeft) {
        this.droneNumber = droneNumber;
        this.capacity = capacity;
        this.remainCapacity = capacity;
        this.tripsLeft = tripsLeft;
    }

    public void increaseCap(int change){
        this.remainCapacity += change;
    }
    public void decreaseCap(int change){
        this.remainCapacity -= change;
    }
    public void removeOrder(){
        this.numOfOrders --;
    }
    public void addOrder(){
        this.numOfOrders ++;
    }
    public void updateTripsLeft(){
        this.tripsLeft --;
    }
}
