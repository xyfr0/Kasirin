/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  jabba
 * Created: Jul 1, 2025
 */

USE KASIRIN

CREATE PROCEDURE InsertRole
	@role_name VARCHAR(20)
AS
BEGIN
	DECLARE @NewID VARCHAR(10);
	DECLARE @LastID VARCHAR(10);
	DECLARE @NextNum INT;

	SELECT @LastID = MAX(role_id) FROM Roles WHERE role_id LIKE 'R%';

	IF @LastID IS NULL
		SET @NewID = 'R0001';
	ELSE
		BEGIN
			SET @NextNum = CAST(SUBSTRING(@LastID, 2, 4) AS INT) + 1;
			SET @NewID = 'R' + RIGHT('0000' + CAST(@NextNum AS VARCHAR), 4);
		END

	INSERT INTO Roles (role_id, role_name) VALUES (@NewID, @role_name);
END