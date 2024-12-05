package dev.lumen.models.sales;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXDoubleProperty;
import dev.sol.core.properties.beans.FXObjectProperty;

public class DeliveryItems extends FXModel {

    private FXObjectProperty<DeliveryReciept> DRID;
    private FXObjectProperty<Stock> stockID;
    private FXDoubleProperty buyingPrice;
    private FXDoubleProperty qty;
    private FXDoubleProperty amount;

    public DeliveryItems(DeliveryReciept DRID, Stock stockID, double buyingPrice, double qty, double amount) {
        this.DRID = new FXObjectProperty<DeliveryReciept>(DRID);
        this.stockID = new FXObjectProperty<>(stockID);
        this.buyingPrice = new FXDoubleProperty(buyingPrice);
        this.qty = new FXDoubleProperty(qty);
        this.amount = new FXDoubleProperty(amount);
    }

    // DRID
    public FXObjectProperty<DeliveryReciept> DRIDProperty() {
        return this.DRID;
    }

    public DeliveryReciept getDRID() {
        return this.DRIDProperty().get();
    }

    public void setDRID(DeliveryReciept DRID) {
        DRIDProperty().set(DRID);
    }

    // stockID
    public FXObjectProperty<Stock> stockIDProperty() {
        return this.stockID;
    }

    public Stock getStockID() {
        return this.stockIDProperty().get();
    }

    public void setStockID(Stock stockID) {
        stockIDProperty().set(stockID);
    }

    // buyingPrice
    public FXDoubleProperty buyingPriceProperty() {
        return this.buyingPrice;
    }

    public double getBuyingPrice() {
        return this.buyingPriceProperty().get();
    }

    public void setBuyingPrice(double buyingPrice) {
        buyingPriceProperty().set(buyingPrice);
    }

    // qty
    public FXDoubleProperty qtyProperty() {
        return this.qty;
    }

    public double getQty() {
        return this.qtyProperty().get();
    }

    public void setQty(double qty) {
        qtyProperty().set(qty);
    }

    // amount
    public FXDoubleProperty amountProperty() {
        return this.amount;
    }

    public double getAmount() {
        return this.amountProperty().get();
    }

    public void setAmount(double amount) {
        amountProperty().set(amount);
    }

    @Override
    public FXModel clone() {
        DeliveryItems deliveryItems = new DeliveryItems(
                getDRID(), // Clone the DeliveryReceipt reference
                getStockID(), // Clone the Stock reference
                getBuyingPrice(),
                getQty(),
                getAmount());
        return deliveryItems;
    }

    @Override
    public void copy(FXModel arg0) {
        if (!(arg0 instanceof DeliveryItems)) {
            throw new IllegalArgumentException("Invalid type: Expected DeliveryItems instance.");
        }

        DeliveryItems c = (DeliveryItems) arg0;

        setDRID(c.getDRID());
        setStockID(c.getStockID());
        setBuyingPrice(c.getBuyingPrice());
        setQty(c.getQty());
        setAmount(c.getAmount());
    }

}
