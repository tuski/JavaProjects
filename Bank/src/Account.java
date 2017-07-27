import Exception.BalanceException;

public class Account implements Constants{
	private String Account_Holder_Name;
	private String Account_ID;
    private  double Balance;
    
    
	private Account(String account_Holder_Name, String account_ID, double balance) {
		super();
		Account_Holder_Name = account_Holder_Name;
		Account_ID = account_ID;
		this.Balance = balance;
		
		
	}
	
	public static Account newInstance(String account_Holder_Name, String account_ID, double balance) throws BalanceException{
       if(balance<Constants.MINIMUM_BALANCE ){
    	   
//    	   try {
//			throw new BalanceException("Account doesnt have balance");
//		} catch (BalanceException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
    	   
//			System.out.println("Account does not have required balance");
    	   throw new BalanceException("Account doesnt have balance");
			//return null;
		}
       else
		return new Account(account_Holder_Name, account_ID, balance);
		
	}
	
	
	public String getAccount_Holder_Name() {
		return Account_Holder_Name;
	}
	public void setAccount_Holder_Name(String account_Holder_Name) {
		Account_Holder_Name = account_Holder_Name;
	}
	public String getAccount_ID() {
		return Account_ID;
	}
	public void setAccount_ID(String account_ID) {
		Account_ID = account_ID;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		this.Balance = balance;
	}
    
    
}
