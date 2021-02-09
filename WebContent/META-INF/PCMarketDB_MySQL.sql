CREATE TABLE Part_Type (id INT NOT NULL AUTO_INCREMENT,
						Motherboard_id INT,
						CPU_id INT,
						GPU_id INT,
						Hard_Drive_id INT,
						User VARCHAR(75) NOT NULL,
						Price VARCHAR(75) NOT NULL,
						FOREIGN KEY (Motherboard_id) REFERENCES Motherboard(id),
						FOREIGN KEY (CPU_id) REFERENCES CPU(id),
						FOREIGN KEY (GPU_id) REFERENCES GPU(id),
						FOREIGN KEY (Hard_Drive_id) REFERENCES Hard_Drive(id),
						PRIMARY KEY (ID));

CREATE TABLE Motherboard (id INT NOT NULL AUTO_INCREMENT,
						  Manufacturer VARCHAR(75) NOT NULL,
						  Model_Name VARCHAR(75) NOT NULL,
						  Socket VARCHAR(75) NOT NULL,
						  Form_Factor VARCHAR(75) NOT NULL,
						  Expansion_Slots VARCHAR(75) NOT NULL,
						  PRIMARY KEY (ID));

CREATE TABLE CPU (id INT NOT NULL AUTO_INCREMENT,
				  Manufacturer VARCHAR(75) NOT NULL,
				  Model_Name VARCHAR(75) NOT NULL,
				  Num_of_Cores VARCHAR(75) NOT NULL,
				  Frequency  VARCHAR(75) NOT NULL,
				  Socket_Compatibility VARCHAR(75) NOT NULL,
				  PRIMARY KEY (ID));

CREATE TABLE GPU (id INT NOT NULL AUTO_INCREMENT,
				  Manufacturer VARCHAR(75) NOT NULL,
				  Model_Name VARCHAR(75) NOT NULL,
				  Port_Type VARCHAR(75) NOT NULL,
				  Interface_Type_Type VARCHAR(75) NOT NULL,
				  Memory_Size VARCHAR(75) NOT NULL,
				  PRIMARY KEY (ID));


CREATE TABLE Hard_Drive (id INT NOT NULL AUTO_INCREMENT,
						 Manufacturer VARCHAR(75) NOT NULL,
						 Model_Name VARCHAR(75) NOT NULL,
						 Storage_Space VARCHAR(75) NOT NULL,
						 Rotations_Per_Minute VARCHAR(75) NOT NULL,
						 PRIMARY KEY (ID));

/*INSERT STATMENTS*/
INSERT INTO Motherboard (id, Manufacturer, Model_Name, Socket, Form_Factor) values (default, ?, ?, ?);
INSERT INTO CPU (id, Manufacturer, Model_Name, Num_of_Cores, Frequency, Socket_Compatibility) values (default, ?, ?, ?);
INSERT INTO GPU (id, Manufacturer, Model_Name, Port_Type, Interface_Type, Memory_Size) values (default, ?, ?, ?, ?, ?);
INSERT INTO Hard_Drive (id, Manufacturer, Model_Name, Storage_Space, Rotations_Per_Minute) values (default, ?, ?, ?);

/*REMOVE STATMENTS*/
DELETE FROM Part WHERE id = ?;
DELETE FROM Motherboard WHERE id = ?;
DELETE FROM CPU WHERE id = ?;
DELETE FROM GPU WHERE id = ?;
DELETE FROM Hard_Drive WHERE id = ?;

/*SELECT ALL*/
SELECT M.Manufacturer, M.Model_Name, M.Socket, M.Form_Factor, 
	   C.Manufacturer, C.Model_Name, C.Num_of_Cores, C.Frequency, C.Socket_Compatibility,
	   G.Manufacturer, G.Model_Name, G.Port_Type, G.Interface_Type, G.Memory_Size,
	   H.Manufacturer, H.Model_Name, H.Storage_Space, H.Rotations_Per_Minute,
FROM Motherboard M, CPU C, GPU G, Hard_Drive H
ORDER BY M.Manufacturer, M.Model_Name, M.Socket, M.Form_Factor,
		 C.Manufacturer, C.Model_Name, C.Num_of_Cores, C.Frequency,  C.Socket_Compatibility,
		 G.Manufacturer, G.Model_Name, G.Port_Type, G.Interface_Type, G.Memory_Size,
		 H.Manufacturer, H.Model_Name, H.Storage_Space, H.Rotations_Per_Minute,
		 M.id, C.id, H.id;

/*SELECT NEWEST TO OLDEST*/
SELECT Motherboard_id, CPU_id, Hard_Drive_id FROM Part ORDER BY id DESC;
SELECT * FROM Motherboard_Part ORDER BY id DESC;
SELECT * FROM CPU_Part ORDER BY id DESC;
SELECT * FROM Hard_Drive_Part ORDER BY id DESC;

/*SELECT OLDEST TO NEWEST*/
SELECT * FROM Part ORDER BY id ASC;
SELECT * FROM Motherboard_Part ORDER BY id ASC;
SELECT * FROM CPU_Part ORDER BY id ASC;
SELECT * FROM Hard_Drive_Part ORDER BY id ASC;

/*SELECT $ TO $$$*/
SELECT Motherboard_id, CPU_id, Hard_Drive_id, Price FROM Part_Type ORDER BY Price DESC;

/*SELECT $$$ TO $*/
SELECT Motherboard_id, CPU_id, Hard_Drive_id, Price FROM Part_Type ORDER BY Price ASC;