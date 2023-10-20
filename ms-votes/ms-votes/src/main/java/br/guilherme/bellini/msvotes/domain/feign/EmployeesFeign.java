package br.guilherme.bellini.msvotes.domain.feign;

import br.guilherme.bellini.msvotes.domain.entity.Employees;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ms-employees", path = "employees")
@Component
public interface EmployeesFeign {

    @GetMapping(value = "{cpf}")
    Employees findByCpf(@PathVariable("cpf") String cpf);
}
