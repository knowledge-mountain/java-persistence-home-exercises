create schema if not exists home;
set schema 'home';

create type advisor_role as enum ('associate', 'partner', 'senior');
create type phone_type as enum ('home', 'work', 'mobile');
create type application_status as enum ('new', 'assigned', 'on_hold', 'approved', 'canceled', 'declined');

create table if not exists "user"
(
    id               bigserial,
    email            text not null,
    cognito_username text not null,
    constraint PK_user primary key (id),
    constraint UQ_user_email unique (email),
    constraint UQ_user_cognito_username unique (cognito_username)
);

create table if not exists advisor
(
    user_id bigint,
    "role"  advisor_role not null,
    constraint PK_advisor primary key (user_id),
    constraint FK_advisor_user foreign key (user_id) references "user" (id) on delete cascade
);

create table if not exists applicant
(
    user_id   bigint,
    firstname text          not null,
    lastname  text          not null,
    ssn       bigint unique not null,
    constraint PK_applicant primary key (user_id),
    constraint FK_applicant_user foreign key (user_id) references "user" (id) on delete cascade
);

create table if not exists application
(
    applicant_id bigint,
    advisor_id   bigint
        constraint CHECK_if_applicant_is_present check (applicant_id is not null),
    "name"       text               not null,
    amount       decimal            not null,
    app_status   application_status not null,
    created_at   timestamp          not null default now(),
    constraint FK_application_applicant foreign key (applicant_id) references applicant (user_id) on delete cascade,
    constraint FK_application_advisor foreign key (advisor_id) references advisor (user_id) on delete cascade,
    constraint PK_application primary key (advisor_id, applicant_id)
);

create table if not exists address
(
    applicant_id bigint,
    city         text not null,
    street       text not null,
    number       int  not null,
    zip          int  not null,
    apt          int  not null,
    constraint PK_address primary key (applicant_id),
    constraint FK_address_applicant foreign key (applicant_id) references applicant (user_id),
    constraint UQ_address_zip unique (zip)
);

create table if not exists phone_number
(
    id           bigserial,
    number       text not null,
    phone_type   phone_type  not null,
    applicant_id bigint,
    constraint PK_phone_number primary key (id),
    constraint FK_phone_number_applicant foreign key (applicant_id) references applicant(user_id) on delete cascade,
    constraint UQ_phone_number_number unique (number)
)
