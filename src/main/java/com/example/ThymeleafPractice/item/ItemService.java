package com.example.ThymeleafPractice.item;

import com.example.ThymeleafPractice.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;
    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public Item saveItem(Item item) {

        return itemRepository.saveAndFlush(item);
    }
}
