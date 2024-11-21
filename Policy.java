class Policy {
   private static int policyIdCounter = 1; // Counter for number of policies
   private String policyId; // Policy Label
   private String type; // Insurance Type
   private double coverValue; // Insurance Cover Variable
   private int duration; // Length of Insurance Plan
   private double instalmentAmount; // Installment amount
   private String paymentPlan;
   public Policy(String type, double coverValue, int duration, double instalmentAmount, String paymentPlan) { // Store policy
       this.policyId = "P" + (policyIdCounter++); // Pair P with policy number
       this.type = type;
       this.coverValue = coverValue;
       this.duration = duration;
       this.instalmentAmount = instalmentAmount;
       this.paymentPlan = paymentPlan;
   }
   public String getPolicyId() {
       return policyId; // Share Policy ID with Policy
   }
   public String getType() {
       return type; // Share Insurance Type with Policy
   }
   public double getCoverValue() {
       return coverValue; // Share Insurance Value with Policy
   }
   public int getDuration() {
       return duration; // Share Cover Duration with Policy
   }
   public double getInstalmentAmount() {
       return instalmentAmount; // Share Installment Amount with Policy
   }
   public String getPaymentPlan() {
       return paymentPlan; // Share Payment Plan with Policy
   }
   public void updatePolicyDetails(double newCoverValue, int newDuration, double newInstalmentAmount, String newPaymentPlan) { // Updates details of Policy
       this.coverValue = newCoverValue;
       this.duration = newDuration;
       this.instalmentAmount = newInstalmentAmount;
       this.paymentPlan = newPaymentPlan;
   }
}
