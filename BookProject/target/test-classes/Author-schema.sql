DROP TABLE IF EXISTS author;

CREATE TABLE IF NOT EXISTS author (
  author_id BIGINT PRIMARY KEY  AUTO_INCREMENT,
  first_name VARCHAR(500),
  last_name VARCHAR(500),
  nationality VARCHAR(500),
  orcid_No BIGINT
);