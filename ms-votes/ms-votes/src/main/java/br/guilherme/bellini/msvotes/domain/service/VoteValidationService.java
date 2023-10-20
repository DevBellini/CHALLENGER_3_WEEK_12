package br.guilherme.bellini.msvotes.domain.service;

import br.guilherme.bellini.msvotes.domain.entity.Employees;
import br.guilherme.bellini.msvotes.domain.enums.Erole;
import br.guilherme.bellini.msvotes.domain.feign.EmployeesFeign;
import br.guilherme.bellini.msvotes.domain.feign.ProposalFeign;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Data
public class VoteValidationService {

    private final EmployeesFeign employeesFeign;
    private final ProposalFeign proposalFeign;

    public Erole validateVoto(String cpf) {
        Employees employeesResponse = employeesFeign.findByCpf(cpf);
        if (employeesFeign.findByCpf(cpf).getAge() >= 18) {
            return Erole.pode_votar;
        }
        return ResponseEntity.ok(Erole.nao_pode_votar).getBody();
    }

}
