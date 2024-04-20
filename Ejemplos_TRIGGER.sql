--Ejemplos TRIGGER
UPDATE voluntario 
SET nombre = 'Luisa Navarro',
    email = 'luisa.navarro@example.com'
WHERE nombre = 'Luis Navarro';

DELETE FROM Institucion
WHERE id = 9;

INSERT INTO voluntario (nombre, email, password, rut)
VALUES ('Cornelius Ortiz', 'cornelius.ortiz@example.com', 'pass090', '11033044-1');


