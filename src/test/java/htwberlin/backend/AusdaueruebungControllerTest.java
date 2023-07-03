package htwberlin.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AusdaueruebungController.class)
public class AusdaueruebungControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AusdaueruebungService service;

    @Test
    public void testGetRoute() throws Exception {
        //Test Daten und Service Mock
        Ausdaueruebung t1 = new Ausdaueruebung("laufen", 99, false);
        t1.setId(42L);
        when(service.get(42L)).thenReturn(t1);

        //Erwartetes Ergebnis
        String expected = "{\"id\":42,\"name\":\"laufen\",\"time\":99,\"confirm\":false}";


        //Aufruf und Vergleich
        this.mockMvc.perform(get("/ausdaueruebungen/42"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }
}

