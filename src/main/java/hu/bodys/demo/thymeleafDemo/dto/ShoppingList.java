package hu.bodys.demo.thymeleafDemo.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingList {
    private String name;
    private LocalDate date;
    private List<ShoppingListItem> items;

    public ShoppingList(String name, LocalDate date){
        this.name = name;
        this.date = date;
        items = new ArrayList<>();
    }

    public void addAll(ShoppingListItem... items){
        this.items.addAll(Arrays.asList(items));
    }
}
