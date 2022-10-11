create database WebBlog;
use WebBlog;

create table role
(
    id           bigint auto_increment primary key,
    name         varchar(255) not null,
    code         varchar(255) not null,
    createDate   timestamp    null,
    modifiedDate timestamp    null,
    createBy     varchar(255) null,
    modifiedBy   varchar(255) null
);

create table user
(
    id           bigint auto_increment primary key,
    username     varchar(150) not null,
    password     varchar(150) not null,
    fullName     varchar(150) null,
    status       int          not null,
    createDate   timestamp    null,
    modifiedDate timestamp    null,
    createBy     varchar(255) null,
    modifiedBy   varchar(255) null,
    roleId       bigint       not null,
    constraint username unique (username),
    constraint FK_user_role foreign key (roleId) references role (id)
);

create table category
(
    id           bigint auto_increment primary key,
    name         varchar(255) not null,
    code         varchar(255) not null,
    createDate   timestamp    null,
    modifiedDate timestamp    null,
    createBy     varchar(255) null,
    modifiedBy   varchar(255) null
);

create table article
(
    id               bigint auto_increment primary key,
    title            varchar(255) null,
    thumbnail        varchar(255) null,
    shortDescription text         null,
    content          text         null,
    createDate       timestamp    null,
    modifiedDate     timestamp    null,
    createBy         varchar(255) null,
    modifiedBy       varchar(255) null,
    categoryId       bigint       not null,
    constraint FK_article_category foreign key (categoryId) references category (id)
);

create table comments
(
    id           bigint auto_increment primary key,
    content      text         not null,
    createDate   timestamp    null,
    modifiedDate timestamp    null,
    createBy     varchar(255) null,
    modifiedBy   varchar(255) null,
    userId       bigint       not null,
    newsId       bigint       not null,
    constraint FK_comments_user foreign key (userId) references user (id),
    constraint FK_comments_article foreign key (newsId) references article (id)
);

