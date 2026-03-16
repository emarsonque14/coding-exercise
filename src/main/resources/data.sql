-- Accounts
INSERT INTO accounts (account_id, name, account_type, currency) VALUES
  ('000123456789', 'Alice CA', 'CA', 'PHP'),
  ('000987654321', 'Alice SA', 'SA', 'PHP'),
  ('000111222333','Bob CA',   'CA', 'PHP');

-- Account Balances (assumes IDs 1..3 from auto-increment)
INSERT INTO account_balances (account_id, balance) VALUES
  (1, 10000.00),
  (2,  5000.00),
  (3,  7500.00);

-- A sample transfer: Alice CA -> Bob CA
INSERT INTO transfers (from_account_id, to_account_id, amount, currency, transfer_date_time)
VALUES (1, 3, 1500.00, 'PHP', CURRENT_TIMESTAMP);