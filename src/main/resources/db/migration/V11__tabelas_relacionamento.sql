CREATE TABLE transaction_tags (
    transaction_id UUID NOT NULL,
    tag_id UUID NOT NULL,
    PRIMARY KEY (transaction_id, tag_id),
    CONSTRAINT fk_transaction_tags_transaction FOREIGN KEY (transaction_id) REFERENCES transactions(id),
    CONSTRAINT fk_transaction_tags_tag FOREIGN KEY (tag_id) REFERENCES tags(id)
);

CREATE TABLE loan_tags (
    loan_id UUID NOT NULL,
    tag_id UUID NOT NULL,
    PRIMARY KEY (loan_id, tag_id),
    CONSTRAINT fk_loan_tags_loan FOREIGN KEY (loan_id) REFERENCES loans(id),
    CONSTRAINT fk_loan_tags_tag FOREIGN KEY (tag_id) REFERENCES tags(id)
);

CREATE TABLE financial_reserve_tags (
    financial_reserve_id UUID NOT NULL,
    tag_id UUID NOT NULL,
    PRIMARY KEY (financial_reserve_id, tag_id),
    CONSTRAINT fk_financial_reserve_tags_financial_reserve FOREIGN KEY (financial_reserve_id) REFERENCES financial_reserves(id),
    CONSTRAINT fk_financial_reserve_tags_tag FOREIGN KEY (tag_id) REFERENCES tags(id)
);

CREATE TABLE subscription_tags (
    subscription_id UUID NOT NULL,
    tag_id UUID NOT NULL,
    PRIMARY KEY (subscription_id, tag_id),
    CONSTRAINT fk_subscription_tags_subscription FOREIGN KEY (subscription_id) REFERENCES subscriptions(id),
    CONSTRAINT fk_subscription_tags_tag FOREIGN KEY (tag_id) REFERENCES tags(id)
);