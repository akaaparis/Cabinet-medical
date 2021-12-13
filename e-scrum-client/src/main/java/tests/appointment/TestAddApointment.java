package tests.appointment;

import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.appointementServices.interfaces.AppointmentServicesRemote;
import entities.Doctor;
import entities.Patient;

public class TestAddApointment {

	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		AppointmentServicesRemote proxy = (AppointmentServicesRemote) context
				.lookup("/e-scrum/AppointmentServices!services.appointementServices.interfaces.AppointmentServicesRemote");

		Patient patient = new Patient("Patient", 111111, new Date(), "address",
				789999);

		Doctor doctor = new Doctor();
		doctor.setName("Doctor");
		doctor.setAddress("aDdd Doctor");
		doctor.setCinNumber(12223);
		doctor.setPhoneNumber(78888);
		doctor.setSpeciality("speciality");

		System.out.println(proxy.createAppointment(patient, doctor, new Date(),
				"consultation"));

	}
}
