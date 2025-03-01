\c postgres;
DROP DATABASE IF EXISTS cluster;
CREATE DATABASE cluster;
\c cluster;

CREATE TABLE utilisateur (
   id_utilisateur SERIAL,
   nom VARCHAR(50) NOT NULL,
   mail VARCHAR (100) NOT NULL,
   mdp VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_utilisateur)
);


insert into utilisateur (nom, mail, mdp) values 
('kiady', 'kiady@gmail.com', 'kiady');