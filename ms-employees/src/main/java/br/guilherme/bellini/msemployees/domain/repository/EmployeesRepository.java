package br.guilherme.bellini.msemployees.domain.repository;

import br.guilherme.bellini.msemployees.domain.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    Optional<Employees> findByCpf(String cpf);

}
