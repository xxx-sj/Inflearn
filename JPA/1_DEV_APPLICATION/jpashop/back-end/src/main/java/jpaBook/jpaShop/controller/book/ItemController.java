package jpaBook.jpaShop.controller.book;

import jpaBook.jpaShop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/v1/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/register")
    public void create(@RequestBody BookForm form) {

        itemService.saveItem(form.toEntity());
    }
}
