package br.guilherme.bellini.msproposal.domain.service;
import br.guilherme.bellini.msproposal.domain.entity.Proposal;
import br.guilherme.bellini.msproposal.domain.repository.ProposalRepository;
import br.guilherme.bellini.msproposal.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProposalService {

    private final ProposalRepository repository;

    private final ModelMapper mapper;

    @Transactional
    public Proposal save(Proposal proposal){
        if (proposal.getProposal().trim().isEmpty()) {
            throw new BusinessException("proposal cannot be nully!");
        }
        return repository.save(proposal);
    }

    public Optional<Proposal> findById(Long id){
        return repository.findById(id);
    }


    public List<Proposal> searchAllProposal() {
        List<Proposal> proposals = repository.findAll();
        return proposals.stream()
                .map(proposal -> mapper.map(proposal, Proposal.class))
                .collect(Collectors.toList());
    }
}
