package jpaBook.jpaShop.domain;

import jpaBook.jpaShop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany
    //중간 테이블
    @JoinTable(name = "category_item",
        //중간 테이블 카테고리 아이디
        joinColumns = @JoinColumn(name = "category_id"),
        //category_item 테이블에 item쪽으로 들어가는 fk
        inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    //테이블 카테고리 설계로
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    //자식을 넣으면 부모도 들어가야 한다. 양방향 연관관계
    //현재 메소드는 parent 기준으로 작성되었다.
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }


}
