package br.guilherme.bellini.msvotes.domain.feign;

import br.guilherme.bellini.msvotes.domain.entity.Proposal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "ms-proposal", path = "proposal")
@Component
public interface ProposalFeign {

    @GetMapping(value = "{id}")
    Proposal findById(@PathVariable("id") Long id);

    @GetMapping()
    public List<Proposal> searchAllProposal();
}