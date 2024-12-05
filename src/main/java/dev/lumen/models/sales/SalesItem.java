package dev.lumen.models.sales;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXDoubleProperty;
import dev.sol.core.properties.beans.FXObjectProperty;

public class SalesItem extends FXModel {
    private FXObjectProperty<Invoice> salesID;
    private FXObjectProperty<Stock> stockID;
    private FXDoubleProperty quantity;
    private FXDoubleProperty amount;

    public SalesItem(Invoice salesID, Stock stockID, double quantity, double amount) {
        this.salesID = new FXObjectProperty<>(salesID);
        this.stockID = new FXObjectProperty<>(stockID);
        this.quantity = new FXDoubleProperty(quantity);
        this.amount = new FXDoubleProperty(amount);
    }

    // salesID
    public FXObjectProperty<Invoice> salesIDProperty() {
        return this.salesID;
    }

    public Invoice getSalesID() {
        return this.salesIDProperty().get();
    }

    public void setSalesID(Invoice salesID) {
        this.salesIDProperty().set(salesID);
    }

    // stockID
    public FXObjectProperty<Stock> stockIDProperty() {
        return this.stockID;
    }

    public Stock getStockID() {
        return this.stockIDProperty().get();
    }

    public void setStockID(Stock stockID) {
        this.stockIDProperty().set(stockID);
    }

    // quantity
    public FXDoubleProperty quantityProperty() {
        return this.quantity;
    }

    public double getQuantity() {
        return this.quantityProperty().get();
    }

    public void setQuantity(double quantity) {
        this.quantityProperty().set(quantity);
    }

    // amount
    public FXDoubleProperty amountProperty() {
        return this.amount;
    }

    public double getAmount() {
        return this.amountProperty().get();
    }

    public void setAmount(double amount) {
        this.amountProperty().set(amount);
    }

    @Override
    public FXModel clone() {
        SalesItem salesItem = new SalesItem(
                getSalesID(),
                getStockID(),
                getQuantity(),
                getAmount());
        return salesItem;
    }

    @Override
    public void copy(FXModel arg0) {
        if (!(arg0 instanceof SalesItem)) {
            throw new IllegalArgumentException("Invalid type: Expected SalesItem instance.");
        }
        SalesItem c = (SalesItem) arg0;

        setSalesID(c.getSalesID());
        setStockID(c.getStockID());
        setQuantity(c.getQuantity());
        setAmount(c.getAmount());
    }

}
