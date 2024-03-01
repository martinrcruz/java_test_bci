CREATE TABLE USER
(
    id               UUID PRIMARY KEY,
    name             VARCHAR(255) NOT NULL,
    email            VARCHAR(255) NOT NULL UNIQUE,
    password         VARCHAR(255) NOT NULL,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modified_at TIMESTAMP,
    last_login       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    token            VARCHAR(255),
    active           BOOLEAN   DEFAULT TRUE
);

CREATE TABLE PHONE
(
    id           UUID PRIMARY KEY,
    number       INTEGER NOT NULL,
    city_code    INTEGER NOT NULL,
    country_code INTEGER NOT NULL
);

CREATE TABLE USER_PHONE
(
    user_id  UUID REFERENCES USER (id),
    phone_id UUID REFERENCES PHONE (id),
    PRIMARY KEY (user_id, phone_id)
);

ALTER TABLE USER_PHONE
    ADD CONSTRAINT FK_user_phone_user FOREIGN KEY (user_id) REFERENCES USER (id);

ALTER TABLE USER_PHONE
    ADD CONSTRAINT FK_user_phone_phone FOREIGN KEY (phone_id) REFERENCES PHONE (id);