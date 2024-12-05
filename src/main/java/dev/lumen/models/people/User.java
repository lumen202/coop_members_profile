package dev.lumen.models.people;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXDoubleProperty;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class User extends FXModel {
    private FXIntegerProperty userID;
    private FXStringProperty username;
    private FXStringProperty designation;
    private FXStringProperty Fname;
    private FXStringProperty Mname;
    private FXStringProperty Lname;
    private FXStringProperty address;
    private FXStringProperty password;
    private FXDoubleProperty salary;

    public User() {

    }

    public User(int userID, String username, String designation, String Fname, String Mname, String Lname,
            String address, String password, double salary) {
        this.userID = new FXIntegerProperty(userID);
        this.username = new FXStringProperty(username);
        this.designation = new FXStringProperty(designation);
        this.Fname = new FXStringProperty(Fname);
        this.Mname = new FXStringProperty(Mname);
        this.Lname = new FXStringProperty(Lname);
        this.address = new FXStringProperty(address);
        this.password = new FXStringProperty(password);
        this.salary = new FXDoubleProperty(salary);
    }

    // userID
    public FXIntegerProperty userIDProperty() {
        return this.userID;
    }

    public int getUserID() {
        return this.userIDProperty().get();
    }

    public void setUserID(int userID) {
        userIDProperty().set(userID);
    }

    // username
    public FXStringProperty usernameProperty() {
        return this.username;
    }

    public String getUsername() {
        return this.usernameProperty().get();
    }

    public void setUsername(String username) {
        usernameProperty().set(username);
    }

    // designation
    public FXStringProperty designationProperty() {
        return this.designation;
    }

    public String getDesignation() {
        return this.designationProperty().get();
    }

    public void setDesignation(String designation) {
        designationProperty().set(designation);
    }

    // Fname
    public FXStringProperty FnameProperty() {
        return this.Fname;
    }

    public String getFname() {
        return this.FnameProperty().get();
    }

    public void setFname(String Fname) {
        FnameProperty().set(Fname);
    }

    // Mname
    public FXStringProperty MnameProperty() {
        return this.Mname;
    }

    public String getMname() {
        return this.MnameProperty().get();
    }

    public void setMname(String Mname) {
        MnameProperty().set(Mname);
    }

    // Lname
    public FXStringProperty LnameProperty() {
        return this.Lname;
    }

    public String getLname() {
        return this.LnameProperty().get();
    }

    public void setLname(String Lname) {
        LnameProperty().set(Lname);
    }

    // address
    public FXStringProperty addressProperty() {
        return this.address;
    }

    public String getAddress() {
        return this.addressProperty().get();
    }

    public void setAddress(String address) {
        addressProperty().set(address);
    }

    // password
    public FXStringProperty passwordProperty() {
        return this.password;
    }

    public String getPassword() {
        return this.passwordProperty().get();
    }

    public void setPassword(String password) {
        passwordProperty().set(password);
    }

    // salary
    public FXDoubleProperty salaryProperty() {
        return this.salary;
    }

    public double getSalary() {
        return this.salaryProperty().get();
    }

    public void setSalary(double salary) {
        salaryProperty().set(salary);
    }

    @Override
    public FXModel clone() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clone'");
    }

    @Override
    public void copy(FXModel arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'copy'");
    }

}
