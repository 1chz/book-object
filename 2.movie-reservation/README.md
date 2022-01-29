# 영화 예매 프로그램

---

- Customer
  - 고객을 표현한다
  - 본 코드에서는 딱히 역할이 없다


- Money
  - 한국 원화를 표현한다
  - int, long, double 과 같은 자료타입들은 의도를 명확하게 나타내기 어렵다


- Movie
  - 영화를 표현한다
  - 영화는 영화 제목, 상영 시간, 예매 금액, 할인정책을 포함한다


- Screening
  - 영화 상영을 표현한다
  - 영화는 여러번 상영될 수 있기 때문에 영화와 상영은 1:N 관계를 갖는다
  - 영화의 정보, 상영 순서, 상영 시기를 포함한다


- DiscountPolicy
  - 할인 정책을 표현한다
  - 할인 정책에는 고정금액 할인, 퍼센테이지 할인이 존재한다


- DiscountCondition <<interface>>
  - 할인 조건을 표현한다
  - 할인 조건에는 상영 순번이 일치하거나, 할인 기간에 포함되는 경우가 존재한다


- Reservation
  - 완료된 예매 정보를 표현한다
  - 영화를 보려는 고객의 수, 총 금액(영화 예매금 * 고객수), 영화의 상영 시기를 포함한다

<br />

# Build

---

```shell
chmod +x gradlew
./gradlew clean build
```

<br />

# Test Coverage

---

빌드 후 `2.movie-reservation/src/main/resources/static/jacoco/index.html` 확인
