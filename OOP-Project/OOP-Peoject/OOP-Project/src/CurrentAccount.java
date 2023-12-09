public class CurrentAccount extends Account {


    public void evaluateInterest() {


        if (balance >= 3000) {
            interestRate = 0;
        } else {
            interestRate = 0.12;
        }

    }
    public void applyFees() {
        balance -= balance * interestRate;
    }


}
