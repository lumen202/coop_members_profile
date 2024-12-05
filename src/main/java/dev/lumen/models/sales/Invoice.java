package dev.lumen.models.sales;

import java.lang.reflect.Member;
import java.time.LocalDate;

import dev.lumen.models.people.User;
import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXDoubleProperty;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXObjectProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class Invoice extends FXModel {

    private FXIntegerProperty salesID;
    private FXStringProperty invoiceNum;
    private FXDoubleProperty totalAmount;
    private FXObjectProperty<Member> memberID;
    private FXObjectProperty<User> userID;
    private FXObjectProperty<LocalDate> date;

    public Invoice(int salesID, String invoiceNum, double totalAmount, Member memberID, User userID, LocalDate date) {
        this.salesID = new FXIntegerProperty(salesID);
        this.invoiceNum = new FXStringProperty(invoiceNum);
        this.totalAmount = new FXDoubleProperty(totalAmount);
        this.memberID = new FXObjectProperty<>(memberID);
        this.userID = new FXObjectProperty<>(userID);
        this.date = new FXObjectProperty<>(date);
    }

    // salesID
    public FXIntegerProperty salesIDProperty() {
        return this.salesID;
    }

    public int getSalesID() {
        return this.salesIDProperty().get();
    }

    public void setSalesID(int salesID) {
        this.salesIDProperty().set(salesID);
    }

    // invoiceNum
    public FXStringProperty invoiceNumProperty() {
        return this.invoiceNum;
    }

    public String getInvoiceNum() {
        return this.invoiceNumProperty().get();
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNumProperty().set(invoiceNum);
    }

    // totalAmount
    public FXDoubleProperty totalAmountProperty() {
        return this.totalAmount;
    }

    public double getTotalAmount() {
        return this.totalAmountProperty().get();
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmountProperty().set(totalAmount);
    }

    // memberID
    public FXObjectProperty<Member> memberIDProperty() {
        return this.memberID;
    }

    public Member getMemberID() {
        return this.memberIDProperty().get();
    }

    public void setMemberID(Member memberID) {
        this.memberIDProperty().set(memberID);
    }

    // userID
    public FXObjectProperty<User> userIDProperty() {
        return this.userID;
    }

    public User getUserID() {
        return this.userIDProperty().get();
    }

    public void setUserID(User userID) {
        this.userIDProperty().set(userID);
    }

    // date
    public FXObjectProperty<LocalDate> dateProperty() {
        return this.date;
    }

    public LocalDate getDate() {
        return this.dateProperty().get();
    }

    public void setDate(LocalDate date) {
        this.dateProperty().set(date);
    }

    @Override
    public FXModel clone() {

        Invoice invoice = new Invoice(
                getSalesID(),
                getInvoiceNum(),
                getTotalAmount(),
                getMemberID(),
                getUserID(),
                getDate());
        return invoice;
    }

    @Override
    public void copy(FXModel arg0) {
        if (!(arg0 instanceof Invoice)) {
            throw new IllegalArgumentException("Invalid type: Expected Invoice instance.");
        }

        Invoice c = (Invoice) arg0;
        setSalesID(c.getSalesID());
        setInvoiceNum(c.getInvoiceNum());
        setTotalAmount(c.getTotalAmount());
        setMemberID(c.getMemberID());
        setUserID(c.getUserID());
        setDate(c.getDate());
    }

}
