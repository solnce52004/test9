CREATE TABLE `users`
(
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NULL,
    `email` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NULL,
    `created_at` TIMESTAMP DEFAULT (CURRENT_TIMESTAMP),
    `updated_at` TIMESTAMP DEFAULT (CURRENT_TIMESTAMP)
);