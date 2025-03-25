ALTER TABLE transactions ADD COLUMN status VARCHAR(50) DEFAULT 'PENDING' NOT NULL;

CREATE TABLE transaction_tags (
    transaction_id UUID NOT NULL,
    tag_id UUID NOT NULL,
    PRIMARY KEY (transaction_id, tag_id),
    CONSTRAINT fk_transaction_tags_transaction FOREIGN KEY (transaction_id) REFERENCES transactions(id),
    CONSTRAINT fk_transaction_tags_tag FOREIGN KEY (tag_id) REFERENCES tags(id)
);

ALTER TABLE transactions ADD COLUMN status VARCHAR(255);
