# 조인

- [내부조인]: select m from Member m join m.team t 
- [외부조인]: select m from Member m LEFT join m.team t
- [세타 조인]: select count(m) from Member m, Team t where m.username = t.name


### 조인 ON절
- ON절을 활용한 조인(JPA2.1부터)
1. 조인 대상 필터링
2. 연관관계 없는 엔티티 외부조인(하이버네이트 5.1부터)

#### 조인대상 필터링
ex) 회원과 팀을 조인하면서, 팀 이름이 A인 팀만 조인
team의 데이터를 줄이고 join하는 것.
- SELECT m, t from Member m LEFT JOIN m.team t on t.name = 'A'
- select m.*, t.* from Member m left join team t On m.team_id = t.id and t.name = 'A'

#### 연관관계 없는 엔티티 외부 조인
ex) 회원의 이름과 팀의 이름이 같은 대상 외부조인
    - JOIN 에서 m과 관계가 없기 때문에 m.team이 아닌 Team으로 선언한다.
- SELECT m, t from Member m LEFT JOIN Team t on m.username = t.name
- select m, t from Member m left join team t on m.username = t.name