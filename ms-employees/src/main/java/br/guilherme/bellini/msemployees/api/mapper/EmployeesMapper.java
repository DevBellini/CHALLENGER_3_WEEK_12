package br.guilherme.bellini.msemployees.api.mapper;

import br.guilherme.bellini.msemployees.api.request.EmployeesRequest;
import br.guilherme.bellini.msemployees.api.response.EmployeesResponse;
import br.guilherme.bellini.msemployees.domain.entity.Employees;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeesMapper {

    private final ModelMapper mapper;

    public Employees toEmployees(EmployeesRequest employeesRequest){
        return mapper.map(employeesRequest, Employees.class);
    }
    public  EmployeesResponse toEmployeesResponse(Employees employees){
        return mapper.map(employees, EmployeesResponse.class);
    }
}

        /*public static Employees toEmployees(EmployeesRequest employeesRequest){
        Employees employees = new Employees();
        employees.setName(employeesRequest.getName());
        employees.setCpf(employeesRequest.getCpf());
        return employees;
    }*/

    /*public static EmployeesResponse toEmployeesResponse(Employees employees){
        EmployeesResponse employeesResponse = new EmployeesResponse();
        employeesResponse.setId(employeesResponse.getId());
        employeesResponse.setName(employees.getName());
        employeesResponse.setCpf(employees.getCpf());
        return employeesResponse;
    }*/

