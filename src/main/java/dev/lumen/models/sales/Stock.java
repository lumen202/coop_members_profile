package dev.lumen.models.sales;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXDoubleProperty;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class Stock extends FXModel {

    private FXIntegerProperty stockID;
    private FXStringProperty description;
    private FXDoubleProperty unitPrice;
    private FXDoubleProperty sellingPrice;
    private FXDoubleProperty quantity;
    private FXStringProperty unit;
    private FXIntegerProperty criticalLevel;

    public Stock() {

    }

    public Stock(int stockId, String description, double unitPrice, double sellingPrice, double quantity, String unit,
            int criticalLevel) {
        this.stockID = new FXIntegerProperty(stockId);
        this.description = new FXStringProperty(description);
        this.unitPrice = new FXDoubleProperty(unitPrice);
        this.sellingPrice = new FXDoubleProperty(sellingPrice);
        this.quantity = new FXDoubleProperty(quantity);
        this.unit = new FXStringProperty(unit);
        this.criticalLevel = new FXIntegerProperty(criticalLevel);

    }

    public FXIntegerProperty stockIDProperty() {
        return this.stockID;
    }

    public int getStockId() {
        return this.stockIDProperty().get();
    }

    public void setStockId(int stockId) {
        stockIDProperty().set(stockId);
    }

    public FXStringProperty descriptionProperty() {
        return this.description;
    }

    public String getDescrption() {
        return this.descriptionProperty().get();
    }

    public void setDescription(String description) {
        descriptionProperty().set(getDescrption());
    }

    public FXDoubleProperty unitPriceProperty() {
        return this.unitPrice;
    }

    public double getUnitPrice() {
        return this.unitPriceProperty().get();
    }

    public void setUnitPrice(double unitPrice) {
        unitPriceProperty().set(getStockId());
    }

    public FXDoubleProperty sellingPriceProperty() {
        return this.sellingPrice;
    }

    public double getSellingPrice() {
        return this.sellingPriceProperty().get();
    }

    public void setSellingPrice(double sellingPrice) {
        sellingPriceProperty().set(sellingPrice);
    }

    public FXDoubleProperty quantityProperty() {
        return this.quantity;
    }

    public double getQuantity() {
        return this.quantityProperty().get();
    }

    public void setQuantity(double quantity) {
        quantityProperty().set(quantity);
    }

    public FXStringProperty unitProperty() {
        return this.unit;
    }

    public String getUnit() {
        return this.unitProperty().get();
    }

    public void setUnit(String unit) {
        unitProperty().set(unit);
    }

    public FXIntegerProperty criticalLevelProperty() {
        return this.criticalLevel;
    }

    public int getCriticalLevel() {
        return this.criticalLevelProperty().get();
    }

    public void setCriticalLevel(int criticalLevel) {
        criticalLevelProperty().set(getCriticalLevel());
    }

    @Override
    public FXModel clone() {
        Stock stock = new Stock(
                getStockId(),
                getDescrption(),
                getUnitPrice(),
                getSellingPrice(),
                getQuantity(),
                getUnit(),
                getCriticalLevel());
        return stock;
    }

    @Override
    public void copy(FXModel arg0) {
        if (!(arg0 instanceof Stock)) {
            throw new IllegalArgumentException("Invalid type: Expected Stock instance.");
        }

        Stock c = (Stock) arg0;

        setStockId(c.getStockId());
        setDescription(c.getDescrption());
        setUnitPrice(c.getUnitPrice());
        setSellingPrice(c.getSellingPrice());
        setQuantity(c.getQuantity());
        setUnit(c.getUnit());
        setCriticalLevel(c.getCriticalLevel());
    }

}
