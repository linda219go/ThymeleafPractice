package com.example.ThymeleafPractice.item;

import com.example.ThymeleafPractice.store.Store;
import com.example.ThymeleafPractice.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    ItemService itemService;
    @Autowired
    StoreService storeService;
    @GetMapping("/items")
    public String displayItem(Model model){
        model.addAttribute("itemList",
                itemService.getAllItems());
        return "/item/item";
    }

    @GetMapping("/showNewItemForm")
    public String showNewItemForm(Model model) {
        // create model attribute to bind form data
        Item item = new Item();
        List<Store> storeLst = storeService.findAllStore();
        model.addAttribute("item", item);
        model.addAttribute("storeLst", storeLst);
        return "/item/new_item";
    }
    @PostMapping("/saveItem")
    public String saveItem(@ModelAttribute("item") Item item){
        itemService.saveItem(item);
        return "redirect:/items";
    }
}
