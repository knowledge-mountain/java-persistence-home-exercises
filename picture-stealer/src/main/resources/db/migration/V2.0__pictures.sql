CREATE TABLE pictures
(
    id         BIGSERIAL PRIMARY KEY,
    nasa_id    BIGINT NOT NULL,
    img_src    TEXT   UNIQUE NOT NULL,
    camera_id  BIGINT REFERENCES cameras (id),
    created_at DATE   NOT NULL
)