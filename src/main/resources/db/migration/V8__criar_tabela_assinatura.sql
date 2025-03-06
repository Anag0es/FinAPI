CREATE TABLE subscriptions (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    monthly_value DECIMAL(19, 2) NOT NULL,
    start_date DATE NOT NULL,
    renewal_date DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    description VARCHAR(255) NOT NULL,
    user_id UUID NOT NULL,
    bank_account_id UUID,
    card_id UUID,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_subscriptions_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_subscriptions_bank_account FOREIGN KEY (bank_account_id) REFERENCES bank_accounts(id),
    CONSTRAINT fk_subscriptions_card FOREIGN KEY (card_id) REFERENCES cards(id)
);
