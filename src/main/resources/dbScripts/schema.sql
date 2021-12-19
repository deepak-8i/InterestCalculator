CREATE TABLE IF NOT EXISTS `account` (
    `account_number` bigint NOT NULL PRIMARY KEY,
    `bsb` varchar(50),
    `account_open_date` DATE
);

CREATE TABLE IF NOT EXISTS `account_day_end_balance` (
    `account_number` bigint NOT NULL,
    `balance` DECIMAL(20,2),
    `daily_interest` DECIMAL(20,2),
    `day_end_date` DATE NOT NULL,
     PRIMARY KEY (account_number, day_end_date),
     FOREIGN KEY (account_number) REFERENCES account (account_number)
);

CREATE TABLE IF NOT EXISTS `account_monthly_interest` (
    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    `account_number` BIGINT NOT NULL,
    `monthly_interest_balance` DECIMAL(20,2),
    `month_end_date` DATE,
     FOREIGN KEY (account_number) REFERENCES account (account_number)
);