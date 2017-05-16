package eu.sig.training.ch04;

// tag::SavingsAccount[]
public class SavingsAccount extends Accounts {
    private static final float INTEREST_PERCENTAGE = 0.04f;
    private static Money balance = new Money();
    private CheckingAccount registeredCounterAccount;
    
    public SavingsAccount() {
    	super(balance, INTEREST_PERCENTAGE);
    }

    public Transfer makeTransfer(String counterAccount, Money amount) 
        throws BusinessException {
        // 1. Assuming result is 9-digit bank account number, validate 11-test:
    	
    	Transfer transfer;    	
    	try {
    		transfer = transfer(counterAccount, amount);
    		if (transfer.getCounterAccount().equals(this.registeredCounterAccount)) 
            {
                return transfer;
            } else {
                throw new BusinessException("Counter-account not registered!");
            }
    	} catch(BusinessException e) {
    		throw new BusinessException(e.getMessage());
    	}
    }    
}
// end::SavingsAccount[]
