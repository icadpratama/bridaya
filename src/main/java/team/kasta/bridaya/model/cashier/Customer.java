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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
