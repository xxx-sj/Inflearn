package jpaBook.jpaShop.controller.book.dto;

import jpaBook.jpaShop.domain.item.Book;
import lombok.Getter;

@Getter
public class BookResponseDto {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.price = book.getPrice();
        this.stockQuantity = book.getStockQuantity();
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
    }
}
