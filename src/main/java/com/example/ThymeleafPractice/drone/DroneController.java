package com.example.ThymeleafPractice.drone;

import com.example.ThymeleafPractice.item.Item;
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
public class DroneController {
    @Autowired
    DroneService droneService;
    @Autowired
    StoreService storeService;

    @GetMapping("/drones")
    public String displayDrone(Model model){
        model.addAttribute("droneList",
                droneService.getAllDrones());
        return "/drone/drone";
    }
    @GetMapping("/showNewDroneForm")
    public String showNewDroneForm(Model model){
        Drone drone = new Drone();
        List<Store> storeLst = storeService.findAllStore();
        model.addAttribute("drone",drone);
        model.addAttribute("storeLst",storeLst);
        return "/drone/new_drone";
    }

    @PostMapping("/saveDrone")
    public String saveDrone(@ModelAttribute("drone") Drone drone){
        droneService.saveDrone(drone);
        return "redirect:/drones";
    }
}
