package hu.bodys.demo.thymeleafDemo.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

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
    @Size(min=1, message="{validation.not.empty}")
    private String name;
    private ShoppingUnit unit;
    @NotNull(message="{validation.not.empty}")
    @Positive(message="{validation.greater.than.zero}")
    private int quantity;
}
