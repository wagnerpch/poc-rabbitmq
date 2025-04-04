CREATE SCHEMA IF NOT EXISTS data;

CREATE TABLE data.person (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    created_at TIMESTAMPTZ NOT NULL,
    deleted_at TIMESTAMPTZ
);