package br.guilherme.bellini.msemployees.api.response.mapper;
import br.guilherme.bellini.msemployees.api.response.EmployeesResponse;
import br.guilherme.bellini.msemployees.api.response.request.EmployeesRequest;
import br.guilherme.bellini.msemployees.domain.entity.Employees;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeesMapper {

    private final ModelMapper mapper;

    public Employees toEmployees(EmployeesRequest employeesRequest){
        return mapper.map(employeesRequest,Employees.class);
    }

    public EmployeesResponse toEmployeesResponse(Employees employees){
        return mapper.map(employees, EmployeesResponse.class);
    }
}
