package tudelft.mirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MirrorTest {
    private Mirror mirror;

    @BeforeEach
    public void initialize(){
        mirror = new Mirror();
    }
    @Test
    public void CeroMirror(){
        String result = mirror.mirrorEnds("ab");
        Assertions.assertTrue(result.isEmpty());
    }
    @ParameterizedTest
    @CsvSource({"a", "aa", "aba", "abba", "abXXba", "abXYXba"})
    public void AllMirror(String word){
        String result = mirror.mirrorEnds(word);
        Assertions.assertEquals(word, result);
    }

    @ParameterizedTest
    @CsvSource({"abca, a", "abXYZba, ab", "abXZba, ab"})
    public void SubMirror(String word, String expected){
        String result = mirror.mirrorEnds(word);
        Assertions.assertEquals(expected, result);
    }
}
