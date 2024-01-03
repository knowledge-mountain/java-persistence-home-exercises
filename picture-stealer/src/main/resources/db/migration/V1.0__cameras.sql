CREATE TABLE cameras
(
    id         BIGSERIAL PRIMARY KEY,
    nasa_id    BIGINT UNIQUE NOT NULL,
    name       TEXT   NOT NULL,
    created_at DATE   NOT NULL DEFAULT now()
)