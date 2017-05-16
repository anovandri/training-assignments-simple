package eu.sig.training.ch04;

// tag::CheckingAccount[]
public class CheckingAccount extends Accounts {
    private static final float INTEREST_PERCENTAGE = 0.01f;
    private static Money balance = new Money();
    private int transferLimit = 100;
    
    public CheckingAccount() {
    	super(balance, INTEREST_PERCENTAGE);
    }

    public Transfer makeTransfer(String counterAccount, Money amount)
        throws BusinessException {
        // 1. Check withdrawal limit:
        if (amount.greaterThan(this.transferLimit)) {
            throw new BusinessException("Limit exceeded!");
        }
        Transfer transfer;
        try {
        	transfer = transfer(counterAccount, amount);
        } catch (BusinessException e) {
        	throw new BusinessException(e.getMessage());
        }
        
        return transfer;
    }    
}
// end::CheckingAccount[]
