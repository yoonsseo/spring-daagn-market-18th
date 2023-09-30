# spring-dangn-market-18th
CEOS 18th Backend Study - Carrot Market

## 🥕당근마켓 DB 모델링
### 1️⃣ 회원 기능 ➡️ User 엔티티
![User1](https://github.com/yoonsseo/spring_core/assets/90557277/147b67be-8d3a-4963-9414-1d0ff9a41a69)
* 회원 고유 번호 `userId` 
* 닉네임 `nickname`
* 프로필 사진 `profileImage`
* 매너온도 `manners`
* 재거래희망률
* 응답률
* 응답시간


### 2️⃣ 동네 ➡️ Town 엔티티
|![Town1](https://github.com/yoonsseo/spring_core/assets/90557277/8e773645-6223-47aa-ac1e-feb364421b86)| ![Town2](https://github.com/yoonsseo/spring_core/assets/90557277/36c3b291-cb99-42e5-98a0-706751157c91) |
|-----|-----|
* `townId`
* `stateName`, `districtName`, `townName` ex. 서울시 서초구 방배동

### 3️⃣ 동네 인증 ➡️ UserTown 엔티티
유저 당 최대 두 개의 동네 정보
* `userTownId` `userId` `townId`
* 동네 범위 `townRange`   
    📌 [주의] `range`를 쓰면 mysql 예약어라 에러가 난다!! 나도 알고 싶지 않았다 🥹🥹
* 동네 인증 시간 `townAuthTime`
* 동네 인증 여부 `isTownAuth`

### 4️⃣ 물건 올리기 ➡️ Post 엔티티
![Post1](https://github.com/yoonsseo/spring_core/assets/90557277/7a644358-670d-4d21-ba94-1c6f61110ae5)
* 판매 게시글 고유 번호 `postId`
* 제목 `title` -> @Notnull
* 카테고리 `categoryId` -> @Notnull
* 거래방식 `tradeMethod` 
* 가격 `price`
* 가격 제안 여부 `isPriceOffer`
* 자세한 설명 `description` -> @Notnull
* 거래 희망 장소 `wishPlace`
* 판매자 user -> `seller`
* 보여줄 동네 설정 `townRange`
* 판매 상태 `postStatus`
* 대표사진 `thumbnail`
* 나머지 사진 `image1~9`
* 브랜드 `brand`

### 5️⃣ 카테고리 ➡️ Category 엔티티
* 카테고리 고유 번호 `categoryId`
* 카테고리 이름 `name`

### 6️⃣ 채팅방 ➡️ ChatRoom 엔티티
![Chat1](https://github.com/yoonsseo/spring_core/assets/90557277/c79ce7ce-9b96-4dde-a953-4758ae57e031)
* 채팅방 고유 번호 `chatRoomId`
* 판매자/구매자 정보 user -> `seller`/`buyer`
* 판매 게시글 정보 `postId`

### 7️⃣ 채팅 내용 ➡️ Chat 엔티티
* 채팅 고유 번호 `chatId`
* 채팅방 번호 `chatRoomId`
* 채팅 내용 `content`
* 상대방이 읽었는지 여부 `isRead`
* 누가 보내고 받았는지 user -> `sender`/`receiver`

### 8️⃣ 거래후기 ➡️ Review 엔티티
![Review1](https://github.com/yoonsseo/spring_core/assets/90557277/a8e3444a-65bc-4c23-b575-f47e01b924c1)   

| ![Review2](https://github.com/yoonsseo/spring_core/assets/90557277/9fcd6d6f-12fa-4406-bd46-f64c4eb6c4e3) | ![Review3](https://github.com/yoonsseo/spring_core/assets/90557277/1f3c6e2d-040d-4d23-8ea2-07111324d7b9)|
|-----|-----|
* 거래 후기 고유 번호 `reviewId`
* 작성자/대상자 `reviewer`/`reviewee`
* 어떤 판매 게시글에 대한 리뷰인지 `postId`
* 구매자가 적은 후기인지 판매자가 적은 후기인지 `reviewType`

### 📅 ERD 
![당근ERD](https://github.com/yoonsseo/spring_core/assets/90557277/57e660a1-e24f-40e0-870e-a463c7ad7c4f)

