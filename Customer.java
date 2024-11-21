import java.util.ArrayList;
class Customer {
   private static int customerIdCounter = 1;  // Counter for amount of customers
   private String customerId; // Customer ID label
   private String name; // Customer name
   private ArrayList<Policy> policies; // List of policies for customer
   public Customer(String name) { // Customer details
       this.customerId = "C" + (customerIdCounter++); // Pair C with customer number
       this.name = name; // Customer name
       this.policies = new ArrayList<>(); // List Policies
   }
   public String getCustomerId() {
       return customerId; // Share customer ID with Customer
   }
   public String getName() {
       return name; // share customer name with Customer
   }
  
   public ArrayList<Policy> getPolicies() {
       return policies; // Share policy list with Customer
   }
   public void addPolicy(Policy policy) {
       if (policies.size() < 5) { // Checks how many policies assigned to customer
           policies.add(policy); // If less than 5 adds the policy
       } else {
           System.out.println("Customer " + name + " cannot have more than 5 policies."); // If 5 don't allow the policy addition
       }
   }
}
