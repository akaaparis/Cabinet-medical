package tests.appointment;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.appointementServices.interfaces.AppointmentServicesRemote;

public class TestFindPatientByName {

	public static void main(String[] args) throws NamingException {

		Context context = new InitialContext();
		AppointmentServicesRemote proxy = (AppointmentServicesRemote) context
				.lookup("/e-scrum/AppointmentServices!services.appointementServices.interfaces.AppointmentServicesRemote");

		System.out.println(proxy.findPatientByName("Patient 1"));

	}
}
