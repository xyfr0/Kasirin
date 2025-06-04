/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirin.model;

import java.time.LocalDateTime;

/**
 *
 * @author jabba
 */
public class Transaction {
    private String transactionID;
    private LocalDateTime transactionDate;
    private double income;
    private double total;

    public Transaction(String transactionID, LocalDateTime transactionDate, double income, double total) {
        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
        this.income = income;
        this.total = total;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
