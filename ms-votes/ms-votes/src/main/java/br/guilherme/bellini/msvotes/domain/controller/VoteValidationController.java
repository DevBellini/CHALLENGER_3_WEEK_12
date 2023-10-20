package br.guilherme.bellini.msvotes.domain.controller;

import br.guilherme.bellini.msvotes.domain.entity.StatusRequest;
import br.guilherme.bellini.msvotes.domain.entity.Vote;
import br.guilherme.bellini.msvotes.domain.enums.Erole;
import br.guilherme.bellini.msvotes.domain.service.VoteValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vote-validation")
@RequiredArgsConstructor
@Slf4j
public class VoteValidationController {
    private final VoteValidationService voteValidationService;

    @GetMapping("employees-cpf/{cpf}")
    public Erole validateVoto(@PathVariable("cpf") String cpf) {
        return voteValidationService.validateVoto(cpf);
    }

    @PostMapping("employees-cpf/{cpf}/proposal/{id}")
    public ResponseEntity<String> vote(@PathVariable("cpf") String cpf, @PathVariable("id") Long id, @RequestBody StatusRequest statusRequest) {
        voteValidationService.vote(cpf, id, statusRequest.getStatus());
        return ResponseEntity.ok("Successful vote");
    }

    @GetMapping("result-votes")
    public List<Vote> searchAllvote() {
        List<Vote> votes = voteValidationService.searchAllvote();
        return votes;

    }
}