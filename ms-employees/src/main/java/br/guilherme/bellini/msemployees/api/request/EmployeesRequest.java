package br.guilherme.bellini.msemployees.api.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesRequest {

        @NotBlank(message = "name is required")
        private String name;
        @NotBlank(message = "cpf is required")
        private String cpf;
        @NotNull(message = "age is required")
        private Integer age;

}
