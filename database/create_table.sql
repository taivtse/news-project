CREATE TABLE role(
  id bigint NOT NULL PRIMARY KEY auto_increment,
  name VARCHAR(255) NOT NULL,
  code VARCHAR(255) NOT NULL,
  created_date TIMESTAMP NULL,
  modifie_ddate TIMESTAMP NULL,
  created_by VARCHAR(255) NULL,
  modifie_dby VARCHAR(255) NULL
);

CREATE TABLE user (
  id bigint NOT NULL PRIMARY KEY auto_increment,
  username VARCHAR(150) NOT NULL,
  password VARCHAR(150) NOT NULL,
  fullname VARCHAR(150) NULL,
  created_date TIMESTAMP NULL,
  modified_date TIMESTAMP NULL,
  created_by VARCHAR(255) NULL,
  modified_by VARCHAR(255) NULL,
	is_active bit(1) NOT NULL,
	role_id bigint NOT NULL
);

ALTER TABLE user ADD CONSTRAINT fk_user_role FOREIGN KEY (role_id) REFERENCES role(id);

CREATE TABLE news (
  id bigint NOT NULL PRIMARY KEY auto_increment,
  title VARCHAR(255) NOT NULL,
  thumbnail VARCHAR(255) NULL,
  description TEXT NULL,
  content TEXT NOT NULL,
  created_date TIMESTAMP NULL,
  modified_date TIMESTAMP NULL,
  created_by VARCHAR(255) NULL,
  modified_by VARCHAR(255) NULL,
	category_id bigint NOT NULL
);

CREATE TABLE category (
  id bigint NOT NULL PRIMARY KEY auto_increment,
  name VARCHAR(255) NOT NULL,
  code VARCHAR(255) NOT NULL,
  created_date TIMESTAMP NULL,
  modified_date TIMESTAMP NULL,
  created_by VARCHAR(255) NULL,
  modified_by VARCHAR(255) NULL
);

ALTER TABLE news ADD CONSTRAINT fk_news_category FOREIGN KEY (category_id) REFERENCES category(id);

CREATE TABLE comment (
  id bigint NOT NULL PRIMARY KEY auto_increment,
  content TEXT NOT NULL,
  created_date TIMESTAMP NULL,
  modified_date TIMESTAMP NULL,
  created_by VARCHAR(255) NULL,
  modified_by VARCHAR(255) NULL,
  user_id bigint NOT NULL,
  news_id bigint NOT NULL
);

ALTER TABLE comment ADD CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES user(id);
ALTER TABLE comment ADD CONSTRAINT fk_comment_news FOREIGN KEY (news_id) REFERENCES news(id);