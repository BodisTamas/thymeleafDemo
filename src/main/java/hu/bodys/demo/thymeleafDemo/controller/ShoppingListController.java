package hu.bodys.demo.thymeleafDemo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import groovy.util.logging.Slf4j;
import hu.bodys.demo.thymeleafDemo.dto.ShoppingList;
import hu.bodys.demo.thymeleafDemo.dto.ShoppingListItem;
import hu.bodys.demo.thymeleafDemo.dto.ShoppingUnit;

@Slf4j
@Controller
public class ShoppingListController {

    @ModelAttribute("shoppingLists")
    public List<ShoppingList> gShoppingLists(){
        List<ShoppingList> shoppingLists = new ArrayList<>();
        ShoppingListItem item1 = new ShoppingListItem("Bread", ShoppingUnit.KILOGRAM, 1);
        ShoppingListItem item2 = new ShoppingListItem("Milk", ShoppingUnit.LITER, 3);
        ShoppingListItem item3 = new ShoppingListItem("Candy", ShoppingUnit.BOX, 1);
        ShoppingList shoppingList = new ShoppingList("Shopping 1", LocalDate.now());
        shoppingList.addAll(item1, item2, item3);

        ShoppingListItem item4 = new ShoppingListItem("Sliced Bread", ShoppingUnit.KILOGRAM, 1);
        ShoppingListItem item5 = new ShoppingListItem("Milk", ShoppingUnit.LITER, 3);
        ShoppingListItem item6 = new ShoppingListItem("Sausage",ShoppingUnit.PIECE, 2);
        ShoppingListItem item7 = new ShoppingListItem("Water", ShoppingUnit.SHRINK, 1);
        ShoppingList shoppingList2 = new ShoppingList("Shopping 2", LocalDate.now().minusDays(2));
        shoppingList2.addAll(item4, item5, item6, item7);
        
        shoppingLists.add(shoppingList);
        shoppingLists.add(shoppingList2);
        return shoppingLists;
    }

    @GetMapping("/")
    public String homePage(){
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model){
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.add(new ShoppingListItem());
        model.addAttribute("shoppingList", shoppingList);
        return "add";
    }

    @PostMapping(value = "/add", params = {"newItem"})
    public String addNewItem(@ModelAttribute("shoppingList") ShoppingList shoppingList, Model model){
        
        shoppingList.add(new ShoppingListItem());
        
        return "add";
    }

    @PostMapping("/add")
    public String addNewShoppingList(@ModelAttribute("shoppingList") ShoppingList shoppingList, @ModelAttribute("shoppingLists") List<ShoppingList> shoppingLists){
        shoppingLists.add(shoppingList);
        return "index";
    }
}
