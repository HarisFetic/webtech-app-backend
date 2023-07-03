package htwberlin.backend;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class AusdaueruebungServiceTest {

    @Autowired
    private AusdaueruebungService service;

    @MockBean
    private AusdaueruebungRepository repository;

    @Test
    @DisplayName("should find a ausdaueruebung by its id")
    void testGet() {
        var t1 = new Ausdaueruebung("laufen", 99, false);
        var t2 = new Ausdaueruebung("joggen", 60, false);
        doReturn(Optional.of(t1)).when(repository).findById(42L);
        doReturn(Optional.of(t2)).when(repository).findById(43L);

        Ausdaueruebung actual = service.get(42L);

        assertEquals(actual.getTime(), 99);
    }
}

