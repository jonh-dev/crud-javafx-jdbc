package gui;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
<<<<<<< HEAD
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
=======
>>>>>>> 2a38bba79c0fb419407284b12e3c56e995120f94
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
<<<<<<< HEAD
import javafx.util.Callback;
import model.entities.Department;
import model.entities.Seller;
import model.exceptions.ValidationException;
import model.services.DepartmentService;
=======
import model.entities.Seller;
import model.exceptions.ValidationException;
>>>>>>> 2a38bba79c0fb419407284b12e3c56e995120f94
import model.services.SellerService;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class SellerFormController implements Initializable {

    private Seller entity;

    private SellerService service;

<<<<<<< HEAD
    private DepartmentService departmentService;

=======
>>>>>>> 2a38bba79c0fb419407284b12e3c56e995120f94
    private final List<DataChangeListener> dataChangeListeners = new ArrayList<>();

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private DatePicker dpBirthDate;

    @FXML
    private TextField txtBaseSalary;

    @FXML
<<<<<<< HEAD
    private ComboBox<Department> comboBoxDepartment;

    @FXML
=======
>>>>>>> 2a38bba79c0fb419407284b12e3c56e995120f94
    private Label labelErrorName;

    @FXML
    private Label labelErrorEmail;

    @FXML
    private Label labelErrorBirthDate;

    @FXML
    private Label labelErrorBaseSalary;

    @FXML
    private Button btSave;

    @FXML
    private Button btCancel;

<<<<<<< HEAD
    private ObservableList<Department> obsList;

=======
>>>>>>> 2a38bba79c0fb419407284b12e3c56e995120f94
    public void subscribeDataChangeListener(DataChangeListener listener){
        dataChangeListeners.add(listener);
    }

    public void setSeller(Seller entity){
        this.entity = entity;
    }

<<<<<<< HEAD
    public void setServices(SellerService service, DepartmentService departmentService){
        this.service = service;
        this.departmentService = departmentService;
=======
    public void setSellerService(SellerService service){
        this.service = service;
>>>>>>> 2a38bba79c0fb419407284b12e3c56e995120f94
    }

    @FXML
    public void onBtSaveAction(ActionEvent event){
        if (entity == null){
            throw new IllegalStateException("Entity was null");
        }

        if (service == null){
            throw new IllegalStateException("Service was null");
        }

        try {
            entity = getFormData();
            service.saveOrUpdate(entity);
            notifyDataChangeListener();
            Utils.currentStage(event).close();
        } catch (ValidationException e){
            setErrorMessages(e.getErrors());
        } catch (DbException e){
            Alerts.showAlert("Error saving object", null, e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    private void notifyDataChangeListener() {
        for (DataChangeListener listener : dataChangeListeners){
            listener.onDataChanged();
        }
    }

    private Seller getFormData() {
        Seller obj = new Seller();

        ValidationException exception = new ValidationException("Validation error");

        obj.setId(Utils.tryParseToInt(txtId.getText()));

        if (txtName.getText() == null || txtName.getText().trim().equals("")){
            exception.addError("name", "Field can't be empty");
        }
        obj.setName(txtName.getText());

        if (exception.getErrors().size() > 0){
            throw exception;
        }

        return obj;
    }

    @FXML
    public void onBtCancelAction(ActionEvent event){
        Utils.currentStage(event).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNode();
    }

    private void initializeNode(){
        Constraints.setTextFieldInteger(txtId);
        Constraints.setTextFieldMaxLength(txtName, 50);
        Constraints.setTextFieldDouble(txtBaseSalary);
        Constraints.setTextFieldMaxLength(txtEmail, 60);
        Utils.formatDataPicker(dpBirthDate, "dd/MM/yyyy");
<<<<<<< HEAD

        initializeComboBoxDepartment();
=======
>>>>>>> 2a38bba79c0fb419407284b12e3c56e995120f94
    }

    public void updateFormData(){
        if (entity == null){
            throw new IllegalStateException("Entity was null");
        }
        txtId.setText(String.valueOf(entity.getId()));
        txtName.setText(entity.getName());
        txtEmail.setText(entity.getEmail());
        Locale.setDefault(Locale.US);
        txtBaseSalary.setText(String.format("%.2f", entity.getBaseSalary()));
        if (entity.getBirthDate() != null) {
            dpBirthDate.setValue(LocalDate.ofInstant(entity.getBirthDate().toInstant(), ZoneId.systemDefault()));
        }
<<<<<<< HEAD

        if (entity.getDepartment() == null){
            comboBoxDepartment.getSelectionModel().selectFirst();
        } else {
            comboBoxDepartment.setValue(entity.getDepartment());
        }
    }

    public void loadAssociatedObjects(){
        if (departmentService == null){
            throw new IllegalStateException("DepartmentService was null");
        }

        List<Department> list = departmentService.findAll();
        obsList = FXCollections.observableArrayList(list);
        comboBoxDepartment.setItems(obsList);
=======
>>>>>>> 2a38bba79c0fb419407284b12e3c56e995120f94
    }

    private void setErrorMessages(Map<String, String> errors){
        Set<String> fields = errors.keySet();

        if (fields.contains("name")){
            labelErrorName.setText(errors.get("name"));
        }
    }
<<<<<<< HEAD

    private void initializeComboBoxDepartment(){
        Callback<ListView<Department>, ListCell<Department>> factory = lv -> new ListCell<Department>(){
            @Override
            protected void updateItem(Department item, boolean empty){
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };

        comboBoxDepartment.setCellFactory(factory);
        comboBoxDepartment.setButtonCell(factory.call(null));
    }
=======
>>>>>>> 2a38bba79c0fb419407284b12e3c56e995120f94
}
