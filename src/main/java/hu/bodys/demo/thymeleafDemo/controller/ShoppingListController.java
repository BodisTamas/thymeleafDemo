package hu.bodys.demo.thymeleafDemo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hu.bodys.demo.thymeleafDemo.dto.ShoppingList;
import hu.bodys.demo.thymeleafDemo.dto.ShoppingListItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ShoppingListController {

    private final List<ShoppingList> shoppingLists;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("shoppingLists", shoppingLists);
        return "index";
    }

    @GetMapping("/details")
    public String add(Model model){
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.add(new ShoppingListItem());
        model.addAttribute("shoppingList", shoppingList);
        return "details";
    }

    @GetMapping("/details{id}")
    public String details(@PathVariable Integer id, Model model){
        Optional<ShoppingList> actualList = shoppingLists.stream().filter(s -> s.getId().intValue() == id.intValue()).findFirst();
        actualList.ifPresent(s -> model.addAttribute("shoppingList", s));
        return "details";
    }

    @PostMapping(value = "/details", params = {"newItem"})
    public String addNewItem(@ModelAttribute("shoppingList") ShoppingList shoppingList, Model model){
        ShoppingListItem shoppingListItem = new ShoppingListItem();
        shoppingListItem.setId(shoppingList.getItems().size() + 1);
        shoppingList.add(shoppingListItem);
        
        return "details";
    }

    @PostMapping("/details")
    public String addNewShoppingList(@Valid @ModelAttribute("shoppingList") ShoppingList shoppingList, BindingResult bindingResult){
        log.info("has error: " + bindingResult.hasErrors());
        if(bindingResult.hasErrors()){
            return "details";
        }
        if(shoppingList.getId() != null){
            shoppingLists.set(shoppingList.getId()-1, shoppingList);
        } else {
            shoppingList.setId(shoppingLists.size() + 1);
            shoppingLists.add(shoppingList);
        }
        
        return "redirect:/";
    }

    @PostMapping(value="/details", params = {"deleteItem"})
    public String deleteItem(@ModelAttribute("shoppingList") ShoppingList shoppingList){
        log.info(shoppingList.getSelectedItemId().toString());
        Integer id = shoppingList.getSelectedItemId();
        if(id != null){
            shoppingList.getItems().removeIf(item -> item.getId().intValue() == id.intValue());
        }
        
        return "details";
    }

    @GetMapping("/remove{id}")
    public String removeShoppingList(@PathVariable Integer id){
        shoppingLists.removeIf(s -> s.getId().intValue() == id.intValue());
        return "redirect:/";
    }
}
