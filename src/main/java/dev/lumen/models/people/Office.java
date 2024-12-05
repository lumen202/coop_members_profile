package dev.lumen.models.people;

import java.util.UUID;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class Office extends FXModel {
    private FXIntegerProperty officeID;
    private FXStringProperty name;

    public Office(int officeID, String name) {
        this.officeID = new FXIntegerProperty(officeID);
        this.name = new FXStringProperty(name);
        track_properties(this.name);
    }

    public FXStringProperty nameProperty() {
        return this.name;
    }

    public String getName() {
        return this.nameProperty().get();
    }

    public void setName(String name) {
        nameProperty().set(name);
    }

    private FXIntegerProperty officeIDProperty() {
        return this.officeID;
    }

    private int getOfficeID() {
        return officeIDProperty().get();
    }

    private void setOfficeID(int officeID) {
        officeIDProperty().set(officeID);
    }

    @Override
    public FXModel clone() {
        Office clonedOffice = new Office(getOfficeID(), getName());
        return clonedOffice;
    }

    @Override
    public void copy(FXModel arg0) {
        if (!(arg0 instanceof Office)) {
            throw new IllegalArgumentException("Invalid type: Expected Office instance.");
        }

        Office c = (Office) arg0;

        setName(c.getName());
        setOfficeID(c.getOfficeID());
    }

}
