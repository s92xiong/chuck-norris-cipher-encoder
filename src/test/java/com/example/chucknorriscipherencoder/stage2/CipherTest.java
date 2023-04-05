package com.example.chucknorriscipherencoder.stage2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CipherTest {
    @Test
    void convertCharToASCII() {
        assertAll(
                () -> assertEquals(97, Cipher.convertCharToASCII('a')),
                () -> assertEquals(98, Cipher.convertCharToASCII('b')),
                () -> assertEquals(99, Cipher.convertCharToASCII('c')),
                () -> assertEquals(65, Cipher.convertCharToASCII('A')),
                () -> assertEquals(66, Cipher.convertCharToASCII('B')),
                () -> assertEquals(67, Cipher.convertCharToASCII('C'))
        );
    }

    @Test
    void convertAsciiToBinary() {
        assertAll(
                () -> assertEquals("1100001", Cipher.convertAsciiToBinary(97)),
                () -> assertEquals("1100010", Cipher.convertAsciiToBinary(98)),
                () -> assertEquals("1100011", Cipher.convertAsciiToBinary(99)),
                () -> assertEquals("1000001", Cipher.convertAsciiToBinary(65)),
                () -> assertEquals("1000010", Cipher.convertAsciiToBinary(66)),
                () -> assertEquals("1000011", Cipher.convertAsciiToBinary(67))
        );
    }
}