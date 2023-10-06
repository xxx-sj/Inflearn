# 컬렉션 조회 최적화


### 한계돌파
1. ToOne(OneToOne, ManyToOne) 관계를 모두 페치조인 한다. 
    many to one 관계같은 경우 many가 from절의 메인이기 때문에, 
    증가하지 않는다.
    order와 member가 toOne 관계라면 join하고 member와 또 toOne관계있는    
   테이블을 조인한다.
2. 컬렉션은 지연로딩으로 조회한다.
3. 지연 로딩 성능 최적화를 위해 "hibernate.default_batch_fetch_size"[global], @BatchSize[local] 를 적용한다.
   - 이 옵션을 사용하면 컬렉션이나, 프록시 객체를 한꺼번에 설장한 size만큼 in 쿼리로 조회한다.
   - fetch join을 할 때 ToMany관계에서는 해당 property위에 선언하지만 
   - ToOne관계는 class위에 선언한다.
   - batch_size는 100 ~ 1000개가 적당하다 [max = 1000]