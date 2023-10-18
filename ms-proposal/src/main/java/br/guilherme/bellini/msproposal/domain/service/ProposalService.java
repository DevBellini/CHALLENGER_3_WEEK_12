package br.guilherme.bellini.msproposal.domain.service;

import br.guilherme.bellini.msproposal.domain.entity.Proposal;
import br.guilherme.bellini.msproposal.domain.repository.ProposalRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProposalService {

    private final ProposalRepository repository;

    private final ModelMapper mapper;

    @Transactional
    public Proposal save(Proposal proposal){
        return repository.save(proposal);
    }

    public Optional<Proposal> findById(Long id){
        return repository.findById(id);
    }
}
