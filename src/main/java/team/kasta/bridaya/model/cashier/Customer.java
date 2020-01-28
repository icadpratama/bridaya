package team.kasta.bridaya.model.cashier;

import team.kasta.bridaya.model.audit.DateAudit;
import team.kasta.bridaya.model.authentication.User;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
