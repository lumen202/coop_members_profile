package dev.lumen.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dev.lumen.App;
import dev.lumen.app.memberform.MemberFormLoader;
import dev.lumen.data.people.MemberDAO;
import dev.lumen.enums.Office;
import dev.lumen.enums.Status;
import dev.lumen.models.people.Member;
import dev.sol.core.application.FXController;
import dev.sol.core.application.loader.FXLoaderFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RootController extends FXController {

    @FXML
    private DatePicker dateOfBirth;

    @FXML
    private TextField firstNameField;
    @FXML
    TextField middleNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField idField;
    @FXML
    private TextField placeOfBirthFIeld;
    @FXML
    private TextField currentAddressField;
    @FXML
    private ComboBox<String> statusfield;
    @FXML
    private TextField relationshipField;
    @FXML
    private TextField occupationField;
    @FXML
    private ComboBox<String> officeField;
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
    TextField genderField;
    @FXML
    Button cancelButton;
    
    
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

    private ObservableList<String> office;
    private ObservableList<String> status;
    private ObservableList<Member> memberMasterList;
    Scene scene;
    private int event = 0;

    @FXML
    void handleOK() {

    }

    @FXML
    private void handleCancel() {

        ObservableList<Member> orginalValue = FXCollections.observableArrayList(memberMasterList);
        memberTable.setItems(orginalValue);
        cancelButton.setVisible(false);
        setEditable(false);

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
    void handleAdd() {
        int officeID = officeField.getSelectionModel().getSelectedIndex() + 1;
        int status = statusfield.getSelectionModel().getSelectedIndex() + 1;

        LocalDate date = dateOfBirth.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = date.format(formatter);

        int memberID = memberMasterList.size() + 1;
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String middleName = middleNameField.getText();
        String dateOfBirth = dateString;
        String placeOfBirth = placeOfBirthFIeld.getText();
        String currentAddress = currentAddressField.getText();
        String realtionship = relationshipField.getText();
        String occupation = occupationField.getText();

        double salary = Double.parseDouble(salaryfield.getText());
        String income = incomeField.getText();
        String relative = relativeField.getText();
        String dependent = dependentField.getText();
        int stockshare = Integer.parseInt(stockshareField.getText());
        int stockpaid = Integer.parseInt(stockPaidField.getText());
        double stockamount = Double.parseDouble(stockamountField.getText());
        double amountPaid = Double.parseDouble(amountpaidField.getText());
        String sex = genderField.getText();

        Member member = new Member(memberID,
                firstName,
                lastName,
                amountPaid,
                realtionship,
                middleName,
                dateOfBirth,
                placeOfBirth,
                status,
                currentAddress,
                occupation,
                officeID,
                salary,
                income,
                relative,
                dependent,
                stockshare,
                stockamount, stockpaid, sex);
        memberMasterList.add(member);
        MemberDAO.insert(member);
        setEditable(false);

    }

    @FXML
    public void handleUpdate() {
        Member selectedMember = memberTable.getSelectionModel().getSelectedItem();
        if (selectedMember == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Edit Member Error");
            alert.setHeaderText("Null Selection Error!");
            alert.setContentText("No member selected. Must select an employee to edit");
            alert.initOwner(scene.getWindow());
            alert.show();
            return;
        }

        LocalDate date = dateOfBirth.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = date.format(formatter);

        selectedMember.setDateOfBirth(dateString);

        selectedMember.setFirstName(firstNameField.getText());
        selectedMember.setLastName(lastNameField.getText());
        selectedMember.setMiddleName(middleNameField.getText());
        selectedMember.setPlaceOfBirth(placeOfBirthFIeld.getText());
        selectedMember.setRelationShip(relationshipField.getText());
        selectedMember.setCurrentAddress(currentAddressField.getText());
        selectedMember.setOccupation(occupationField.getText());
        selectedMember.setOfficeID(officeField.getSelectionModel().getSelectedIndex()
                + 1);
        selectedMember.setStatus(statusfield.getSelectionModel().getSelectedIndex() +
                1);
        selectedMember.setSalary(Double.parseDouble(salaryfield.getText()));
        selectedMember.setIncome(incomeField.getText());
        selectedMember.setRelative(relativeField.getText());
        selectedMember.setDependent(dependentField.getText());
        selectedMember.setStockshare(Integer.parseInt(stockshareField.getText()));
        selectedMember.setStockpaid(Integer.parseInt(stockPaidField.getText()));
        selectedMember.setStockamount(Double.parseDouble(stockamountField.getText()));
        selectedMember.setAmountPaid(Double.parseDouble(amountpaidField.getText()));
        selectedMember.setSex(genderField.getText());

        MemberDAO.update(selectedMember);
        setEditable(false);

    }

    @FXML
    void handleEdit() {

        setEditable(true);
        cancelButton.setVisible(true);

    }

    @Override
    protected void load_fields() {

        memberMasterList = App.COLLECTIONS_REGISTRY.getList("MEMBER");
        scene = (Scene) getParameter("SCENE");

        office = FXCollections.observableArrayList(Office.HEAD_OFFICE.getDisplay(),
                Office.BRANCH_OFFICE.getDisplay(), Office.SUPPORT_OFFICE.getDisplay());
        status = FXCollections.observableArrayList(Status.SINGLE.getDisplay(),
                Status.MARRIED.getDisplay(),
                Status.WIDOW.getDisplay(), Status.WIDOWER.getDisplay());

        amountPaidColumn
                .setCellValueFactory(cell -> cell.getValue().amountPaidProperty().asObject());
        memberIDColumn
                .setCellValueFactory(cell -> cell.getValue().memberIDProperty().asObject());
        firstNameColumn.setCellValueFactory(cell -> cell.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cell -> cell.getValue().lastNameProperty());

        memberTable.setItems(memberMasterList);
        memberTable.getSelectionModel().selectedItemProperty().addListener((o, ov, nv) -> {
            if (nv != null) {
                String dateString = nv.getDateOfBirth();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(dateString, formatter);

                dateOfBirth.setValue(date);

                idField.setText(String.valueOf(nv.getMemberID()));
                firstNameField.setText(nv.getFirstName());
                middleNameField.setText(nv.getMiddleName());
                lastNameField.setText(nv.getLastName());
                placeOfBirthFIeld.setText(nv.getPlaceOfBirth());
                currentAddressField.setText(nv.getCurrentAddress());
                occupationField.setText(nv.getOccupation());

                Office officeID = Office.fromCode(nv.getOfficeID());
                officeField.setValue(officeID.getDisplay());

                Status statusDisplay = Status.fromCode(nv.getStatus());
                statusfield.setValue(statusDisplay.getDisplay());

                salaryfield.setText(String.valueOf(nv.getSalary()));
                incomeField.setText(nv.getIncome());
                relativeField.setText(nv.relativeProperty().get());
                relationshipField.setText(nv.getRelationship());
                dependentField.setText(nv.getDependent());
                stockshareField.setText(String.valueOf(nv.getStockshare()));
                stockPaidField.setText(String.valueOf(nv.getStockpaid()));
                stockamountField.setText(String.valueOf(nv.getStockamount()));
                amountpaidField.setText(String.valueOf(nv.getAmountPaid()));
                genderField.setText(nv.getSex());
            } else {
                idField.setText("");
                firstNameField.setText("");
                middleNameField.setText("");
                lastNameField.setText("");
                dateOfBirth.setValue(null);
                placeOfBirthFIeld.setText("");
                currentAddressField.setText("");
                occupationField.setText("");
                officeField.setValue(null);
                statusfield.setValue("");
                salaryfield.setText("");
                incomeField.setText("");
                relativeField.setText("");
                relationshipField.setText("");
                dependentField.setText("");
                stockshareField.setText("");
                stockPaidField.setText("");
                stockamountField.setText("");
                amountpaidField.setText("");
                genderField.setText("");
            }

        });

        ContextMenu menu = new ContextMenu();

        MenuItem deleteMenu = new MenuItem("Remove Member");
        deleteMenu.setOnAction(e -> {
            handleDelete();
        });

        MenuItem editMenu = new MenuItem("Edit Member");
        editMenu.setOnAction(e -> {
            event = 1;
            handleEdit();
            ;
        });

        MenuItem addMenu = new MenuItem("Add Member");
        addMenu.setOnAction(e -> {
            event = 2;
            memberTable.getSelectionModel().select(null);
            addMember();

            // loadForm();
        });

        menu.getItems().add(deleteMenu);
        menu.getItems().add(editMenu);
        menu.getItems().add(addMenu);
        memberTable.setContextMenu(menu);

    }

    @Override
    protected void load_bindings() {

    }

    private void loadForm() {
        MemberFormLoader loader = (MemberFormLoader) FXLoaderFactory
                .createInstance(MemberFormLoader.class,
                        getClass().getResource("/dev/lumen/app/memberform/MEMBER_FORM.fxml"))
                .initialize();
        loader.load();
    }

    @Override
    protected void load_listeners() {
        cancelButton.setVisible(false);
    }

    private void addMember() {

        setEditable(true);
        cancelButton.setVisible(true);
        int id = memberMasterList.size() + 1;
        idField.setText(String.valueOf(id));
        firstNameField.clear();
        middleNameField.clear();
        lastNameField.clear();
        dateOfBirth.setValue(LocalDate.now());
        placeOfBirthFIeld.clear();
        currentAddressField.clear();
        occupationField.clear();
        salaryfield.clear();
        incomeField.clear();
        relativeField.clear();
        relationshipField.clear();
        dependentField.clear();
        stockshareField.clear();
        stockPaidField.clear();
        stockamountField.clear();
        amountpaidField.clear();
        genderField.clear();

    }

    private void setEditable(Boolean toggle) {

        firstNameField.setEditable(toggle);
        middleNameField.setEditable(toggle);
        lastNameField.setEditable(toggle);
        dateOfBirth.setEditable(toggle);
        placeOfBirthFIeld.setEditable(toggle);
        currentAddressField.setEditable(toggle);
        occupationField.setEditable(toggle);
        salaryfield.setEditable(toggle);
        incomeField.setEditable(toggle);
        relativeField.setEditable(toggle);
        relationshipField.setEditable(toggle);
        dependentField.setEditable(toggle);
        stockshareField.setEditable(toggle);
        stockPaidField.setEditable(toggle);
        stockamountField.setEditable(toggle);
        amountpaidField.setEditable(toggle);
        genderField.setEditable(toggle);
        officeField.setItems(office);
        statusfield.setItems(status);

    }

}
