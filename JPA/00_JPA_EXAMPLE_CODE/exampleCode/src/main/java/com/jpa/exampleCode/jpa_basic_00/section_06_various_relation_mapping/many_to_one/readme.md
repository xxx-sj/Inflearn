# 다대일 
### N : 1
 
다대일 관계에서 @ManyToOne을 갖고있는 다쪽에서 
@JoinColumn을 사용하는데, 만약 @JoinColumn을 사용하지 않으면 
@ManyToOne을 사용한 프로퍼티의 이름 + _id가 FK로 들어가게 된다.

```java
public class Section06Member01 {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "TEAM_ID")
    private Section06Team01 section06Team01;
}
//==> | MEMBER_ID | USERNAME | section06Team01_ID |
```

연관관계주인의 반대편에서 [  mappedBy를 사용하는 쪽 ]는 프로퍼티 명으로 
mappedBy를 연결한다.
```java
@Entity
@Getter
@Setter
public class Section06Team01 {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "[OneToMany의 property명이 들어간다.(section06Team01)]", fetch = FetchType.LAZY)
    private List<Section06Member01> members = new ArrayList<>();
}
```