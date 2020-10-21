package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;

@ExtendWith(MockitoExtension.class)
public class VisitSDJpaServiceTest {

    @Mock VisitRepository visitRepository;

    @InjectMocks VisitSDJpaService service;

    Visit visit;

    @BeforeEach
    public void setUp(){
        visit = new Visit();
    }

    @Test
    public void findAll(){
        Set<Visit> visits = new HashSet<>();
        visits.add(visit);
        when(visitRepository.findAll()).thenReturn(visits);
        Set<Visit> foundVisits = service.findAll();
        verify(visitRepository).findAll();
        assertEquals(1, foundVisits.size());
    }

    @Test
    public void findById(){
        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));
        Visit foundVisit = service.findById(1l);
        verify(visitRepository).findById(anyLong());
        assertNotNull(foundVisit);
    }

    @Test
    public void save(){
        when(visitRepository.save(any(Visit.class))).thenReturn(visit);
        Visit savedVisit = service.save(new Visit());
        verify(visitRepository).save(any(Visit.class));
        assertNotNull(savedVisit);
    }

    @Test
    public void delete(){
        service.delete(visit);
        verify(visitRepository).delete(any(Visit.class));
    }

    @Test
    public void deleteById(){
        service.deleteById(1l);
        verify(visitRepository).deleteById(anyLong());
    }


}
