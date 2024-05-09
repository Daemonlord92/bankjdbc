CREATE TABLE user_credential (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(355) NOT NULL
) ENGINE=INNODB;

CREATE TABLE user_profile (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(150) NOT NULL,
    last_name VARCHAR(150) NOT NULL,
    address VARCHAR(355) NOT NULL,
    phone BIGINT NOT NULL,
    credit_score INT NOT NULL,
    date_of_birth DATE NOT NULL,
    user_credential_id BIGINT NOT NULL,
    FOREIGN KEY (user_credential_id)
                          REFERENCES user_credential(id)
                          ON DELETE CASCADE
) ENGINE=INNODB;

CREATE TABLE account (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_type VARCHAR(50) NOT NULL,
    balance DECIMAL(9, 2) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT true,
    created_at DATE NOT NULL,
    disabled_at DATE,
    user_profile_id BIGINT NOT NULL,
    FOREIGN KEY (user_profile_id)
                     REFERENCES user_profile(id)
                     ON DELETE NO ACTION
) ENGINE=INNODB;

CREATE TABLE transaction (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    from_id BIGINT,
    to_id BIGINT NOT NULL,
    amount DECIMAL(9, 2) NOT NULL,
    transaction_type VARCHAR(50) NOT NULL,
    transaction_status VARCHAR(50) NOT NULL,
    created_at DATE NOT NULL,
    FOREIGN KEY (to_id)
                         REFERENCES account(id)
                         ON DELETE NO ACTION,
    FOREIGN KEY (from_id)
                         REFERENCES account(id)
                         ON DELETE NO ACTION 
) ENGINE=INNODB;