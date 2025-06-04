/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirin.model;

/**
 *
 * @author jabba
 */
public class Operator {
    private String operatorID;
    private String operatorName;
    private String operatorGender;

    public Operator(String operatorID, String operatorName, String operatorGender) {
        this.operatorID = operatorID;
        this.operatorName = operatorName;
        this.operatorGender = operatorGender;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorGender() {
        return operatorGender;
    }

    public void setOperatorGender(String operatorGender) {
        this.operatorGender = operatorGender;
    }
    
}
