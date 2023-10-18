package br.guilherme.bellini.msproposal.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProposalResponse {

    private Long id;
    private String proposal;
}
