package com.electricityBilling.model;

public class electricityBilling {
	
	private int user_id;
	private String user_name;
	private String password_hash;
	private String email;
	private String contact_number;
	private String address;
	private String country;
//	private  created_at TIMESTAMP DEFAULT CURRENT_TI
	 private int usage_id;
	    private float units_consumed;
//	    privatestart_dateDATE NOT NULL
//	    end_date DATE NOT NULL,
	
	   private int  bill_id; 
//	    private int usage_id;
//	    private int user_id;
//	    private float units_consumed;
	    private float rate_per_unit;
	    private float total_amount;
//	    private date billing_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//	    due_date DATE NOT NULL,
	    private String status;
	    
	   private int payment_id;
	    private float amount_paid;
//	    private int payment_date;
	    private String payment_method;
	    private String transaction_id;
	    
	    private int receipt_id;
//	    private int receipt_date;
	    private float receipt_amount;
		
	    
	    public electricityBilling() {
			super();
			// TODO Auto-generated constructor stub
		}


		public electricityBilling(int user_id, String user_name, String password_hash, String email,
				String contact_number, String address, String country, int usage_id, float units_consumed, int bill_id,
				float rate_per_unit, float total_amount, String status, int payment_id, float amount_paid,
				String payment_method, String transaction_id, int receipt_id, float receipt_amount) {
			super();
			this.user_id = user_id;
			this.user_name = user_name;
			this.password_hash = password_hash;
			this.email = email;
			this.contact_number = contact_number;
			this.address = address;
			this.country = country;
			this.usage_id = usage_id;
			this.units_consumed = units_consumed;
			this.bill_id = bill_id;
			this.rate_per_unit = rate_per_unit;
			this.total_amount = total_amount;
			this.status = status;
			this.payment_id = payment_id;
			this.amount_paid = amount_paid;
			this.payment_method = payment_method;
			this.transaction_id = transaction_id;
			this.receipt_id = receipt_id;
			this.receipt_amount = receipt_amount;
		}


		public int getUser_id() {
			return user_id;
		}


		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}


		public String getUser_name() {
			return user_name;
		}


		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}


		public String getPassword_hash() {
			return password_hash;
		}


		public void setPassword_hash(String password_hash) {
			this.password_hash = password_hash;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getContact_number() {
			return contact_number;
		}


		public void setContact_number(String contact_number) {
			this.contact_number = contact_number;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public String getCountry() {
			return country;
		}


		public void setCountry(String country) {
			this.country = country;
		}


		public int getUsage_id() {
			return usage_id;
		}


		public void setUsage_id(int usage_id) {
			this.usage_id = usage_id;
		}


		public float getUnits_consumed() {
			return units_consumed;
		}


		public void setUnits_consumed(float units_consumed) {
			this.units_consumed = units_consumed;
		}


		public int getBill_id() {
			return bill_id;
		}


		public void setBill_id(int bill_id) {
			this.bill_id = bill_id;
		}


		public float getRate_per_unit() {
			return rate_per_unit;
		}


		public void setRate_per_unit(float rate_per_unit) {
			this.rate_per_unit = rate_per_unit;
		}


		public float getTotal_amount() {
			return total_amount;
		}


		public void setTotal_amount(float total_amount) {
			this.total_amount = total_amount;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		public int getPayment_id() {
			return payment_id;
		}


		public void setPayment_id(int payment_id) {
			this.payment_id = payment_id;
		}


		public float getAmount_paid() {
			return amount_paid;
		}


		public void setAmount_paid(float amount_paid) {
			this.amount_paid = amount_paid;
		}


		public String getPayment_method() {
			return payment_method;
		}


		public void setPayment_method(String payment_method) {
			this.payment_method = payment_method;
		}


		public String getTransaction_id() {
			return transaction_id;
		}


		public void setTransaction_id(String transaction_id) {
			this.transaction_id = transaction_id;
		}


		public int getReceipt_id() {
			return receipt_id;
		}


		public void setReceipt_id(int receipt_id) {
			this.receipt_id = receipt_id;
		}


		public float getReceipt_amount() {
			return receipt_amount;
		}


		public void setReceipt_amount(float receipt_amount) {
			this.receipt_amount = receipt_amount;
		}


		@Override
		public String toString() {
			return "electricityBilling [user_id=" + user_id + ", user_name=" + user_name + ", password_hash="
					+ password_hash + ", email=" + email + ", contact_number=" + contact_number + ", address=" + address
					+ ", country=" + country + ", usage_id=" + usage_id + ", units_consumed=" + units_consumed
					+ ", bill_id=" + bill_id + ", rate_per_unit=" + rate_per_unit + ", total_amount=" + total_amount
					+ ", status=" + status + ", payment_id=" + payment_id + ", amount_paid=" + amount_paid
					+ ", payment_method=" + payment_method + ", transaction_id=" + transaction_id + ", receipt_id="
					+ receipt_id + ", receipt_amount=" + receipt_amount + "]";
		}
	    
	    
		
	    
	    
	    
	    
	    
	    
}
