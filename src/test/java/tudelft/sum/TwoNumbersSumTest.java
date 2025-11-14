package tudelft.sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoNumbersSumTest {
    private TwoNumbersSum twoNumbersSum;

    @BeforeEach
    public void initialize(){
        twoNumbersSum = new TwoNumbersSum();
    }

    @Test
    public void firstSmallerThanSecond(){
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(2));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(3, 7));
        ArrayList<Integer> result = twoNumbersSum.addTwoNumbers(first, second);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3, 9));
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void firstSmallerThanSecondAcarreo(){
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(8));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(1, 3, 2));
        ArrayList<Integer> result = twoNumbersSum.addTwoNumbers(first, second);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 4, 0));
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void firstEqualSecond(){
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(3, 4));
        ArrayList<Integer> result = twoNumbersSum.addTwoNumbers(first, second);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(4, 6));
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void firstEqualSecondAcarreoBeginning(){
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(9, 9));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(9, 9));
        ArrayList<Integer> result = twoNumbersSum.addTwoNumbers(first, second);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 9, 8));
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void firstEqualSecondAcarreoEnd(){
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3, 9, 9));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(1, 1, 1, 9, 1));
        ArrayList<Integer> result = twoNumbersSum.addTwoNumbers(first, second);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 3, 5, 9, 0));
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void firstGreaterThanSecond(){
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(4));
        ArrayList<Integer> result = twoNumbersSum.addTwoNumbers(first, second);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 6));
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void firstGreaterThanSecondAcarreo(){
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 6));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(4));
        ArrayList<Integer> result = twoNumbersSum.addTwoNumbers(first, second);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 0));
        Assertions.assertEquals(expected, result);
    }

}
