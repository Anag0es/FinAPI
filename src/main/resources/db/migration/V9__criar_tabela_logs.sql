CREATE TABLE audit_logs (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    action VARCHAR(50) NOT NULL,
    entity VARCHAR(255) NOT NULL,
    entity_id UUID NOT NULL,
    log_date TIMESTAMP NOT NULL,
    ip VARCHAR(50) NOT NULL,
    endpoint VARCHAR(255) NOT NULL,
    CONSTRAINT fk_audit_logs_user FOREIGN KEY (user_id) REFERENCES users(id)
);
