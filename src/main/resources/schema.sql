-- Drop in order to re-create for demo convenience
DROP TABLE IF EXISTS transfers;
DROP TABLE IF EXISTS account_balances;
DROP TABLE IF EXISTS accounts;

-- =========================
-- Accounts
-- =========================
CREATE TABLE accounts (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  account_id VARCHAR(36) NOT NULL,
  name VARCHAR(100) NOT NULL,
  account_type VARCHAR(2) NOT NULL,
  currency CHAR(3) NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE UNIQUE INDEX ix_u_accounts_account_id ON accounts (account_id);
CREATE INDEX ix_accounts_currency ON accounts(currency);

-- =========================
-- Account Balances (1 row per account)
-- =========================
CREATE TABLE account_balances (
  account_id BIGINT PRIMARY KEY,
  balance DECIMAL(19,2) NOT NULL DEFAULT 0.00,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_balance_account
    FOREIGN KEY (account_id) REFERENCES accounts(id)
    ON DELETE CASCADE
);

-- =========================
-- Transfers
-- =========================
CREATE TABLE transfers (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  from_account_id BIGINT NOT NULL,
  to_account_id BIGINT NOT NULL,
  amount DECIMAL(19,2) NOT NULL,
  currency CHAR(3) NOT NULL,
  transfer_date_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_transfers_from FOREIGN KEY (from_account_id) REFERENCES accounts(id),
  CONSTRAINT fk_transfers_to   FOREIGN KEY (to_account_id)   REFERENCES accounts(id)
);

CREATE INDEX ix_transfers_from ON transfers(from_account_id);
CREATE INDEX ix_transfers_to   ON transfers(to_account_id);
CREATE INDEX ix_transfers_time ON transfers(transfer_date_time);