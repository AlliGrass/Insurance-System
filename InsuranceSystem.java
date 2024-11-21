import java.util.ArrayList;
import java.util.Scanner;
public class InsuranceSystem {
	private static ArrayList<Customer> customers = new ArrayList<>(); // List of Customers
	private static int customernumber = 0; // Start program with 0 customers
	    public static void main(String[] args) { // Start Main Method
	        Scanner scan = new Scanner(System.in);
	        int menu = 0;
	        while (menu != 8) { // While Exit option hasn't been inputed
	            System.out.println("\n1. Create new Customer");
	            System.out.println("2. Add new Policy to Customer");
	            System.out.println("3. Update Policy details");
	            System.out.println("4. Delete Policy");
	            System.out.println("5. Search and print customers");
	            System.out.println("6. Calculate total cover value");
	            System.out.println("7. Print all members and policies details");
	            System.out.println("8. Exit");
	            System.out.print("Enter menu Option: ");
	            menu = scan.nextInt(); // Reads input
	            switch (menu) { // Menu switch case
	                case 1:
	                    new InsuranceSystem().createNewCustomer(scan); // Lead to non static method to add customer to system
	                    break;
	                case 2:
	                    addNewPolicyToCustomer(scan); // Static method to add policy to system
	                    break;
	                case 3:
	                    updatePolicyDetails(scan); // Static method to update an existing
	                    break;
	                case 4:
	                    deletePolicy(scan); // Static method to deactivate (Not delete) policy
	                    break;
	                case 5:
	                    searchAndPrintCustomers(scan); // Static method to search and print customer details
	                    break;
	                case 6:
	                    calculateTotalCoverValue(); // Static method calculate total cover
	                    break;
	                case 7:
	                    printAllMembersAndPoliciesDetails(); // Static method to print all customers and policy
	                    break;
	                case 8:
	                    System.out.println("Ending Program.");
	                    break;
	                default:
	                    System.out.println("Please enter a valid option.");
	            }
	        }
	    }
	    private static final int maxCustomers = 7; // Maximum allowed customers
	    private void createNewCustomer(Scanner scan) {
	        customernumber = customernumber + 1; // Add customer value to check how many customers are in the system
	        if (customernumber <= maxCustomers) { // If less than 7 customers, ask for customer name and add them to the system
	            System.out.print("Enter customer name: ");
	            String name = scan.next(); // Input customer name
	            Customer customer = new Customer(name);
	            customers.add(customer);
	            System.out.println("Customer created successfully with ID: " + customer.getCustomerId());
	        } else { // If 7 customers in system already only prints below text
	            System.out.println("Too many customers already on file.");
	        }
	    }
	   
