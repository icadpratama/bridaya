-- Authentication
CREATE TABLE users(
    user_id BIGSERIAL,
    username VARCHAR(50),
    email VARCHAR(100),
    phone_number VARCHAR(13),
    password VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT users_pk PRIMARY KEY (user_id),
    CONSTRAINT username_uq UNIQUE (username),
    CONSTRAINT phone_number_uq UNIQUE (phone_number)
);

CREATE TABLE roles(
    role_id BIGSERIAL,
    role_name VARCHAR(10),
    CONSTRAINT roles_pk PRIMARY KEY (role_id),
    CONSTRAINT roles_uq UNIQUE (role_name)
);

CREATE TABLE user_roles(
    user_id BIGINT,
    role_id BIGINT,
    CONSTRAINT user_roles_pk PRIMARY KEY (user_id, role_id),
    CONSTRAINT ur_user_id_fk FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT ur_role_id_fk FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

CREATE TABLE images(
    image_id BIGSERIAL,
    object_name VARCHAR(255),
    bucket_name VARCHAR(255),
    size BIGINT,
    content_type VARCHAR(255),
    user_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT DEFAULT NULL,
    updated_by BIGINT DEFAULT NULL,
    CONSTRAINT images_pk PRIMARY KEY (image_id),
    CONSTRAINT images_user_id_fk FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE merchants(
    merchant_id BIGSERIAL,
    name VARCHAR(100),
    address VARCHAR(255),
    contact_number VARCHAR(14),
    email VARCHAR(100),
    image_id BIGINT,
    user_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT DEFAULT NULL,
    updated_by BIGINT DEFAULT NULL,
    CONSTRAINT merchants_pk PRIMARY KEY (merchant_id),
    CONSTRAINT merchants_user_id_fk FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT merchants_image_id_fk FOREIGN KEY (image_id) REFERENCES images(image_id)
);

CREATE TABLE items(
    item_id BIGSERIAL,
    name VARCHAR(100),
    price BIGINT,
    status VARCHAR(15),
    description VARCHAR(255),
    image_id BIGINT,
    user_id BIGINT,
    merchant_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by BIGINT DEFAULT NULL,
    updated_by BIGINT DEFAULT NULL,
    CONSTRAINT items_pk PRIMARY KEY (item_id),
    CONSTRAINT items_user_id_fk FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT items_image_id_fk FOREIGN KEY (image_id) REFERENCES images(image_id),
    CONSTRAINT items_merchant_id_fk FOREIGN KEY (merchant_id) REFERENCES merchants(merchant_id)
);

CREATE TABLE orders(
    order_id BIGSERIAL,
    amount SMALLINT,
    total BIGINT
);