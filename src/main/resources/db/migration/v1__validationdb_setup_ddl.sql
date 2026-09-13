DROP DATABASE IF EXISTS validation;

DROP USER IF EXISTS 'validations_user'@'%';

-- =====================================================
-- Create Database & User
-- =====================================================

CREATE DATABASE validation;

CREATE USER 'validations_user'@'%' IDENTIFIED BY 'P9v@tX3#nLz!Q8wK';

GRANT SELECT, INSERT, UPDATE, DELETE
ON validation.*
TO 'validations_user'@'%';

-- =====================================================
-- Create Tables
-- =====================================================

CREATE TABLE validation.merchant_payment_requests (
    id BIGINT NOT NULL AUTO_INCREMENT,
    end_user_id VARCHAR(100),
    merchant_txn_reference VARCHAR(100) NOT NULL,
    transaction_request TEXT DEFAULT NULL,
    created_at TIMESTAMP(2) NOT NULL DEFAULT CURRENT_TIMESTAMP(2),
    updated_at TIMESTAMP(2) NOT NULL DEFAULT CURRENT_TIMESTAMP(2)
        ON UPDATE CURRENT_TIMESTAMP(2),

    PRIMARY KEY (id),
    UNIQUE KEY uk_merchant_txn_reference (merchant_txn_reference)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE validation.validation_rules (
    id BIGINT NOT NULL AUTO_INCREMENT,
    validator_name VARCHAR(50) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    priority SMALLINT NOT NULL,
    created_at TIMESTAMP(2) NOT NULL DEFAULT CURRENT_TIMESTAMP(2),
    updated_at TIMESTAMP(2) NOT NULL DEFAULT CURRENT_TIMESTAMP(2)
        ON UPDATE CURRENT_TIMESTAMP(2),

    PRIMARY KEY (id),
    UNIQUE KEY uk_validator_name (validator_name)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE validation.validation_rule_params (
    id BIGINT NOT NULL AUTO_INCREMENT,

    validation_rule_id BIGINT NOT NULL,

    param_name VARCHAR(200) NOT NULL,
    param_value VARCHAR(200) NOT NULL,

    created_at TIMESTAMP(2) NOT NULL DEFAULT CURRENT_TIMESTAMP(2),
    updated_at TIMESTAMP(2) NOT NULL DEFAULT CURRENT_TIMESTAMP(2)
        ON UPDATE CURRENT_TIMESTAMP(2),

    PRIMARY KEY (id),

    CONSTRAINT fk_validation_rule_params_validation_rule
        FOREIGN KEY (validation_rule_id)
        REFERENCES validation.validation_rules (id)
		ON DELETE RESTRICT
		ON UPDATE RESTRICT

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;