CREATE TABLE post (
    id SERIAL PRIMARY KEY,
    name TEXT,
    description TEXT,
    created TIMESTAMP default current_timestamp,
    visible BOOLEAN default false,
    city_id integer
);