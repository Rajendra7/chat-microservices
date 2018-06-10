CREATE TABLE user_profiles(
id SERIAL,
nickname VARCHAR(100) UNIQUE,
bio VARCHAR(500)
);