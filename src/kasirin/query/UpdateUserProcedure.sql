/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  jabba
 * Created: Jul 1, 2025
 */


CREATE PROCEDURE UpdateUser
	@username VARCHAR(25),
	@password VARCHAR(25),
	@fullname VARCHAR(100),
	@selectedRole VARCHAR(20),
	@startShift TIME	
AS
BEGIN
    DECLARE @RoleID VARCHAR(10);
    DECLARE @ShiftID VARCHAR(10);
    
    SELECT @RoleID = role_id FROM Roles WHERE role_name = @selectedRole
    SELECT @ShiftID = shift_id FROM Shifts WHERE shift_start = @startShift

    
END