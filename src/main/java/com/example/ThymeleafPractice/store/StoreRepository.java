package com.example.ThymeleafPractice.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
    @Query("select s from Store s where s.storeName = ?1")
    Store findStoreByStoreName(String storeName);

    @Query("select s from Store s where s.id = ?1")
    Store findById(int id);

    @Query("select s from Store s where s.storeName = ?1")
    Store findByStoreName(String storeName);
}
