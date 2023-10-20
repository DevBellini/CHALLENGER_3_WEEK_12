package br.guilherme.bellini.msvotes.domain.entity;

import br.guilherme.bellini.msvotes.domain.enums.Status;
import lombok.Data;

@Data
public class StatusRequest {

    Status status;
}
