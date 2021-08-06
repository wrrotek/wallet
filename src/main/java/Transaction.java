import java.time.LocalDate;

public class Transaction {

    private Long id;
    private String transactionType;
    private String description;
    private double amount;
    private LocalDate date;

    public Transaction(Long id, String type, String description, double amount, LocalDate date) {
        this.id = id;
        transactionType = type;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public Transaction(String type, String description, double amount, LocalDate date) {
        this(null, type, description, amount, date);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return transactionType;
    }

    public void setType(String type) {
        transactionType = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setLocalDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", type='" + transactionType + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }

    public enum type {
        WPŁATA, WYPŁATA
    }
}

