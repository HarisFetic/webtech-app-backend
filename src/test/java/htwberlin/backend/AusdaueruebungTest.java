package htwberlin.backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AusdaueruebungTest {

    @Test
    void testToString() {
        //Eingabedaten
        String name = "laufen";
        int time = 30;
        boolean confirm = false;

        //"System under test" aufsetzen
        Ausdaueruebung ausdaueruebung = new Ausdaueruebung(name, time, confirm);
        ausdaueruebung.setId(42L);

        //Erwartetes Ergebnis
        String expected = "Ausdaueruebung{id=42, name='laufen', time=30', confirm='false}";

        //Tatsächliches Ergebnis
        String actual = ausdaueruebung.toString();

        //Vergleich
        assertEquals(expected, actual);
    
}
}