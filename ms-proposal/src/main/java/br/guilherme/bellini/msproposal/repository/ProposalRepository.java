package br.guilherme.bellini.msproposal.repository;

import br.guilherme.bellini.msproposal.entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {

    Optional<Proposal> findById(Long id);
}
