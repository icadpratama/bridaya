package team.kasta.bridaya.model.cashflow;

import org.hibernate.annotations.NaturalId;
import team.kasta.bridaya.util.CoaTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "coa_types")
public class CoaType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 9, name = "coa_type")
    private CoaTypeEnum type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CoaTypeEnum getType() {
        return type;
    }

    public void setType(CoaTypeEnum type) {
        this.type = type;
    }
}
