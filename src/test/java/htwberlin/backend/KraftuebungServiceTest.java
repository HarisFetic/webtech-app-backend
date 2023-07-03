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
public class KraftuebungServiceTest {

    @Autowired
    private KraftuebungService service;

    @MockBean
    private KraftuebungRepository repository;

    @Test
    @DisplayName("should find a kraftuebung by its id")
    void testGet() {
        var t1 = new Kraftuebung("pushups", 99, "koerpergewicht", false);
        var t2 = new Kraftuebung("situps", 99, "20", false);
        doReturn(Optional.of(t1)).when(repository).findById(42L);
        doReturn(Optional.of(t2)).when(repository).findById(43L);

        Kraftuebung actual = service.get(42L);

        assertEquals(actual.getRepeat(), 99);
    }
}

