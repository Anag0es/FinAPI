CREATE TABLE transactions (
    id UUID PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    amount DECIMAL(19, 2) NOT NULL,
    transaction_date DATE NOT NULL,
    description VARCHAR(255) NOT NULL,
    periodicity VARCHAR(50) NOT NULL,
    is_available_balance BOOLEAN,
    bank_account_id UUID NOT NULL,
    card_id UUID,
    user_id UUID NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_transactions_bank_account FOREIGN KEY (bank_account_id) REFERENCES bank_accounts(id),
    CONSTRAINT fk_transactions_card FOREIGN KEY (card_id) REFERENCES cards(id),
    CONSTRAINT fk_transactions_user FOREIGN KEY (user_id) REFERENCES users(id)
);
