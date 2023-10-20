package br.guilherme.bellini.msemployees.domain.service.domain;
import br.guilherme.bellini.msemployees.domain.entity.Employees;
import br.guilherme.bellini.msemployees.domain.repository.EmployeesRepository;
import br.guilherme.bellini.msemployees.domain.service.EmployeesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static br.guilherme.bellini.msemployees.domain.service.domain.common.EmployeesConstants.employees;
import static br.guilherme.bellini.msemployees.domain.service.domain.common.EmployeesConstants.invalid_employees;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest(classes = EmployeesService.class)
public class EmployeesServiceTest {

    //@Autowired
    @InjectMocks
    private EmployeesService employeesService;

    //@MockBean
    @Mock
    private EmployeesRepository employeesRepository;


    //operacao_estado_retorno
    @Test
    public void saveEmployees_WithValidData_ReturnsEmployees() {
        when(employeesRepository.save(employees)).thenReturn(employees);
        Employees sut = employeesService.save(employees);
        assertThat(sut).isEqualTo(employees);
    }
    @Test
    public void saveEmployees_WithInvalidData_ThrowsException(){
        lenient().when(employeesRepository.save(invalid_employees)).thenThrow(RuntimeException.class);
        assertThatThrownBy(() -> employeesService.save(invalid_employees)).isInstanceOf(RuntimeException.class);
    }
    @Test
    public void getEmployees_ByExistingCpf_ReturnsEmployees(){
        when(employeesRepository.findByCpf("01234567890")).thenReturn(Optional.of(employees));
        Optional<Employees> sut = employeesService.getByCpf("01234567890");
        assertThat(sut).isNotEmpty();
        assertThat(sut.get()).isEqualTo(employees);

    }
    @Test
    public void getEmployees_ByUnexistingCpf_ReturnsEmployees(){
        when(employeesRepository.findByCpf(employees.getCpf())).thenReturn(Optional.empty());
        Optional<Employees> sut = employeesService.getByCpf(employees.getCpf());
        assertThat(sut).isEmpty();
    }

}



