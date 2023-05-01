package jpaBook.jpaShop.service;

import jpaBook.jpaShop.controller.book.dto.BookResponseDto;
import jpaBook.jpaShop.controller.book.dto.ItemListResponseDto;
import jpaBook.jpaShop.controller.book.dto.ItemUpdateRequestDto;
import jpaBook.jpaShop.domain.item.Book;
import jpaBook.jpaShop.domain.item.Item;
import jpaBook.jpaShop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public List<ItemListResponseDto> findItems() {
        return itemRepository.findAll().stream()
                .map(item -> new ItemListResponseDto(item))
                .collect(Collectors.toList());
    }

    public BookResponseDto findOne(Long itemId) {
        Book one = (Book) itemRepository.findOne(itemId);
        return new BookResponseDto(one);
    }

    @Transactional
    public Long updateItem(Long id, ItemUpdateRequestDto requestDto) {
        Book book = (Book) itemRepository.findOne(id);
        /**
         * id를 임의로 넘겨서 다른 데이터를 변경할 수 있다. 
         * 보안상 이 것에 대해 유저가 이 아이템에 대해 권한이 있는지 체크할 것
         */

        book.update(requestDto.getName(), requestDto.getPrice(), requestDto.getStockQuantity(), requestDto.getAuthor(), requestDto.getIsbn());

        return id;
    }
}