	    private static final int maxPolicy = 5; // Maximum allowed policies per customer
	    private static void addNewPolicyToCustomer(Scanner scan) {
	        System.out.print("Enter customer ID: ");
	        String customerId = scan.next();
	        Customer customer = findCustomerById(customerId); // Find customer by Customer ID
	        if (customer != null) {
	            if (customer.getPolicies().size() < maxPolicy) { // Insurance cover type
	            	System.out.println("\nSelect policy type:");
		            System.out.println("1. Vehicle");
		            System.out.println("2. Health");
		            System.out.println("3. Travel");
		            System.out.println("4. Property");
		            System.out.println("5. Pet");
		            System.out.print("Enter policy type: ");
		            int policyType = scan.nextInt(); // Input Policy type
		            System.out.print("Enter cover value: ");
		            double coverValue = scan.nextDouble(); // Input cover value
		            System.out.print("Enter policy duration (Monthly): ");
		            int duration = scan.nextInt(); // Input month duration as an integer
		            System.out.print("Enter instalment amount: ");
		            double instalmentAmount = scan.nextDouble(); // Input installment amount
		            System.out.print("Enter payment plan (Fortnightly/Monthly/Yearly): ");
		            String paymentPlan = scan.next(); // input string for payment plan
		            String policyTypeName; // Sets policy type name as string
		            switch (policyType) { // Switch case from integer
		                case 1:
		                    policyTypeName = "Vehicle";
		                    break;
		                case 2:
		                    policyTypeName = "Health";
		                    break;
		                case 3:
		                    policyTypeName = "Travel";
		                    break;
		                case 4:
		                    policyTypeName = "Property";
		                    break;
		                case 5:
		                    policyTypeName = "Pet";
		                    break;
		                default:
		                    System.out.println("Invalid policy.");
		                    return;
		            }
		            Policy policy = new Policy(policyTypeName, coverValue, duration, instalmentAmount, paymentPlan);
		            customer.addPolicy(policy);
	            } else {
	                System.out.println("Customer already has the maximum number of policies allowed.");
	            }
	        } else {
	            System.out.println("Customer not found with ID: " + customerId);
	        }
	    }
	    private static void updatePolicyDetails(Scanner scan) { // Update Policy Details
	        System.out.print("Enter policy ID: ");
	        String policyId = scan.next();
	        Policy policy = findPolicyById(policyId); // Find policy in system by policy ID
	        if (policy != null) { // if policy has information
	            System.out.print("Enter new cover value: "); // Enter new information
	            double newCoverValue = scan.nextDouble();
	            System.out.print("Enter new duration: ");
	            int newDuration = scan.nextInt();
	            System.out.print("Enter new instalment amount: ");
	            double newInstalmentAmount = scan.nextDouble();
	            System.out.print("Enter new payment plan: ");
	            String newPaymentPlan = scan.next();
	            policy.updatePolicyDetails(newCoverValue, newDuration, newInstalmentAmount, newPaymentPlan);
	            System.out.println("Policy details updated successfully.");
	        } else { //  If there is no policy in the system
	            System.out.println("Policy not found,");
	        }
	    }
	    private static void deletePolicy(Scanner scan) { // Delete policy from customer profile
	        System.out.print("Enter policy ID: ");
	        String policyId = scan.next(); // Input policy ID
	        Policy policy = findPolicyById(policyId);
	        if (policy != null) { // If policy exists/has information
	            System.out.println("Policy deleted successfully.");
	        } else { // If policy doesn't exist
	            System.out.println("Policy not found with ID: " + policyId);
	        }
	    }
	    private static void searchAndPrintCustomers(Scanner scan) { // Search for customer and print their details
	        System.out.println("\n1. Search by Customer ID");
	        System.out.println("2. Search by Customer Name");
	        System.out.println("3. Search by Policy ID");
	        System.out.print("Enter your menu: ");
	        int searchmenu = scan.nextInt(); //
	        switch (searchmenu) { // Switch case for searching for customer information
	            case 1:
	                System.out.print("Enter Customer ID: ");
	                String customerId = scan.next();
	                printCustomerDetails(findCustomerById(customerId)); // Search for customer ID
	                break;
	            case 2:
	                System.out.print("Enter Customer Name: ");
	                String customerName = scan.next();
	                printCustomerDetails(findCustomerByName(customerName)); // Search for Customer name
	                break;
	            case 3:
	                System.out.print("Enter Policy ID: ");
	                String policyId = scan.next();
	                printPolicyDetails(findPolicyById(policyId)); // Search for Policy ID
	                break;
	            default: // No customer in system
	                System.out.println("Not in the system");
	        }
	    }
	    private static void calculateTotalCoverValue() {
	        double totalCoverValue = 0;
	        for (Customer customer : customers) {
	            for (Policy policy : customer.getPolicies()) {
	                totalCoverValue += policy.getCoverValue();
	            }
	        }
	        System.out.println("Total Cover Value across all policies: " + totalCoverValue);
	    }
	    private static void printAllMembersAndPoliciesDetails() {
	        System.out.println("\nAll Members and Policies Details:");
	        System.out.println("================================");
	        for (Customer customer : customers) {
	            printCustomerDetails(customer); // Print customer details and policies
	        }
	    }
	    private static void printCustomerDetails(Customer customer) {
	        if (customer != null) { // If details exist, print them
	            System.out.println("Customer ID: " + customer.getCustomerId()); // Get customer ID from Customer.java
	            System.out.println("Customer Name: " + customer.getName()); // Get customer name from Customer.java
	            System.out.println("Policies:");
	            System.out.println("---------");
	            for (Policy policy : customer.getPolicies()) {
	                printPolicyDetails(policy);
	            }
	            System.out.println("================================");
	        } else {
	            System.out.println("Customer not found."); // If customer doesn't exist, don't print
	        }
	    }
	    private static void printPolicyDetails(Policy policy) { // Prints policy
	        if (policy != null) {
	            System.out.println("\nPolicy ID: " + policy.getPolicyId());
	            System.out.println("Policy Type: " + policy.getType());
	            System.out.println("Cover Value: " + policy.getCoverValue());
	            System.out.println("Duration: " + policy.getDuration());
	            System.out.println("Instalment Amount: " + policy.getInstalmentAmount());
	            System.out.println("Payment Plan: " + policy.getPaymentPlan());
	            System.out.println("---------");
	        } else {
	            System.out.println("Policy not found.");
	        }
	    }
	    private static Customer findCustomerById(String customerId) {
	        for (Customer customer : customers) {
	            if (customer.getCustomerId().equalsIgnoreCase(customerId)) { // Find customer using their ID, ignoring case sensitivity
	                return customer;
	            }
	        }
	        return null;
	    }
	    private static Customer findCustomerByName(String customerName) {
	        for (Customer customer : customers) {
	            if (customer.getName().equalsIgnoreCase(customerName)) { // Find customer by name, ignoring case sensitivity
	                return customer;
	            }
	        }
	        return null;
	    }
	    private static Policy findPolicyById(String policyId) {
	        for (Customer customer : customers) {
	            for (Policy policy : customer.getPolicies()) {
	                if (policy.getPolicyId().equalsIgnoreCase(policyId)) { // Find policy by ID, ignoring case sensitivity
	                    return policy;
	                }
	            }
	        }
	        return null;
	    }
}
