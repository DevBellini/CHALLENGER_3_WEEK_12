package br.guilherme.bellini.msproposal.domain.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.builder.EqualsBuilder;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_proposal")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String Proposal;

    public Proposal(Long id, String proposal) {
        this.id = id;
        Proposal = proposal;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(obj, this);
    }

}


