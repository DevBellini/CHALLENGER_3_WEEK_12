package br.guilherme.bellini.msemployees.domain.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.builder.EqualsBuilder;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String cpf;

    @Column
    private Integer age;

    public Employees(Long id, String name, String cpf, Integer age) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj){
        return EqualsBuilder.reflectionEquals(obj, this);
    }

}
