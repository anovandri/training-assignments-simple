package eu.sig.training.ch04;

public abstract class Accounts {
	
	Money balance;
	float interestPercentage;
	
    public Accounts(Money balance, float interestPercentage) {
		super();
		this.balance = balance;
		this.interestPercentage = interestPercentage;
	}

	@SuppressWarnings("unused")
    public static CheckingAccount findAcctByNumber(String number) {
        return new CheckingAccount();
    }

    // tag::isValid[]
    public static boolean isValid(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum = sum + (9 - i) * Character.getNumericValue(number.charAt(i));
        }
        return sum % 11 == 0;
    }
    // end::isValid[]
    
    public void addInterest() {
        Money interest = balance.multiply(interestPercentage);
        if (interest.greaterThan(0)) {
            balance.add(interest);
        } else {
            balance.substract(interest);
        }
    }
    
    public abstract Transfer makeTransfer(String counterAccount, Money amount) throws BusinessException;
    
    public Transfer transfer(String counterAccount, Money amount) throws BusinessException {    	
        if (isValid(counterAccount)) {
            // 3. Look up counter account and make transfer object:
            CheckingAccount acct = Accounts.findAcctByNumber(counterAccount);
            Transfer result = new Transfer(this, acct, amount);
            return result;
        } else {
            throw new BusinessException("Invalid account number!");
        }
    }
    
}