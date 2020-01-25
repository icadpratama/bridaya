package team.kasta.bridaya.model.cashier;

import team.kasta.bridaya.model.audit.UserDateAudit;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Byte amount;

    @Column(name = "total")
    private Long total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getAmount() {
        return amount;
    }

    public void setAmount(Byte amount) {
        this.amount = amount;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
