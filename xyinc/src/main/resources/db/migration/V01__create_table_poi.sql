CREATE TABLE Poi( 
 poi_id               BIGINT(50) PRIMARY KEY AUTO_INCREMENT,
 name                 VARCHAR(100) NOT NULL,
 coordinate_x         INTEGER NOT NULL,
 coordinate_y         INTEGER NOT NULL, 
 create_date          DATE NOT NULL,
 edit_date            DATE,
 delete_date          DATE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO poi (name,coordinate_x,coordinate_y,create_date)
VALUES ('Lanchonete',27,12,CURRENT_DATE());

INSERT INTO poi (name,coordinate_x,coordinate_y,create_date)
VALUES ('Posto',31,18,CURRENT_DATE());

INSERT INTO poi (name,coordinate_x,coordinate_y,create_date)
VALUES ('Joalheria',15,12,CURRENT_DATE());

INSERT INTO poi (name,coordinate_x,coordinate_y,create_date)
VALUES ('Floricultura',19,21,CURRENT_DATE());

INSERT INTO poi (name,coordinate_x,coordinate_y,create_date)
VALUES ('Pub',12,8,CURRENT_DATE());

INSERT INTO poi (name,coordinate_x,coordinate_y,create_date)
VALUES ('Supermercado',23,6,CURRENT_DATE());

INSERT INTO poi (name,coordinate_x,coordinate_y,create_date)
VALUES ('Churrascaria',28,2,CURRENT_DATE());




