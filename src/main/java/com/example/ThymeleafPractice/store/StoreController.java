package com.example.ThymeleafPractice.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StoreController {
    @Autowired
    private StoreService storeService;
    @GetMapping("/")
    public String displayStore(Model model){
        model.addAttribute("storelist",
                storeService.getAllStores());
        return "/store/index";
    }

    @GetMapping("/showNewStoreForm")
    public String showNewStoreForm(Model model) {
        // create model attribute to bind form data
        Store store = new Store();
        model.addAttribute("store", store);
        return "/store/new_store";
    }

    @PostMapping("/saveStore")
    public String saveStore(@ModelAttribute("store") Store store){
        storeService.saveStore(store);
        return "redirect:/";
    }

    @GetMapping("/showStoreUpdateForm/{id}")
    public String showStoreUpdateForm(@PathVariable( value = "id") int id, Model model) {

        // get store from the service
        Store store = storeService.findStoreById(id);

        // set store as a model attribute to pre-populate the form
        model.addAttribute("store", store);
        return "/store/update_store";
    }

//    @GetMapping("/deleteStore/{id}")
//    public String deleteStore(@PathVariable (value = "id") int id) {
//
//        // call delete employee method
//        this.storeService.deleteStoreById(id);
//        return "redirect:/";
//    }

}
