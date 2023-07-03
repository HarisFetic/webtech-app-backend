package htwberlin.backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KraftuebungTest {

    @Test
    void testToString() {
        //Eingabedaten
        String name = "pushups";
        int repeat = 99;
        String weight = "koerpergewicht";
        boolean confirm = false;

        //"System under test" aufsetzen
        Kraftuebung kraftuebung = new Kraftuebung(name, repeat, weight, confirm);
        kraftuebung.setId(42L);

        //Erwartetes Ergebnis
        String expected = "Kraftuebung{id=42, name='pushups', repeat=99', weight=koerpergewicht', confirm=false}";

        //Tatsächliches Ergebnis
        String actual = kraftuebung.toString();

        //Vergleich
        assertEquals(expected, actual);
    
}
}