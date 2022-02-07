drop table if exists `marvel_character` CASCADE;
CREATE TABLE marvel_character
(
    id              BIGINT AUTO_INCREMENT,
    actors_dob      DATE         NOT NULL,
    actors_name     VARCHAR(255) NOT NULL,
    alias           VARCHAR(255) NOT NULL,
    characters_name VARCHAR(255) NOT NULL,
    main_ability    VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);