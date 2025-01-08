CREATE DATABASE IF NOT EXISTS user_service_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE user_service_db;

CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 고유 ID
                                     username VARCHAR(50) NOT NULL UNIQUE, -- 사용자 이름 (로그인 ID)
    email VARCHAR(100) NOT NULL UNIQUE, -- 이메일
    password_hash VARCHAR(255) NOT NULL, -- 비밀번호 해시값
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 수정일
    );