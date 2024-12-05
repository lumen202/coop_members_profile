package dev.lumen.models.sales;

import dev.lumen.models.people.User;
import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXDoubleProperty;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXObjectProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class DeliveryReciept extends FXModel {

    private FXIntegerProperty DRID;
    private FXStringProperty DRnum;
    private FXObjectProperty<Supplier> supplierID;
    private FXIntegerProperty deliveryDate;
    private FXDoubleProperty totalAmount;
    private FXDoubleProperty paidAmount;
    private FXObjectProperty<User> userID;

    public DeliveryReciept() {

    }

    public DeliveryReciept(int DRID, String DRnum, Supplier supplierID, int deliveryDate, double totalAmount,
            double paidAmount, User userID) {
        this.DRID = new FXIntegerProperty(DRID);
        this.DRnum = new FXStringProperty(DRnum);
        this.supplierID = new FXObjectProperty<Supplier>(supplierID);
        this.deliveryDate = new FXIntegerProperty(deliveryDate);
        this.totalAmount = new FXDoubleProperty(totalAmount);
        this.paidAmount = new FXDoubleProperty(paidAmount);
        this.userID = new FXObjectProperty<User>(userID);

    }

    // DRID
    public FXIntegerProperty DRIDProperty() {
        return this.DRID;
    }

    public int getDRID() {
        return this.DRIDProperty().get();
    }

    public void setDRID(int DRID) {
        this.DRIDProperty().set(DRID);
    }

    // DRnum
    public FXStringProperty DRnumProperty() {
        return this.DRnum;
    }

    public String getDRnum() {
        return this.DRnumProperty().get();
    }

    public void setDRnum(String DRnum) {
        this.DRnumProperty().set(DRnum);
    }

    // supplierID
    public FXObjectProperty<Supplier> supplierIDProperty() {
        return this.supplierID;
    }

    public Supplier getSupplierID() {
        return this.supplierIDProperty().get();
    }

    public void setSupplierID(Supplier supplierID) {
        this.supplierIDProperty().set(supplierID);
    }

    // deliveryDate
    public FXIntegerProperty deliveryDateProperty() {
        return this.deliveryDate;
    }

    public int getDeliveryDate() {
        return this.deliveryDateProperty().get();
    }

    public void setDeliveryDate(int deliveryDate) {
        this.deliveryDateProperty().set(deliveryDate);
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

    // paidAmount
    public FXDoubleProperty paidAmountProperty() {
        return this.paidAmount;
    }

    public double getPaidAmount() {
        return this.paidAmountProperty().get();
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmountProperty().set(paidAmount);
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

    @Override
    public FXModel clone() {
        DeliveryReciept deliveryReciept = new DeliveryReciept(
                getDRID(),
                getDRnum(),
                getSupplierID(),
                getDeliveryDate(),
                getTotalAmount(),
                getPaidAmount(),
                getUserID());
        return deliveryReciept;
    }

    @Override
    public void copy(FXModel arg0) {
        if (!(arg0 instanceof DeliveryReciept)) {
            throw new IllegalArgumentException("Invalid type: Expected DeliveryReciept instance.");
        }

        DeliveryReciept c = (DeliveryReciept) arg0;

        setDRID(c.getDRID());
        setDRnum(c.getDRnum());
        setSupplierID(c.getSupplierID());
        setDeliveryDate(c.getDeliveryDate());
        setTotalAmount(c.getTotalAmount());
        setPaidAmount(c.getPaidAmount());
        setUserID(c.getUserID());
    }

}
