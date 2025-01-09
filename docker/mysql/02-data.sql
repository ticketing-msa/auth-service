-- Insert sample data with dummy password hashes
INSERT INTO users (username, email, password_hash, created_at, updated_at)
VALUES
    ('user1', 'user1@example.com', '$2a$10$YB6iH3KHQhZpYqMstW69Neh9skBiisSfno177SDMpmUG0iH0Yx1Pi', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- Password: "password1"
    ('user2', 'user2@example.com', '$2a$10$Yxc9N5Y33iIFaN/9BJRaH.nl1w6q1e6GfwGht6zMIK9vvrw7qJMcu', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- Password: "password2"
    ('user3', 'user3@example.com', '$2a$10$gguaIHPYCd4EpIVhBcb.bORmu58kac25UYjXfjpnEFdZfLr629g9K', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- Password: "password3"
    ('user4', 'user4@example.com', '$2a$10$JJJYSjTuOpN0bJXf3fGkSO7QT0Ile/PqDx0P1qbw60KGQvNEzGQD2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- Password: "password4"
    ('user5', 'user5@example.com', '$2a$10$rgCyD59e0HwAkFrH06cLCesdi75oUksxPt88JDYXxEPtuH3G.E99a', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP); -- Password: "password5"
