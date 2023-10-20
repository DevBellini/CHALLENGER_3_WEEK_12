package br.guilherme.bellini.msvotes.domain.controller;

import br.guilherme.bellini.msvotes.domain.enums.Erole;
import br.guilherme.bellini.msvotes.domain.service.VoteValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
