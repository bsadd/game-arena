drop table if exists Country;
create TABLE Country (
  id INT NOT NULL AUTO_INCREMENT,
  code char(3) NOT NULL,
  name varchar(20) NOT NULL,
  PRIMARY KEY (id)
);
