package hu.bodys.demo.thymeleafDemo.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;


public enum ShoppingUnit {
    PIECE("shopping.unit.piece"),
    KILOGRAM("shopping.unit.kilogram"),
    LITER("shopping.unit.liter"),
    BOX("shopping.unit.box"),
    SHRINK("shopping.unit.shrink");

    ShoppingUnit(String messageKey){
        this.messageKey = messageKey;
    }

    @Getter
    private String messageKey;
}
