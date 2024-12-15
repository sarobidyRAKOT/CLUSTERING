CREATE DATABASE cluster;
\c cluster;

CREATE TABLE utilisateur (
   id_utilisateur SERIAL,
   nom VARCHAR(50) NOT NULL,
   mdp VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_utilisateur)
);


insert into utilisateur (nom, mdp) values 
('kiady', 'kiady'),
('sarobidy', 'sarobidy');