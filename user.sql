CREATE TABLE users (
                       username varchar(50) NOT NULL,
                       password varchar(100) NOT NULL,
                       enabled tinyint(1) NOT NULL,

                       PRIMARY KEY (username)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO users
VALUES
    ('user1', '{noop}123', 1),
    ('user2', '{noop}123', 1);

CREATE TABLE authorities (
                             username varchar(50) NOT NULL,
                             authority varchar(50) NOT NULL,

                             UNIQUE KEY authorities_idx_1 (username, authority),

                             CONSTRAINT authorities_ibfk_1
                                 FOREIGN KEY (username)
                                     REFERENCES users (username)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO authorities
VALUES
    ('user1', 'ROLE_ADMIN'),
    ('user1', 'ROLE_USER'),
    ('user2', 'ROLE_USER');
