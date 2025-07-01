/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  jabba
 * Created: Jul 1, 2025
 */
USE KASIRIN

CREATE PROCEDURE InsertShift
	@shiftStart TIME,
	@shiftEnd TIME
AS
BEGIN
	DECLARE @NewID VARCHAR(10);
	DECLARE @LastID VARCHAR(10);
	DECLARE @NextNum INT;

	SELECT @LastID = MAX(shift_id) FROM Shifts WHERE shift_id LIKE 'S%';

	IF @LastID IS NULL
		SET @NewID = 'S0001';
	ELSE
		BEGIN
			SET @NextNum = CAST(SUBSTRING(@LastID, 2, 4) AS INT) + 1;
			SET @NewID = 'S' + RIGHT('0000' + CAST(@NextNum AS VARCHAR), 4);
		END

	INSERT INTO Shifts(shift_id, shift_start, shift_end) VALUES (@NewID, @shiftStart, @shiftEnd)
END
