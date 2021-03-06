package hu.bodys.demo.thymeleafDemo.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingList {
    private Integer selectedItemId;
    private Integer id;
    @Size(min=1, message="{validation.not.empty}")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="{validation.not.empty}")
    private LocalDate date;
    @Valid
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
