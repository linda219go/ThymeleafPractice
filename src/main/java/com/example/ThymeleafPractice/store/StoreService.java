package com.example.ThymeleafPractice.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getAllStores(){
        return storeRepository.findAll();
    }

    public Store saveStore(Store store) {
        return storeRepository.saveAndFlush(store);
    }

    public Store findStoreById(int id){return storeRepository.findById(id);}

    public List<Store> findAllStore(){return storeRepository.findAll();}

    public void deleteStoreById(int id) {
        storeRepository.deleteById(id);
    }
}
