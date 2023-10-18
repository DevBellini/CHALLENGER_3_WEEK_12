package br.guilherme.bellini.msproposal;
import br.guilherme.bellini.msproposal.domain.entity.Proposal;
import br.guilherme.bellini.msproposal.domain.repository.ProposalRepository;
import br.guilherme.bellini.msproposal.domain.service.ProposalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import java.util.Optional;
import static br.guilherme.bellini.msproposal.common.ProposalConstants.invalid_proposal;
import static br.guilherme.bellini.msproposal.common.ProposalConstants.proposal;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProposalServiceTest {

    @InjectMocks
    private ProposalService proposalService;

    @Mock
    private ProposalRepository proposalRepository;

    private ModelMapper mapper;

    @Test
    public void saveProposal_WithValidData_ReturnsProposal() {
        when(proposalRepository.save(proposal)).thenReturn(proposal);
        Proposal sut = proposalService.save(proposal);
        assertThat(sut).isEqualTo(proposal);
    }

    @Test
    public void saveProposal_WithInvalidData_ThrowsException(){
        lenient().when(proposalRepository.save(invalid_proposal)).thenThrow(RuntimeException.class);
        assertThatThrownBy(() -> proposalService.save(invalid_proposal)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void getProposal_ByExistingId_ReturnsProposal(){
        when(proposalRepository.findById(1L)).thenReturn(Optional.of(proposal));
        Optional<Proposal> sut = proposalService.findById(1L);
        assertThat(sut).isNotEmpty();
        assertThat(sut.get()).isEqualTo(proposal);
    }

    @Test
    public void getProposal_ByUnexistingId_ReturnsProposal(){
        when(proposalRepository.findById(proposal.getId())).thenReturn(Optional.empty());
        Optional<Proposal> sut = proposalService.findById(proposal.getId());
        assertThat(sut).isEmpty();
    }

}


