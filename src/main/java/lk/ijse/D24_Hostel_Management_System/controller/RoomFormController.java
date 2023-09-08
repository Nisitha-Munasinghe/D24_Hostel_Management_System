package lk.ijse.D24_Hostel_Management_System.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.D24_Hostel_Management_System.dto.RoomDto;
import lk.ijse.D24_Hostel_Management_System.dto.StudentDto;
import lk.ijse.D24_Hostel_Management_System.service.RoomService;
import lk.ijse.D24_Hostel_Management_System.service.StudentService;
import lk.ijse.D24_Hostel_Management_System.service.impl.RoomServiceImpl;
import lk.ijse.D24_Hostel_Management_System.service.impl.StudentServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RoomFormController implements Initializable {

    @FXML
    private ComboBox<String> cmbRoomType;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<?> tblRoomManagement;

    @FXML
    private TextField txtAmenitiesAndFeatures;

    @FXML
    private TextField txtMaximumOccupency;

    @FXML
    private TextField txtPrice;

    @FXML
    private ComboBox<String> cmbRoomStatus;

    @FXML
    private TextField txtRoomId;

    @FXML
    private TextField txtRoomSize;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> roomTypeList = FXCollections.observableArrayList(
                "Non-Ac",
                "Non-Ac/Food",
                "Ac",
                "Ac/Food"
        );
        cmbRoomType.setItems(roomTypeList);

        ObservableList<String> roomStatusType = FXCollections.observableArrayList(
                "Active",
                "InActive"
        );
        cmbRoomStatus.setItems(roomStatusType);
    }

    @FXML
    void navigateToHome(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/dashboard-form.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        RoomDto roomDto = getRoom();

        RoomService roomService = new RoomServiceImpl().getInstance();
        String isSavedRoomId = roomService.saveRoom(roomDto);

        if (isSavedRoomId != null) {
            new Alert(Alert.AlertType.CONFIRMATION, "Room saved successfully!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to save room. Please try again.").show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String roomId = txtRoomId.getText(); // Get the room ID to be deleted

        RoomService roomService = new RoomServiceImpl().getInstance();

        // Call the service method to delete the room
        boolean isDeleted = roomService.deleteRoom(roomId);

        if (isDeleted) {
            new Alert(Alert.AlertType.CONFIRMATION, "Room deleted successfully!").show();
            //clearFields(); // Optionally, clear the input fields after deletion
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to delete room. Please try again.").show();
        }
    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        RoomDto roomDto = getRoom();

        RoomService roomService = new RoomServiceImpl().getInstance();
        String isUpdatRoomId = roomService.updateRoom(roomDto);

        if (isUpdatRoomId != null) {
            new Alert(Alert.AlertType.CONFIRMATION, "Room updated successfully!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to updated room. Please try again.").show();
        }
    }

    public RoomDto getRoom(){
        String roomId = txtRoomId.getText();
        String roomType = cmbRoomType.getValue();
        double roomPrice = Double.parseDouble(txtPrice.getText());
        double roomSize = Double.parseDouble(txtRoomSize.getText());
        int maximumOccupency = Integer.parseInt(txtMaximumOccupency.getText());
        String armentiesAndFeatures = txtAmenitiesAndFeatures.getText();
        String roomStatus = cmbRoomStatus.getValue();

        RoomDto roomDto = new RoomDto();
        roomDto.setRoomId(roomId);
        roomDto.setRoomType(roomType);
        roomDto.setPricing(roomPrice);
        roomDto.setRoomSize(roomSize);
        roomDto.setMaximumOccupency(maximumOccupency);
        roomDto.setArmentiesAndFeatures(armentiesAndFeatures);
        roomDto.setRoomStatus(roomStatus);

        return roomDto;

    }


}
