package hu.bodys.demo.thymeleafDemo.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import hu.bodys.demo.thymeleafDemo.dto.ShoppingList;
import hu.bodys.demo.thymeleafDemo.dto.ShoppingListItem;
import hu.bodys.demo.thymeleafDemo.dto.ShoppingUnit;

@Configuration
public class ThymeleafDemoConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Bean(name = "messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public List<ShoppingList> shoppingList() {
        List<ShoppingList> shoppingLists = new ArrayList<>();
        ShoppingListItem item1 = new ShoppingListItem(1, "Bread", ShoppingUnit.KILOGRAM, 1);
        ShoppingListItem item2 = new ShoppingListItem(2, "Milk", ShoppingUnit.LITER, 3);
        ShoppingListItem item3 = new ShoppingListItem(3, "Candy", ShoppingUnit.BOX, 1);
        ShoppingList shoppingList = new ShoppingList(1, "Shopping 1", LocalDate.now());
        shoppingList.addAll(item1, item2, item3);

        ShoppingListItem item4 = new ShoppingListItem(1, "Sliced Bread", ShoppingUnit.KILOGRAM, 1);
        ShoppingListItem item5 = new ShoppingListItem(2, "Milk", ShoppingUnit.LITER, 3);
        ShoppingListItem item6 = new ShoppingListItem(3, "Sausage", ShoppingUnit.PIECE, 2);
        ShoppingListItem item7 = new ShoppingListItem(4, "Water", ShoppingUnit.SHRINK, 1);
        ShoppingList shoppingList2 = new ShoppingList(2, "Shopping 2", LocalDate.now().minusDays(2));
        shoppingList2.addAll(item4, item5, item6, item7);

        shoppingLists.add(shoppingList);
        shoppingLists.add(shoppingList2);
        return shoppingLists;
    }
}
