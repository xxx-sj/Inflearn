# 셀프조인

셀프조인은 하나의 엔티티에 부모와 자식이 있는 구조로 쉽게 생각하여
부모 엔티티와 자식 엔티티를 합친것과 같다.

부모 테이블과 자식 테이블에 각각의 공통 컬럼을 추가하고,
자식 엔티티와 부모 엔티티를 합치는 것이다.

```java
@Entity
@Getter
@Setter
public class Section06Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Section06Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Section06Category> children = new ArrayList<>();
}
```
Category 라는 엔티티에서 부모 엔티티에서 필요한 연관관계 및
공통 컬럼을 작성 후 임시의 부모 엔티티의 양방향 연관관계를 추가하기 위한
OneToMany를 작성한다. 
따라서 한 엔티티안에 대상 테이블의 연관관계인 ManyToOne과 주 테이블의 연관관계인 
OneToMany가 같이 들어가게 된다.
