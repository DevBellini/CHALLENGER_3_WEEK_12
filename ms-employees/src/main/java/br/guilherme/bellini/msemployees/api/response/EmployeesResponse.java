package br.guilherme.bellini.msemployees.api.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesResponse {

    private Long id;
    private String name;
    private String cpf;
    private Integer age;
}
