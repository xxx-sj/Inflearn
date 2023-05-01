package jpaBook.jpaShop.controller.book;

import jpaBook.jpaShop.controller.book.dto.BookForm;
import jpaBook.jpaShop.controller.book.dto.BookResponseDto;
import jpaBook.jpaShop.controller.book.dto.ItemListResponseDto;
import jpaBook.jpaShop.controller.book.dto.ItemUpdateRequestDto;
import jpaBook.jpaShop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/v1/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/register")
    public void create(@RequestBody BookForm form) {

        itemService.saveItem(form.toEntity());
    }

    @GetMapping("/items")
    public List<ItemListResponseDto> list() {
        return itemService.findItems();
    }

    @GetMapping("/items/{itemId}/edit")
    public BookResponseDto updateItemForm(@PathVariable("itemId") Long itemId) {
        return itemService.findOne(itemId);
    }

    @PutMapping("/items/{itemId}/edit")
    public Long updateItem(@PathVariable("itemId") Long itemId, @RequestBody ItemUpdateRequestDto itemUpdateRequestDto) {
        return itemService.updateItem(itemId, itemUpdateRequestDto);
    }
}
