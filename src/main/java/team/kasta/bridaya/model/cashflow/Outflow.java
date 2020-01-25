package team.kasta.bridaya.model.cashflow;

import team.kasta.bridaya.model.audit.UserDateAudit;

import javax.persistence.*;

@Entity
@Table(name = "outflows")
public class Outflow extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
