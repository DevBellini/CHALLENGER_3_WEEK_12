package br.guilherme.bellini.msproposal.domain.repository;

import br.guilherme.bellini.msproposal.domain.entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {

    Optional<Proposal> findById(Long id);
}
