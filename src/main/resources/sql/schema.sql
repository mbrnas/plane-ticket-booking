create table if not exists roles
(
    id   serial
    primary key,
    name varchar(20)
    constraint roles_name_check
    check ((name)::text = ANY
((ARRAY ['ROLE_USER'::character varying, 'ROLE_MODERATOR'::character varying, 'ROLE_ADMIN'::character varying])::text[]))
    );

alter table roles
    owner to postgres;

create table if not exists users
(
    id       bigserial
    primary key,
    email    varchar(50)
    constraint uk6dotkott2kjsp8vw4d0m25fb7
    unique,
    password varchar(120),
    username varchar(20)
    constraint ukr43af9ap4edm43mmtq01oddj6
    unique
    );

alter table users
    owner to postgres;

create table if not exists user_roles
(
    user_id bigint  not null
    constraint fkhfh9dx7w3ubf1co1vdev94g3f
    references users,
    role_id integer not null
    constraint fkh8ciramu9cc9q3qcqiv4ue8a6
    references roles,
    primary key (user_id, role_id)
    );

alter table user_roles
    owner to postgres;

create table if not exists airlines
(
    airline_id   bigserial
    primary key,
    airline_name varchar(255)
    );

alter table airlines
    owner to postgres;

create table if not exists flights
(
    flight_id       bigserial
    primary key,
    arrival_time    timestamp(6),
    departure_time  timestamp(6),
    destination     varchar(255),
    flight_number   varchar(255),
    origin          varchar(255),
    price           numeric(38, 2) not null,
    seats_available integer,
    seats_total     integer,
    airline_id      bigint         not null
    constraint fkieor4j3ivp3xu584qenhfh0gd
    references airlines
    );

alter table flights
    owner to postgres;

create table if not exists payments
(
    payment_id     bigserial
    primary key,
    amount         numeric(38, 2) not null,
    payment_date   timestamp(6)   not null,
    payment_method varchar(255)   not null,
    payment_status varchar(255)   not null
    );

alter table payments
    owner to postgres;

create table if not exists bookings
(
    booking_id     bigserial
    primary key,
    booking_time   timestamp(6),
    payment_status varchar(255),
    status         varchar(255),
    flight_id      bigint not null
    constraint fkidcytqkgq0ve4x1elcnbmdy8a
    references flights,
    user_id        bigint not null
    constraint fkeyog2oic85xg7hsu2je2lx3s6
    references users,
    payment_id     bigint
    constraint uk_cj0yayocyxid3853am17l2p1g
    unique
    constraint fkjki6p9c5yckce7owst8vxu17u
    references payments
    );

alter table bookings
    owner to postgres;

create table if not exists passengers
(
    passenger_id     bigserial
    primary key,
    first_name       varchar(255),
    last_name        varchar(255),
    passport_number  varchar(255),
    special_requests varchar(255),
    booking_id       bigint not null
    constraint fkgc7vcfrut3vamougerwse2m2u
    references bookings
    );

alter table passengers
    owner to postgres;

