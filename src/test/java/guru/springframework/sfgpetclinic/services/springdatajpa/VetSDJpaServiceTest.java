package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.repositories.VetRepository;

@ExtendWith(MockitoExtension.class)
public class VetSDJpaServiceTest {

    @Mock VetRepository vetRepository;

    @InjectMocks VetSDJpaService vetSDJpaService;

    @Test
    void deleteById(){
        vetSDJpaService.deleteById(1l);

        verify(vetRepository, only()).deleteById(1l);
    }
}
