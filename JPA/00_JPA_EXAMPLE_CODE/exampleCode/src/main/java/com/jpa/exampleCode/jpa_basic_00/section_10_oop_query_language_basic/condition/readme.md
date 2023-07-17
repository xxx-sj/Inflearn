# 조건식 (CASE..)

### 기본 케이스 식
select
    case when m.age <= 10 then '1'
         when m.age >= 60 then '2'
         else '3'
    end
from Member m

### 단순 케이스 식
select
    case t.name
        when 'teamA' then '1'
        when 'teamB' then '2'
        else '3'
    end
from Team t
    
##### 출처: https://www.inflearn.com/course/lecture?courseSlug=ORM-JPA-Basic&unitId=21725&category=questionDetail&tab=curriculum