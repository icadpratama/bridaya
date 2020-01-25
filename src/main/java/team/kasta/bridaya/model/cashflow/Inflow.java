package team.kasta.bridaya.model.cashflow;

import team.kasta.bridaya.model.audit.UserDateAudit;

import javax.persistence.*;

@Entity
@Table(name = "inflows")
public class Inflow extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
