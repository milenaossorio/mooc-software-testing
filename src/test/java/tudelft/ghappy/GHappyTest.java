package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {

    private GHappy ghappy;

    @BeforeEach
    public void initialize() {
        this.ghappy = new GHappy();
    }

    @ParameterizedTest
    @CsvSource({ "gg", "asdfgg", "ggasfa", "dsgggsdsdf", "asdfggggdasfggsdf" })
    public void isHappy(String s) {
        boolean result = ghappy.gHappy(s);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({ "g", "asdfg", "gasfa", "dsggagsdsdf", "asdfgkgggdasfggsdf" })
    public void isNotHappy(String s) {
        boolean result = ghappy.gHappy(s);
        Assertions.assertFalse(result);
    }

    @Test
    public void isHappy1() {
        boolean result = ghappy.gHappy("");
        Assertions.assertTrue(result);
    }
}
