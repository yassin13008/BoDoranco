-- Création de la table équipe
CREATE TABLE equipe (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    ville VARCHAR(100) NOT NULL,
    logo VARCHAR(100)
);

-- Création de la table joueur
CREATE TABLE joueur (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    numero_maillot INT NOT NULL,
    equipe_id INT,
    FOREIGN KEY (equipe_id) REFERENCES equipe(id)
);

-- Création de la table billet
CREATE TABLE billet (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(100) NOT NULL,
    categorie VARCHAR(100) NOT NULL,
    prix DECIMAL(10, 2) NOT NULL
);

-- Création de la table match
CREATE TABLE matches (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATETIME NOT NULL,
    equipe_domicile_id INT,
    equipe_visiteur_id INT,
    lieu VARCHAR(100),
    FOREIGN KEY (equipe_domicile_id) REFERENCES equipe(id),
    FOREIGN KEY (equipe_visiteur_id) REFERENCES equipe(id)
);

-- Insertion de fausses données pour les équipes
INSERT INTO equipe (nom, ville, logo) VALUES
('Los Angeles Lakers', 'Los Angeles', 'lakers_logo.png'),
('Golden State Warriors', 'San Francisco', 'warriors_logo.png'),
('Boston Celtics', 'Boston', 'celtics_logo.png'),
('Chicago Bulls', 'Chicago', 'bulls_logo.png'),
('Miami Heat', 'Miami', 'heat_logo.png');

-- Insertion de fausses données pour les joueurs
INSERT INTO joueur (nom, numero_maillot, equipe_id) VALUES
('LeBron James', 23, 1), -- Joueur des Lakers
('Stephen Curry', 30, 2), -- Joueur des Warriors
('Jayson Tatum', 0, 3),   -- Joueur des Celtics
('Zach LaVine', 8, 4),     -- Joueur des Bulls
('Jimmy Butler', 22, 5);   -- Joueur des Heat

-- Insertion de fausses données pour les billets
INSERT INTO billet (type, categorie, prix) VALUES
('Standard', 'Tribune', 25.00),
('VIP', 'Loge', 100.00),
('Premium', 'VIP', 150.00);

-- Insertion de fausses données pour les matchs
INSERT INTO matches (date, equipe_domicile_id, equipe_visiteur_id, lieu) VALUES
('2024-05-01 18:00:00', 1, 2, 'Staples Center'), -- Lakers vs Warriors
('2024-05-03 19:30:00', 3, 4, 'TD Garden'),      -- Celtics vs Bulls
('2024-05-05 20:00:00', 5, 1, 'American Airlines Arena'); -- Heat vs Lakers
