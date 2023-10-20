package br.guilherme.bellini.msproposal.common;

import br.guilherme.bellini.msproposal.domain.entity.Proposal;

public class ProposalConstants {

    public static final Proposal proposal = new Proposal(1L, "Devemos estudar Spring!");

    public static final Proposal invalid_proposal = new Proposal(null, null);

}
