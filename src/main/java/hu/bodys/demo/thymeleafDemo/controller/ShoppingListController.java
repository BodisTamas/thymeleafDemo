package hu.bodys.demo.thymeleafDemo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hu.bodys.demo.thymeleafDemo.dto.ShoppingList;
import hu.bodys.demo.thymeleafDemo.dto.ShoppingListItem;
import hu.bodys.demo.thymeleafDemo.dto.ShoppingUnit;

@Controller
public class ShoppingListController {

    @GetMapping("/")
    public String homePage(Model model){
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
        
        
        List<ShoppingList> shoppingLists = new ArrayList<>();
        shoppingLists.add(shoppingList);
        shoppingLists.add(shoppingList2);
        model.addAttribute("shoppingLists", shoppingLists);

        return "index";

    }

    @GetMapping("/add")
    public String add(){
        return "add";
    }
}
