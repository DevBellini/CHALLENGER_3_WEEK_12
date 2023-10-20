package br.guilherme.bellini.msproposal.api.mapper;

import br.guilherme.bellini.msproposal.api.request.ProposalRequest;
import br.guilherme.bellini.msproposal.api.response.ProposalResponse;
import br.guilherme.bellini.msproposal.domain.entity.Proposal;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProposalMapper {

    private final ModelMapper mapper;

    public Proposal toProposal(ProposalRequest proposalRequest){
        return mapper.map(proposalRequest, Proposal.class);
    }

    public ProposalResponse toProposalResponse(Proposal proposal){
        return mapper.map(proposal, ProposalResponse.class);
    }
}
