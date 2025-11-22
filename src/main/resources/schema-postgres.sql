CREATE TABLE IF NOT EXISTS content (
    id           BIGSERIAL PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    description         TEXT,
    status       VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    date_updated TIMESTAMPTZ,
    url          VARCHAR(255)
);