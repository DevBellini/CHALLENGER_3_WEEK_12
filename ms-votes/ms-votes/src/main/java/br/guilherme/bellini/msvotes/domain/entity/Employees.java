package br.guilherme.bellini.msvotes.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employees {

    private long id;
    private String cpf;
    private String name;
    private Integer age;
}
