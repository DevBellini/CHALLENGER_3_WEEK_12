package br.guilherme.bellini.msemployees.domain.entity.repository;

import br.guilherme.bellini.msemployees.domain.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {

    Optional<Employees> findByCpf(String cpf);
}
