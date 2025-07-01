/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  jabba
 * Created: Jul 1, 2025
 */

USE KASIRIN

CREATE PROCEDURE InsertUser
	@username VARCHAR(25),
	@password VARCHAR(25),
	@fullname VARCHAR(100),
	@selectedRole VARCHAR(20),
	@startShift TIME	
AS
BEGIN
	DECLARE @NewID VARCHAR(10);
	DECLARE @LastID VARCHAR(10);
	DECLARE @NextNum INT;	
	DECLARE @RoleID VARCHAR(10);
	DECLARE @ShiftID VARCHAR(10);
	SELECT @LastID = MAX(user_id) FROM Users WHERE user_id LIKE 'U%';

	IF @LastID IS NULL
		SET @NewID = 'U0001';
	ELSE
		BEGIN
			SET @NextNum = CAST(SUBSTRING(@LastID, 2, 4) AS INT) + 1;
			SET @NewID = 'U' + RIGHT('0000' + CAST(@NextNum AS VARCHAR), 4);
		END

		SELECT @RoleID = role_id FROM Roles WHERE role_name = @selectedRole
		SELECT @ShiftID = shift_id FROM Shifts WHERE shift_start = @startShift

	INSERT INTO Users(user_id, username, password, fullname) VALUES (@NewID, @username, @password, @fullname)
	INSERT INTO UserRoles(role_id, user_id) VALUES (@RoleID, @NewID)	
	INSERT INTO UserShifts(shift_id, user_id) VALUES (@ShiftID, @NewID)
END
