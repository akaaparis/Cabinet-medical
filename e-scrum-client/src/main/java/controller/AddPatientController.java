package controller;

import java.util.Date;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.naming.Context;
import javax.naming.NamingException;

import services.appointementServices.interfaces.AppointmentServicesRemote;
import servicesLocator.ServiceLocator;
import entities.Patient;

public class AddPatientController extends AnchorPane {

	@FXML
	private TextField name;
	@FXML
	private TextField cinNumber;
	@FXML
	private DatePicker birthDate;
	@FXML
	private TextArea address;
	@FXML
	private Button btnAdd;
	@FXML
	private TextField phoneNumber;

	Context context = null;
	private static AppointmentServicesRemote remote;
	private static final String jndi = "/e-scrum/AppointmentServices!services.appointementServices.interfaces.AppointmentServicesRemote";

	private static AppointmentServicesRemote getProxy() {
		remote = (AppointmentServicesRemote) ServiceLocator.getInstance()
				.getProxy(jndi);
		return remote;
	}

	@FXML
	private void initialize() throws NamingException {

		btnAdd.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				try {

					Patient patient = new Patient(name.getText(), Integer
							.valueOf(cinNumber.getText()), new Date(), address
							.getText(), Integer.valueOf(phoneNumber.getText()));

					getProxy().addPatient(patient);
					System.out.println("AddPatient");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}

}
