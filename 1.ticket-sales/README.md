# 티켓 예매 프로그램

---

- Audience
    - 관객
    - 관객은 가방을 소지하고있다


- Bag
  - 관객의 가방
  - 관객의 가방에는 소지금, 초대장, 티켓이 들어있을 수 있다


- Invitation
  - 관객이 소지하고 있을지도 모르는 초대장
  - 초대장을 소지했다면 티켓을 무료로 받는다
  - 초대장이 없다면 티켓을 구매해야 한다


- Ticket
  - 관객이 극장에 입장하기 위해 필요한 티켓
  - 티켓은 자신의 가격을 멤버로 갖는다


- TicketOffice
  - 티켓을 발급하는 매표소


- TicketSeller
  - 티켓 판매원은 매표소에서 티켓을 발급받아 판매한다
  - 판매한 대금은 매표소에 전달해야 한다


- Theater
  - 극장
  - 관객이 극장에 입장하기 위해서는 티켓을 소지해야만 한다

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

빌드 후 `1.ticket-sales/src/main/resources/static/jacoco/index.html` 확인
