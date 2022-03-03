package hu.bodys.demo.thymeleafDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ShoppingListItem {
    private String name;
    private int quantity;
}
