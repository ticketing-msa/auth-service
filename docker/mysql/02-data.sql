-- Insert sample data with dummy password hashes
INSERT INTO users (username, email, password_hash, created_at, updated_at)
VALUES
    ('user1', 'user1@example.com', '$2y$10$eImG6IWhzM6i1EL8Dz5JeuJ2W85h2FZhd0Wx/v4P2hiMC/3UQsKFe', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- Password: "password1"
    ('user2', 'user2@example.com', '$2y$10$KIX6QTfI58NW1dTjz2YlDO7EKk8VQQ/pTIRj99F.aU7eIoAO6j6Su', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- Password: "password2"
    ('user3', 'user3@example.com', '$2y$10$7sGjPjzVupShmDpbW1DoiuhQ9EqS17kCQYjc.F4LlXGdoPq/O4iUG', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- Password: "password3"
    ('user4', 'user4@example.com', '$2y$10$YHrP7Io3YXAO1Uy3UuoEhecPdkQLYKMhQKPzF2FpuP9GZcFLVkmta', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- Password: "password4"
    ('user5', 'user5@example.com', '$2y$10$uJzT7rvObSKhu7H3oKl9oO3.Xi8yzq1lUeBO0Ou9LU59jTeEpzMeW', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP); -- Password: "password5"
