package stage4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DecipherTest {
    @Test
    void decipherIntoBinaryChunks() {
        String[] arr = { "0", "0", "00", "0000" };
        List<String> list = new ArrayList<>(Arrays.asList("1", "0000"));
        assertEquals(list, Decipher.decipherIntoBinaryChunks(arr));
    }

    @Test
    void duplicateChar() {
        assertEquals("0000", Decipher.duplicateChar('0', 4));
    }

    @Test
    void splitStringIntoSubstrings() {
        List<String> list = new ArrayList<>(Arrays.asList("1000011", "1000011"));
        assertEquals(list, Decipher.splitStringIntoSubstrings("10000111000011", 7));
    }

    @Test
    void binaryToChar() {
        List<String> list = new ArrayList<>(Arrays.asList("1000011", "1000011"));
        assertEquals("CC", Decipher.binaryToChar(list));
    }
}