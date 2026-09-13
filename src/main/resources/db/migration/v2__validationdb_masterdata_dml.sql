-- Validation Rules
INSERT INTO validation.validation_rules
    (validator_name, is_active, priority)
VALUES
    ('DUPLICATION_TXN_RULE', TRUE, 0);

INSERT INTO validation.validation_rules
    (validator_name, is_active, priority)
VALUES
    ('PAYMENT_ATTEMPT_THRESHOLD_RULE', TRUE, 10);


-- Validation Rule Parameters
INSERT INTO validation.validation_rule_params
    (validation_rule_id, param_name, param_value)
VALUES
(
    (SELECT id
     FROM validation.validation_rules
     WHERE validator_name = 'PAYMENT_ATTEMPT_THRESHOLD_RULE'),
    'duration_in_mins',
    '2'
);

INSERT INTO validation.validation_rule_params
    (validation_rule_id, param_name, param_value)
VALUES
(
    (SELECT id
     FROM validation.validation_rules
     WHERE validator_name = 'PAYMENT_ATTEMPT_THRESHOLD_RULE'),
    'max_payment_threshold',
    '5'
);