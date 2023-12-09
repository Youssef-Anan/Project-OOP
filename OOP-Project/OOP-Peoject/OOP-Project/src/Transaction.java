public class Transaction {
    private int Id;

    private String Client,Employee,Date;
    private float Amount;
    private String SrcAcc,DstAcc;

    Transaction(int Id,String Date,String Client,String Employee,float Amount,String SrcAcc, String DstAcc){
        this.Id=Id;
        this.Date=Date;
        this.Client=Client;
        this.Employee=Employee;
        this.Amount=Amount;
        this.SrcAcc=SrcAcc;
        this.DstAcc=DstAcc;

    }

    public void GetTransactionDetail(String Date,float Amount,String SrcAcc, String DstAcc ,String Client){
        System.out.println("The transaction of The account named"+Client+" transaction is complete! \n  It was on "+Date+"\nThe Amount is "+ Amount+ "It was from the account: "+SrcAcc+"\nIt was sent to the account"+DstAcc );
    }




}
