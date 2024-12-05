package dev.lumen.models.sales;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class Supplier extends FXModel {

    private FXIntegerProperty supplierID;
    private FXStringProperty supplierName;
    private FXStringProperty address;

    public Supplier() {

    }

    public Supplier(int supplierID, String supplierName, String address) {
        this.supplierID = new FXIntegerProperty(supplierID);
        this.supplierName = new FXStringProperty(supplierName);
        this.address = new FXStringProperty(address);
    }

    public FXIntegerProperty supplierIDProperty() {
        return this.supplierID;
    }

    public int getSupplierID() {
        return this.supplierIDProperty().get();
    }

    public void setSupplierID(int supplierID) {
        supplierIDProperty().set(supplierID);
    }

    public FXStringProperty supplierNameProperty() {
        return this.supplierName;
    }

    public String getSupplierName() {
        return this.supplierNameProperty().get();
    }

    public void setSupplierName(String supplierName) {
        supplierNameProperty().set(supplierName);
    }

    public FXStringProperty addressProperty() {
        return this.address;
    }

    public String getAddress() {
        return this.addressProperty().get();
    }

    public void setAddress(String address) {
        addressProperty().set(address);
    }

    @Override
    public FXModel clone() {
        return new Supplier(
                getSupplierID(),
                getSupplierName(),
                getAddress());
    }

    @Override
    public void copy(FXModel arg0) {
        if (!(arg0 instanceof Supplier)) {
            throw new IllegalArgumentException("Invalid type: Expected Supplier instance.");
        }

        Supplier c = (Supplier) arg0;

        setSupplierID(c.getSupplierID());
        setSupplierName(c.getSupplierName());
        setAddress(c.getAddress());
    }
}
