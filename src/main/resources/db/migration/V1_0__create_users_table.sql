create table users
(
    id                int auto_increment
        primary key,
    username          varchar(255)           not null UNIQUE,
    email             varchar(255)           not null UNIQUE,
    password          varchar(255)           not null,
    is_active         boolean                default false,
    avatar            varchar(255)           null,
    activation_link   varchar(255)           null,
    location          varchar(255)           null,
    role              enum ('ADMIN', 'USER') null,
    short_description varchar(255)           null,
    created_at        datetime(6)            null,
    updated_at        datetime(6)            null
);

