package br.guilherme.bellini.msvotes.domain.service;

import br.guilherme.bellini.msvotes.domain.entity.Employees;
import br.guilherme.bellini.msvotes.domain.entity.Proposal;
import br.guilherme.bellini.msvotes.domain.entity.Vote;
import br.guilherme.bellini.msvotes.domain.enums.Erole;
import br.guilherme.bellini.msvotes.domain.enums.Status;
import br.guilherme.bellini.msvotes.domain.feign.EmployeesFeign;
import br.guilherme.bellini.msvotes.domain.feign.ProposalFeign;
import br.guilherme.bellini.msvotes.domain.repository.VoteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Data
public class VoteValidationService {

    private final EmployeesFeign employeesFeign;
    private final ProposalFeign proposalFeign;
    private final VoteRepository voteRepository;

    public Erole validateVoto(String cpf) {
        Employees employeesResponse = employeesFeign.findByCpf(cpf);
        if (employeesFeign.findByCpf(cpf).getAge() >= 18) {
            return Erole.pode_votar;
        }
        return ResponseEntity.ok(Erole.nao_pode_votar).getBody();
    }

    public void vote(String employeesCpf, Long id, Status status) {
        Vote existingVote = voteRepository.findByEmployeesCpfAndProposalId(employeesCpf, id);

        if (existingVote != null) {
            throw new RuntimeException("You have already voted on this proposal");
        }

        Proposal proposal = proposalFeign.findById(id);
        Employees employees = employeesFeign.findByCpf(employeesCpf);

        if(validateVoto(employees.getCpf()) == Erole.nao_pode_votar){
            throw new RuntimeException("Must be above eighteen to vote");
        }

        Vote vote = new Vote();
        vote.setEmployeesCpf(employees.getCpf());
        vote.setProposalId(proposal.getId());
        vote.setStatus(status);
        voteRepository.save(vote);
    }

    public List<Vote> searchAllvote(){
        List<Vote> votes = voteRepository.findAll();
        return votes;
    }

}
