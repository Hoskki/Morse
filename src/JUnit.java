import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextToMorseTest {

    @Test
    void testConvertToMorse_validText() {
        String text = "HELLO";
        String expected = ".... . .-.. .-.. ---";
        assertEquals(expected, TextToMorse.convertToMorse(text));
    }

    @Test
    void testConvertToMorse_invalidCharacter() {
        String text = "HELLO!";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TextToMorse.convertToMorse(text);
        });
        assertEquals("Ogiltigt tecken: !", exception.getMessage());
    }

    @Test
    void testConvertToMorse_emptyInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TextToMorse.convertToMorse("");
        });
        assertEquals("Texten får inte vara tom.", exception.getMessage());
    }

    @Test
    void testConvertToText_validMorse() {
        String morse = ".... . .-.. .-.. ---";
        String expected = "HELLO";
        assertEquals(expected, TextToMorse.convertToText(morse));
    }

    @Test
    void testConvertToText_invalidMorse() {
        String morse = ".... . .-.. .-.. --- @";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TextToMorse.convertToText(morse);
        });
        assertEquals("Ogiltig morsekod: @", exception.getMessage());
    }
}
