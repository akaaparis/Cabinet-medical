package tests.appointment;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.appointementServices.interfaces.AppointmentServicesRemote;
import entities.Patient;

public class TestAddPatient {

	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		AppointmentServicesRemote proxy = (AppointmentServicesRemote) context
				.lookup("/e-scrum/AppointmentServices!services.appointementServices.interfaces.AppointmentServicesRemote");
		Patient p = new Patient();
		p.setName("Rihab");
		p.setCinNumber(12333);
		p.setAddress("Tunis");
		p.setPhoneNumber(1233);

		System.out.println(proxy.addPatient(p));
	}
}
