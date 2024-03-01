-- User 1
INSERT INTO USER (id, name, email, password, created_at, active)
VALUES (RANDOM_UUID(), 'John Doe', 'john.doe@example.com', 'HASHED_PASSWORD_1', CURRENT_TIMESTAMP, TRUE);

-- -- User 2
-- INSERT INTO USER (id, name, email, password, created_at, active)
-- VALUES (RANDOM_UUID(), 'Jane Smith', 'jane.smith@example.com', 'HASHED_PASSWORD_2', CURRENT_TIMESTAMP, TRUE);
--
-- -- User 3
-- INSERT INTO USER (id, name, email, password, created_at, active)
-- VALUES (RANDOM_UUID(), 'Michael Brown', 'michael.brown@example.com', 'HASHED_PASSWORD_3', CURRENT_TIMESTAMP, TRUE);
--
-- -- User 4
-- INSERT INTO USER (id, name, email, password, created_at, active)
-- VALUES (RANDOM_UUID(), 'Alice Johnson', 'alice.johnson@example.com', 'HASHED_PASSWORD_4', CURRENT_TIMESTAMP, TRUE);
--
-- -- User 5
-- INSERT INTO USER (id, name, email, password, created_at, active)
-- VALUES (RANDOM_UUID(), 'David Miller', 'david.miller@example.com', 'HASHED_PASSWORD_5', CURRENT_TIMESTAMP, TRUE);