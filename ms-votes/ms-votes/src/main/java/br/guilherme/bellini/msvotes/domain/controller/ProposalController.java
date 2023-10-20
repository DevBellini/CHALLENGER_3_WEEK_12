package br.guilherme.bellini.msvotes.domain.controller;

import br.guilherme.bellini.msvotes.domain.feign.ProposalFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "proposal-info")
@RequiredArgsConstructor
@Slf4j
public class ProposalController {

    private final ProposalFeign proposalFeign;

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        var proposal = proposalFeign.findById(id);
        return ResponseEntity.ok(proposal);
    }

    @GetMapping
    public ResponseEntity<List<Proposal>> searchAllProposal(){
        List<Proposal> list = proposalFeign.searchAllProposal();
        return ResponseEntity.ok(list);
    }
}
