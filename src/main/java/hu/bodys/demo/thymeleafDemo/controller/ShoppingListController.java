package hu.bodys.demo.thymeleafDemo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hu.bodys.demo.thymeleafDemo.dto.ShoppingList;
import hu.bodys.demo.thymeleafDemo.dto.ShoppingListItem;

@Controller
public class ShoppingListController {

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("name", "Tamás");

        ShoppingListItem item1 = new ShoppingListItem("Bread", 1);
        ShoppingListItem item2 = new ShoppingListItem("Milk", 3);
        ShoppingListItem item3 = new ShoppingListItem("Candy", 1);
        
        ShoppingList shoppingList = new ShoppingList("Shopping 1", LocalDate.now());
        shoppingList.addAll(item1, item2, item3);
        model.addAttribute("shoppingList", shoppingList);

        return "index";

    }
}
