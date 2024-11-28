package dev.lumen.app;

import dev.lumen.App;
import dev.lumen.data.MemberDAO;
import dev.lumen.models.Member;
import dev.sol.core.application.FXController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RootController extends FXController {

    @FXML
    private TextField firstNameField;
    @FXML
    TextField middleNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField idField;
    @FXML
    private TextField birthDateField;
    @FXML
    private TextField placeOfBirthFIeld;
    @FXML
    private TextField currentAddressField;
    @FXML
    private ComboBox<String> statusfield;
    @FXML
    private TextField relationshiFIeld;
    @FXML
    private TextField occupationField;
    @FXML
    private ComboBox<Integer> officeField;
    @FXML
    private TextField salaryfield;
    @FXML
    private TextField incomeField;
    @FXML
    private TextField relativeField;
    @FXML
    private TextField dependentField;
    @FXML
    private TextField stockshareField;
    @FXML
    private TextField stockPaidField;
    @FXML
    private TextField stockamountField;
    @FXML
    private TextField amountpaidField;

    @FXML
    private TableView<Member> memberTable;

    @FXML
    private TableColumn<Member, String> firstNameColumn;
    @FXML
    private TableColumn<Member, String> lastNameColumn;
    @FXML
    private TableColumn<Member, Double> amountPaidColumn;
    @FXML
    private TableColumn<Member, Integer> memberIDColumn;

    private ObservableList<Member> memberMasterList;
    Scene scene;

    @FXML
    private void handleRefresh() {
        memberTable.refresh();
    }

    @FXML
    private void handleDelete() {
        Member selectedMember = memberTable.getSelectionModel().getSelectedItem();
        if (selectedMember == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Member Removal Error");
            alert.setHeaderText("Null Selection Error!");
            alert.setContentText("No member selected. Must select an employee to delete");
            alert.initOwner(scene.getWindow());
            alert.show();
            return;
        }
        memberMasterList.remove(selectedMember);
        MemberDAO.delete(selectedMember);
    }

    @FXML
    public void handleUpdate() {
        Member selectedMember = memberTable.getSelectionModel().getSelectedItem();

        selectedMember.setFirstName(firstNameField.getText());
        selectedMember.setLastName(lastNameField.getText());
        selectedMember.setMiddleName(middleNameField.getText());
        selectedMember.setDateOfBirth(birthDateField.getText());
        selectedMember.setPlaceOfBirth(placeOfBirthFIeld.getText());
        selectedMember.setCurrentAddress(currentAddressField.getText());
        selectedMember.setOccupation(occupationField.getText());
        selectedMember.setOfficeID(officeField.getValue());
        selectedMember.setStatus(Integer.parseInt(statusfield.getValue()));
        selectedMember.setSalary(Double.parseDouble(salaryfield.getText()));
        selectedMember.setIncome(incomeField.getText());
        selectedMember.setRelative(relationshiFIeld.getText());
        selectedMember.setDependent(dependentField.getText());
        selectedMember.setStockshare(Integer.parseInt(stockshareField.getText()));
        selectedMember.setStockpaid(Integer.parseInt(stockPaidField.getText()));
        selectedMember.setStockamount(Double.parseDouble(stockamountField.getText()));
        selectedMember.setAmountPaid(Double.parseDouble(stockPaidField.getText()));
        MemberDAO.update(selectedMember);

    }

    @FXML
    void handleEdit() {

        Member selectedMember = memberTable.getSelectionModel().getSelectedItem();
        if (selectedMember == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Edit Member Error");
            alert.setHeaderText("Null Selection Error!");
            alert.setContentText("No member selected. Must select an employee to edit");
            alert.initOwner(scene.getWindow());
            alert.show();
            return;
        } else {

            firstNameField.setEditable(true);
            middleNameField.setEditable(true);
            lastNameField.setEditable(true);
            birthDateField.setEditable(true);
            placeOfBirthFIeld.setEditable(true);
            currentAddressField.setEditable(true);
            occupationField.setEditable(true);
            officeField.setEditable(true);
            statusfield.setEditable(true);
            salaryfield.setEditable(true);
            incomeField.setEditable(true);
            relativeField.setEditable(true);
            relationshiFIeld.setEditable(true);
            dependentField.setEditable(true);
            stockshareField.setEditable(true);
            stockPaidField.setEditable(true);
            stockamountField.setEditable(true);
            amountpaidField.setEditable(true);
        }

    }

    @Override
    protected void load_fields() {

        memberMasterList = App.COLLECTIONS_REGISTRY.getList("MEMBER");
        scene = (Scene) getParameter("SCENE");

        amountPaidColumn
                .setCellValueFactory(cell -> cell.getValue().amountPaidProperty().asObject());
        memberIDColumn
                .setCellValueFactory(cell -> cell.getValue().memberIDProperty().asObject());
        firstNameColumn.setCellValueFactory(cell -> cell.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cell -> cell.getValue().lastNameProperty());

        memberTable.setItems(memberMasterList);
        memberTable.getSelectionModel().selectedItemProperty().addListener((o, ov, nv) -> {
            if (nv != null) {
                idField.setText(String.valueOf(nv.getMemberID()));
                firstNameField.setText(nv.getFirstName());
                middleNameField.setText(nv.getMiddleName());
                lastNameField.setText(nv.getLastName());
                birthDateField.setText(nv.getDateOfBirth());
                placeOfBirthFIeld.setText(nv.getPlaceOfBirth());
                currentAddressField.setText(nv.getCurrentAddress());
                occupationField.setText(nv.getOccupation());
                officeField.setValue(nv.getOfficeID());
                statusfield.setValue(String.valueOf(nv.getStatus()));
                salaryfield.setText(String.valueOf(nv.getSalary()));
                incomeField.setText(nv.getIncome());
                relativeField.setText(nv.relationshipProperty().get());
                relationshiFIeld.setText(nv.getRelationship());
                dependentField.setText(nv.getDependent());
                stockshareField.setText(String.valueOf(nv.getStockshare()));
                stockPaidField.setText(String.valueOf(nv.getStockpaid()));
                stockamountField.setText(String.valueOf(nv.getStockamount()));
                amountpaidField.setText(String.valueOf(nv.getAmountPaid()));
            } else {
                idField.setText("");
                firstNameField.setText("");
                middleNameField.setText("");
                lastNameField.setText("");
                birthDateField.setText("");
                placeOfBirthFIeld.setText("");
                currentAddressField.setText("");
                occupationField.setText("");
                officeField.setValue(null);
                statusfield.setValue("");
                salaryfield.setText("");
                incomeField.setText("");
                relativeField.setText("");
                relationshiFIeld.setText("");
                dependentField.setText("");
                stockshareField.setText("");
                stockPaidField.setText("");
                stockamountField.setText("");
                amountpaidField.setText("");
            }

        });

        ContextMenu menu = new ContextMenu();

        MenuItem deleteMenu = new MenuItem("Remove Member");
        deleteMenu.setOnAction(e -> {
            handleDelete();
        });

        MenuItem editMenu = new MenuItem("Edit Member");
        editMenu.setOnAction(e -> {
            handleEdit();
        });

        menu.getItems().add(deleteMenu);
        menu.getItems().add(editMenu);
        memberTable.setContextMenu(menu);

    }

    @Override
    protected void load_bindings() {

    }

    @Override
    protected void load_listeners() {

    }

}
