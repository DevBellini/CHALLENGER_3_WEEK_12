package br.guilherme.bellini.msvotes.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proposal {

    private Long id;
    private String proposal;
    private LocalTime time;
    private String result;
    private boolean open;

}
