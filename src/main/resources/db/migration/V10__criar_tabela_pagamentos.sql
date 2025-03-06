CREATE TABLE payments (
    id UUID PRIMARY KEY,
    amount DECIMAL(19, 2) NOT NULL,
    due_date DATE NOT NULL,
    payment_date DATE,
    status VARCHAR(50) NOT NULL,
    payment_method VARCHAR(50) NOT NULL,
    installment INTEGER,
    total_installments INTEGER,
    parent_payment_id UUID,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);