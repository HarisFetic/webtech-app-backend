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

@WebMvcTest(KraftuebungController.class)
public class KraftuebungControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private KraftuebungService service;

    @Test
    public void testGetRoute() throws Exception {
        //Test Daten und Service Mock
        Kraftuebung t1 = new Kraftuebung("pushups", 99, "koerpergewicht", false);
        t1.setId(42L);
        when(service.get(42L)).thenReturn(t1);

        //Erwartetes Ergebnis
        String expected = "{\"id\":42,\"name\":\"pushups\",\"repeat\":99,\"weight\":\"koerpergewicht\",\"confirm\":false}";


        //Aufruf und Vergleich
        this.mockMvc.perform(get("/kraftuebungen/42"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }
}

