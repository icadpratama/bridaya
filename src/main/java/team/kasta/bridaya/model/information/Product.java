package team.kasta.bridaya.model.information;

import team.kasta.bridaya.model.audit.UserDateAudit;

import javax.persistence.*;

@Entity
@Table(name = "producst")
public class Product extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
