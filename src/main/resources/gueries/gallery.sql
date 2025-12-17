use gallery;

drop table order_items;
drop table orders;

create table blocks (
                        id      int auto_increment comment '아이디' primary key,
                        token   varchar(250)                         not null comment '차단 토큰',
                        created datetime default current_timestamp() not null comment '생성 일시'
) comment '토큰 차단';

create table carts (
                       id        int auto_increment comment '아이디' primary key,
                       member_id int                                  not null comment '회원 아이디',
                       item_id   int                                  not null comment '상품 아이디',
                       created   datetime default current_timestamp() not null comment '생성 일시'
) comment '장바구니';

create table items (
                       id           int auto_increment comment '아이디' primary key,
                       name         varchar(50)                          not null comment '상품 이름',
                       img_path     varchar(100)                         not null comment '상품 사진 경로',
                       price        int                                  not null comment '상품 가격',
                       discount_per int                                  not null comment '상품 할인율',
                       created      datetime default current_timestamp() not null comment '생성 일시'
) comment '상품';

create table members (
                         id            int auto_increment comment '아이디' primary key,
                         name          varchar(50)                          not null comment '회원명',
                         login_id      varchar(50)                          not null comment '로그인 아이디',
                         login_pw      char(44)                             not null comment '로그인 패스워드',
                         login_pw_salt char(16)                             not null comment '로그인 패스워드 솔트',
                         created       datetime default current_timestamp() not null comment '생성 일시',
                         constraint members_uk unique (login_id)
) comment '회원';

create table order_items (
                             id       int auto_increment comment '아이디' primary key,
                             order_id int                                  not null comment '주문 아이디',
                             item_id  int                                  not null comment '주문 상품 아이디',
                             created  datetime default current_timestamp() not null comment '생성 일시'
) comment '주문 상품';

create table orders (
                        id          int auto_increment comment '아이디' primary key,
                        member_id   int                                  not null comment '주문자 회원 아이디',
                        name        varchar(50)                          not null comment '주문자명',
                        address     varchar(500)                         not null comment '배송 주소',
                        payment     varchar(10)                          not null comment '결제 수단',
                        card_number varchar(50)                          null comment '카드 번호',
                        amount      bigint                               not null comment '최종 결제 금액',
                        created     datetime default current_timestamp() not null comment '생성 일시'
) comment '주문';

INSERT INTO items (name, img_path, price, discount_per)
VALUES ('Starry', '/img/001.jpg', 10000000, 5)
     , ('Seascape', '/img/002.jpg', 20000000, 10)
     , ('Arles', '/img/003.jpg', 30000000, 15)
     , ('Mountain', '/img/004.jpg', 40000000, 20)
     , ('Provence', '/img/005.jpg', 50000000, 25)
     , ('Houses', '/img/006.jpg', 60000000, 30);


INSERT INTO orders (member_id, name, address, payment, amount)
VALUES (3, '감마', '경기도 파주시 문발로 115', 'card', 27500000)
     , (3, '알파', '서울특별시 강남구 테헤란로 2345', 'bank', 27500000)
     , (3, '베타', '부산광역시 해운대구 바다로 3456', 'card', 27500000)
     , (3, '델타', '대전광역시 유성구 과학로 4567', 'bank', 27500000)
     , (3, '에타', '여수시 돌산로 5678', 'card', 27500000)
     , (3, '제타', '광주광역시 동구 예술로 6789', 'bank', 27500000)
     , (3, '알파', '인천광역시 남동구 바람길 7890', 'card', 27500000)
     , (3, '베타', '울산광역시 남구 해맞이로 8901', 'bank', 27500000)
     , (3, '델타', '세종특별자치시 한누리로 9012', 'card', 27500000)
     , (3, '에타', '제주특별자치도 제주시 오름길 1234', 'bank', 27500000)
     , (3, '제타', '대구광역시 중구 봉산로 2345', 'card', 27500000)
     , (3, '알파', '경상북도 포항시 영일로 3456', 'bank', 27500000)
     , (3, '베타', '충청북도 청주시 상당구 산성로 4567', 'card', 27500000)
     , (3, '델타', '충청남도 천안시 서북구 삼거리로 5678', 'bank', 27500000)
     , (3, '에타', '경상남도 창원시 성산구 공단로 6789', 'card', 27500000)
     , (3, '제타', '전라북도 전주시 덕진구 메타로 7890', 'bank', 27500000)
     , (3, '알파', '전라남도 순천시 남해로 8901', 'card', 27500000)
     , (3, '베타', '강원도 춘천시 호반로 9012', 'bank', 27500000)
     , (3, '델타', '경기도 성남시 분당구 판교로 1234', 'card', 27500000)
     , (3, '에타', '서울특별시 종로구 역사로 2345', 'bank', 27500000)
     , (3, '제타', '부산광역시 중구 해양로 3456', 'card', 27500000)
     , (3, '알파', '광주광역시 서구 풍암로 4567', 'bank', 27500000)
     , (3, '베타', '대전광역시 동구 새뜸로 5678', 'card', 27500000)
     , (3, '델타', '울산광역시 북구 산하로 6789', 'bank', 27500000)
     , (3, '에타', '전라북도 군산시 물빛로 7890', 'card', 27500000)
     , (3, '제타', '경상북도 구미시 첨단로 8901', 'bank', 27500000)
     , (3, '알파', '충청남도 아산시 은행길 9012', 'card', 27500000)
     , (3, '베타', '강원도 강릉시 솔향로 1234', 'bank', 27500000)
     , (3, '델타', '경기도 안양시 동안구 학운로 2345', 'card', 27500000)
     , (3, '에타', '전라남도 여수시 해양로 3456', 'bank', 27500000);

INSERT INTO order_items (order_id, item_id)
SELECT id, 1 FROM orders;

INSERT INTO order_items (order_id, item_id)
SELECT id, 2 FROM orders;

delete  from members where id =1;
select * from members;

select * from items;
select * from orders;
select * from order_items;
# insert into members(name, login_id,login_pw) values('알파','alpha@example.com','1111'),
#                                                    ('베타','beta@example.com','1111'),
#                                                    ('감마','gamma@example.com','1111');