package model;

public class Transaction {
    private int id;
    private int walletId;
    private Double amount;
    private String status;
    private String TransactionType;

    public Transaction(int id, int walletId, Double amount) {
        this.id = id;
        this.walletId = walletId;
        this.amount = amount;
    }

    public Transaction(int id, int walletId, Double amount, String status, String transactionType) {
        this.id = id;
        this.walletId = walletId;
        this.amount = amount;
        this.status = status;
        TransactionType = transactionType;
    }
}
