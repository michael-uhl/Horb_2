package a05_cC;

import java.util.ArrayList;
import java.util.List;

public class Methoden {

	private List<Employee> employees = new ArrayList<Methoden.Employee>();
	private Session session;

	// public void pay() {
	// for (Employee e : employees) { s
	// if (e.isPayday()) {
	// Money pay = e.calculatePay();
	// e.deliverPay(pay);
	// }
	// }
	// }

	public void pay() {
		for (Employee e : employees)
			payIfNecessary(e);
	}
	
	

	
	public boolean checkPassword(String username, String password) {
		if (isAuthorized(username, password)) {
			// führt zu Nebeneffekten
			session.start();
			return true;
		} else {
			return false;
		}
	}

	private boolean isAuthorized(String a, String b) {
		return false;
	}
	
	private void payIfNecessary(Employee e) {
		if (e.isPayday())
			calculateAndDeliverPay(e);
	}

	private void calculateAndDeliverPay(Employee e) {
		Money pay = e.calculatePay();
		e.deliverPay(pay);
	}

	private static final class Employee {
		public boolean isPayday() {
			return false;
		}

		public void deliverPay(Money pay) {

		}

		public Money calculatePay() {
			return null;
		}
	}

	private static final class Money {
	}
	
	private static final class Session {
		public void start() {
			
		}
	}
}
