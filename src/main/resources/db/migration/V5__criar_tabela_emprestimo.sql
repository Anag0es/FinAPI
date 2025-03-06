CREATE TABLE loans (
    id UUID PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    total_amount DECIMAL(19, 2) NOT NULL,
    installment_amount DECIMAL(19, 2) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    interest_rate DECIMAL(5, 2) NOT NULL,
    description VARCHAR(255) NOT NULL,
    user_id UUID NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_loans_user FOREIGN KEY (user_id) REFERENCES users(id)
);