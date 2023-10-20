package br.guilherme.bellini.msvotes.domain.repository;

import br.guilherme.bellini.msvotes.domain.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    Vote findByEmployeesCpfAndProposalId(String employeesCpf, Long proposalId);

}
