package com.customer.tester;

import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;

import com.customer.operations.CustomerOperationsImpl;

public class TestCustomerManagement {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){			
			boolean exit = false;
			CustomerOperationsImpl cops = new CustomerOperationsImpl();
			while(!exit) {
				System.out.println("1. Sign Up\n2. Sign In\n"
						+ "3. Change Password\n4. Unsubscribe customer\n"
						+ "5. Display All Customers\n0. Exit\nEnter choice: ");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter customer details firstName, lastName, email, password, regs amt, dob, plan");
						cops.signUp(sc.next(), sc.next(), sc.next(), sc.next(),sc.nextDouble(), sc.next(), sc.next());
						sc.nextLine();
						break;
					case 2:
						System.out.println("Enter emailId and password");
						cops.signIn(sc.next(),sc.next());
						break;
					case 3:
						System.out.println("Enter emailId, old password and new password");
						cops.changePassword(sc.next(), sc.next(), sc.next());
						break;
					case 4:
						System.out.println("Enter emailId");
						cops.unsubscribeCustomer(sc.next());
						break;
					case 5:
						System.out.println("All Customers Details");
						cops.displayAllCustomer();
						break;
					case 0:
						exit = true;
						break;
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		}
	}
}
