package br.guilherme.bellini.msproposal.api.controller;

import br.guilherme.bellini.msproposal.api.mapper.ProposalMapper;
import br.guilherme.bellini.msproposal.api.request.ProposalRequest;
import br.guilherme.bellini.msproposal.api.response.ProposalResponse;
import br.guilherme.bellini.msproposal.domain.entity.Proposal;
import br.guilherme.bellini.msproposal.domain.service.ProposalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/proposal")
@RequiredArgsConstructor
@Slf4j
public class ProposalController {

    private final ProposalService service;
    private final ProposalMapper mapper;
    @PostMapping
    public ResponseEntity<ProposalResponse> save(@Valid @RequestBody ProposalRequest proposalRequest){
        Proposal proposal = mapper.toProposal(proposalRequest);
        Proposal ProposalSave = service.save(proposal);
        ProposalResponse proposalResponse = mapper.toProposalResponse(ProposalSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(proposalResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProposalResponse> SearchForId(@PathVariable("id") Long id) {
        log.info("performing search by id: {}", id);
        return service.findById(id)
                .map(mapper::toProposalResponse)
                .map(proposalResponse -> ResponseEntity.status(HttpStatus.OK).body(proposalResponse))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Proposal>> searchAllProposal(){
    List<Proposal> proposal = service.searchAllProposal();
    return ResponseEntity.ok(proposal);
    }

}

