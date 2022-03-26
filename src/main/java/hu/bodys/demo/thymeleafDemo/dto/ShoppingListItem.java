package hu.bodys.demo.thymeleafDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingListItem {
    private Integer id;
    private String name;
    private ShoppingUnit unit;
    private int quantity;
}
