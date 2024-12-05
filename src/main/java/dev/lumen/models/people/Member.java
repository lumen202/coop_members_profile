package dev.lumen.models.people;

import java.util.UUID;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXDoubleProperty;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class Member extends FXModel {

    private FXIntegerProperty memberID;
    private FXStringProperty firstName;
    private FXStringProperty lastName;
    private FXDoubleProperty amountPaid;
    private FXStringProperty relationship;
    private FXStringProperty middleName;
    private FXStringProperty dateOfBirth;
    private FXStringProperty placeOfBirth;
    private FXIntegerProperty status;
    private FXStringProperty currentAddress;
    private FXStringProperty occupation;
    private FXIntegerProperty officeID;
    private FXDoubleProperty salary;
    public FXStringProperty relative;
    public FXStringProperty depedent;
    public FXIntegerProperty stockshare;
    public FXDoubleProperty stockamount;
    public FXIntegerProperty stockpaid;
    public FXStringProperty income;
    public FXStringProperty sex;

    public Member() {
        // this(UUID.randomUUID().toString(),
        // "", "", "", "", getMiddleName(), getDateOfBirth(), getPlaceOfBirth(),
        // getStatus(), getCurrentAddress(), getOccupation(), getOfficeID(),
        // getSalary(), getIncome(), getRelative(), getDependent(), getStockshare(),
        // getStockamount(), getStockpaid(), getSex())
    }

    public Member(int memberID,
            String firstName,
            String lastName,
            double amountPaid,
            String realtionship,
            String middleName,
            String dateOfBirth,
            String placeOfBirth,
            int status,
            String currentAddress,
            String occupation,
            int officeID,
            double salary,
            String income,
            String relative,
            String dependent,
            int stockshare,
            double stockamount, int stockpaid, String sex) {
        this.memberID = new FXIntegerProperty(memberID);
        this.firstName = new FXStringProperty(firstName);
        this.lastName = new FXStringProperty(lastName);
        this.amountPaid = new FXDoubleProperty(amountPaid);
        this.relationship = new FXStringProperty(realtionship);
        this.middleName = new FXStringProperty(middleName);
        this.dateOfBirth = new FXStringProperty(dateOfBirth);
        this.placeOfBirth = new FXStringProperty(placeOfBirth);
        this.status = new FXIntegerProperty(status);
        this.currentAddress = new FXStringProperty(currentAddress);
        this.occupation = new FXStringProperty(occupation);
        this.officeID = new FXIntegerProperty(officeID);
        this.salary = new FXDoubleProperty(salary);
        this.relative = new FXStringProperty(relative);
        this.depedent = new FXStringProperty(dependent);
        this.stockamount = new FXDoubleProperty(stockamount);
        this.stockshare = new FXIntegerProperty(stockshare);
        this.stockpaid = new FXIntegerProperty(stockpaid);
        this.income = new FXStringProperty(income);
        this.sex = new FXStringProperty(sex);

    }

    public FXStringProperty sexProperty() {
        return this.sex;
    }

    public String getSex() {
        return this.sexProperty().get();
    }

    public void setSex(String sex) {
        sexProperty().set(sex);
    }

    public FXStringProperty incomeProperty() {
        return this.income;
    }

    public String getIncome() {
        return incomeProperty().get();
    }

    public void setIncome(String income) {
        incomeProperty().set(income);
    }

    public FXDoubleProperty salaryProperty() {
        return this.salary;
    }

    public double getSalary() {
        return salaryProperty().get();
    }

    public void setSalary(double salary) {
        salaryProperty().set(salary);
    }

    public FXStringProperty relativeProperty() {
        return this.relative;
    }

    public String getRelative() {
        return relativeProperty().get();
    }

    public void setRelative(String relative) {
        relativeProperty().set(relative);
    }

    public FXStringProperty dependentProperty() {
        return this.depedent;
    }

    public String getDependent() {
        return dependentProperty().get();
    }

    public void setDependent(String dependent) {
        dependentProperty().set(dependent);
    }

    public FXIntegerProperty stockshareProperty() {
        return this.stockshare;
    }

    public int getStockshare() {
        return stockshareProperty().get();
    }

    public void setStockshare(int stockshare) {
        stockshareProperty().set(stockshare);
    }

    public FXDoubleProperty stockamountProperty() {
        return this.stockamount;
    }

    public double getStockamount() {
        return stockamountProperty().get();
    }

    public void setStockamount(double stockamount) {
        stockamountProperty().set(stockamount);
    }

    public FXIntegerProperty stockpaidProperty() {
        return this.stockpaid;
    }

    public int getStockpaid() {
        return stockpaidProperty().get();
    }

    public void setStockpaid(int stockpaid) {
        stockpaidProperty().set(stockpaid);
    }

    public FXStringProperty occupationProperty() {
        return this.occupation;
    }

    public String getOccupation() {
        return occupationProperty().get();
    }

    public void setOccupation(String occupation) {
        occupationProperty().set(occupation);
    }

    public FXIntegerProperty officeIDProperty() {
        return this.officeID;
    }

    public int getOfficeID() {
        return officeIDProperty().get();
    }

    public void setOfficeID(int officeID) {
        officeIDProperty().set(officeID);
    }

    public FXStringProperty currentAddressProperty() {
        return this.currentAddress;
    }

    public String getCurrentAddress() {
        return currentAddressProperty().get();
    }

    public void setCurrentAddress(String currentAddress) {
        currentAddressProperty().set(currentAddress);
    }

    public FXStringProperty dateOfBirthProperty() {
        return this.dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirthProperty().get();
    }

    public void setDateOfBirth(String dateOfBirth) {
        dateOfBirthProperty().set(dateOfBirth);
    }

    public FXStringProperty placeOfBirthProperty() {
        return this.placeOfBirth;
    }

    public String getPlaceOfBirth() {
        return this.placeOfBirthProperty().get();
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        placeOfBirthProperty().set(placeOfBirth);
    }

    public FXIntegerProperty statusProperty() {
        return this.status;
    }

    public int getStatus() {
        return statusProperty().get();
    }

    public void setStatus(int status) {
        statusProperty().set(status);
    }

    public FXStringProperty middleNamProperty() {
        return this.middleName;
    }

    public String getMiddleName() {
        return middleNamProperty().get();
    }

    public void setMiddleName(String middleName) {
        middleNamProperty().set(middleName);
    }

    public FXStringProperty relationshipProperty() {
        return this.relationship;
    }

    public String getRelationship() {
        return relationshipProperty().get();
    }

    public void setRelationShip(String relationship) {
        relationshipProperty().set(relationship);
    }

    public FXIntegerProperty memberIDProperty() {
        return this.memberID;
    }

    public int getMemberID() {
        return memberIDProperty().get();
    }

    public void setMemberID(int memberID) {
        memberIDProperty().set(memberID);
    }

    public FXStringProperty firstNameProperty() {
        return this.firstName;
    }

    public String getFirstName() {
        return firstNameProperty().get();
    }

    public void setFirstName(String firstName) {
        firstNameProperty().set(firstName);
    }

    public FXStringProperty lastNameProperty() {
        return this.lastName;
    }

    public String getLastName() {
        return lastNameProperty().get();
    }

    public void setLastName(String lastName) {
        lastNameProperty().set(lastName);
    }

    public FXDoubleProperty amountPaidProperty() {
        return this.amountPaid;
    }

    public double getAmountPaid() {
        return amountPaidProperty().get();
    }

    public void setAmountPaid(double amountPaid) {
        amountPaidProperty().set(amountPaid);
    }

    @Override
    public FXModel clone() {
        Member members = new Member(getMemberID(),
                getFirstName(),
                getLastName(),
                getAmountPaid(),
                getRelationship(),
                getMiddleName(),
                getDateOfBirth(),
                getPlaceOfBirth(),
                getStatus(),
                getCurrentAddress(),
                getOccupation(),
                getOfficeID(),
                getSalary(),
                getIncome(),
                getRelative(),
                getDependent(),
                getStockshare(),
                getStockamount(),
                getStockpaid(), getSex());
        return members;
    }

    @Override
    public void copy(FXModel arg0) {
        Member c = (Member) arg0;

        setMemberID(c.getMemberID());
        setFirstName(c.getFirstName());
        setLastName(c.getLastName());
        setAmountPaid(c.getAmountPaid());
        setRelationShip(c.getRelationship());
        setMiddleName(c.getMiddleName());
        setDateOfBirth(c.getDateOfBirth());
        setPlaceOfBirth(c.getPlaceOfBirth());
        setStatus(c.getStatus());
        setCurrentAddress(c.getCurrentAddress());
        setOccupation(c.getOccupation());
        setOfficeID(c.getOfficeID());
        setSalary(c.getSalary());
        setRelative(c.getRelative());
        setDependent(c.getDependent());
        setStockshare(c.getStockshare());
        setStockamount(c.getStockamount());
        setStockpaid(c.getStockpaid());
        setSex(c.getSex());

    }

}
