package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CaesarShiftCipherTest {
    private CaesarShiftCipher caesarShiftCipher;

    @BeforeEach
    public void initialize() {
        this.caesarShiftCipher = new CaesarShiftCipher();
    }

    @ParameterizedTest
    @CsvSource({ "'no shift', 0, 'no shift'", "'noshift', 0, 'noshift'" })
    public void noShift(String message, int shift, String expected) {
        String result = caesarShiftCipher.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({ "'abc', -1, 'zab'", "'aa ad', -2, 'yy yb'" })
    public void leftShift(String message, int shift, String expected) {
        String result = caesarShiftCipher.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({ "'abc', -27, 'zab'", "'aa ad', -28, 'yy yb'" })
    public void tooBigleftShift(String message, int shift, String expected) {
        String result = caesarShiftCipher.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({ "'xyz', 1, 'yza'", "'zz zd', 2, 'bb bf'" })
    public void rightShift(String message, int shift, String expected) {
        String result = caesarShiftCipher.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({ "'xyz', 27, 'yza'", "'zz zd', 28, 'bb bf'" })
    public void tooBigRightShift(String message, int shift, String expected) {
        String result = caesarShiftCipher.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(expected, result);
    }

}
