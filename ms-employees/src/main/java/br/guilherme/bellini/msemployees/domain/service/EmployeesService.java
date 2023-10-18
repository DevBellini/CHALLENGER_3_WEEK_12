package br.guilherme.bellini.msemployees.domain.service;

import br.guilherme.bellini.msemployees.domain.entity.Employees;
import br.guilherme.bellini.msemployees.domain.repository.EmployeesRepository;
import br.guilherme.bellini.msemployees.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeesService {

    private final EmployeesRepository repository;

    @Transactional
    public Employees save(Employees employees){
        boolean cpfValid = employees.getCpf().length() == 11;
        Optional<Employees> optEmployees = repository.findByCpf(employees.getCpf());

        if(!cpfValid){
            throw new BusinessException("cpf invalid!");
        }
        return repository.save(employees);
    }

    public Optional<Employees> getByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
