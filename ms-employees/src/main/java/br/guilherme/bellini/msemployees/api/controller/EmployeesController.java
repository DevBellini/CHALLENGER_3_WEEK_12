package br.guilherme.bellini.msemployees.api.controller;

import br.guilherme.bellini.msemployees.api.mapper.EmployeesMapper;
import br.guilherme.bellini.msemployees.api.request.EmployeesRequest;
import br.guilherme.bellini.msemployees.api.response.EmployeesResponse;
import br.guilherme.bellini.msemployees.domain.entity.Employees;
import br.guilherme.bellini.msemployees.domain.service.EmployeesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Slf4j
public class EmployeesController {

    private final EmployeesService service;

    private final EmployeesMapper mapper;

    @PostMapping
    public ResponseEntity<EmployeesResponse> save(@Valid @RequestBody EmployeesRequest employeesRequest){
        Employees employees = mapper.toEmployees(employeesRequest);
        Employees EmployeesSave = service.save(employees);
        EmployeesResponse employeesResponse = mapper.toEmployeesResponse(EmployeesSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeesResponse);
    }

    @GetMapping("{cpf}")
    public ResponseEntity<EmployeesResponse> FindByCpf(@PathVariable("cpf") String cpf){
        Optional<Employees> optEmployees = service.getByCpf(cpf);
        if ((optEmployees.isEmpty())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toEmployeesResponse(optEmployees.get()));
    }
}
