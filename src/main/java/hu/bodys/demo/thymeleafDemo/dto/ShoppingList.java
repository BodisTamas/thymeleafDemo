package hu.bodys.demo.thymeleafDemo.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingList {
    private Integer id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private List<ShoppingListItem> items;

    public ShoppingList(){
        items = new ArrayList<>();
    }

    public ShoppingList(int id, String name, LocalDate date){
        this.id = id;
        this.name = name;
        this.date = date;
        items = new ArrayList<>();
    }

    public void addAll(ShoppingListItem... items){
        this.items.addAll(Arrays.asList(items));
    }

    public void add(ShoppingListItem item){
        this.items.add(item);
    }
}
