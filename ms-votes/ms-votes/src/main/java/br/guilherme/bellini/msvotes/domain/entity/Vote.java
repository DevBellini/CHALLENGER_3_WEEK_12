package br.guilherme.bellini.msvotes.domain.entity;
import br.guilherme.bellini.msvotes.domain.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employeesCpf;
    private Long proposalId;
    @Enumerated(value = EnumType.STRING)
    private Status status;

}
