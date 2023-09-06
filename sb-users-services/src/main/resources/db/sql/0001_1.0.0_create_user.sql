--liquibase formatted sql
--changeset thangducvu:create_user
--validCheckSum ANY

CREATE TABLE IF NOT EXISTS "sbmaster"."user"(
    "id" SERIAL NOT NULL,
    "username" VARCHAR(50) NOT NULL,
    "password" VARCHAR(255) NOT NULL,
    "first_name" VARCHAR(50) NULL,
    "last_name" VARCHAR(100) NULL,
    "full_name" VARCHAR(255),
    "address" VARCHAR(255),
    "date_of_birth" DATE,
    "email" VARCHAR(50) NULL,
    "phone_number" VARCHAR(50) NULL,
    "country_code" VARCHAR(10) NULL,
    "country" VARCHAR(255),
    "create_timestamp" TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "update_timestamp" TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE(username)
);

CREATE TABLE IF NOT EXISTS "sbmaster"."role"(
    "id" SERIAL NOT NULL,
    "role_name" VARCHAR(50) NOT NULL,
    "description" VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE(role_name)
);

CREATE TABLE IF NOT EXISTS "sbmaster"."permission"(
    "id" SERIAL NOT NULL,
    "permission_name" VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE(permission_name)
);

CREATE TABLE IF NOT EXISTS "sbmaster"."user_to_role"(
    "user_id" SERIAL NOT NULL,
    "role_id" SERIAL NOT NULL,
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE IF NOT EXISTS "sbmaster"."role_to_permission"(
    "role_id" SERIAL NOT NULL,
    "permission_id" SERIAL NOT NULL,
    PRIMARY KEY (role_id, permission_id)
);