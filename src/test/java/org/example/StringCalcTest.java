package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalcTest {

    @Test

    void givenEmptyStringShouldReturnZero(){
        assertThat(StringCalc.add("")).isEqualTo(0);
    }



    @Test

    void givenThreeStringNumbersAndCommaAsDelimiterInputShouldReturnTheSum(){
        assertThat(StringCalc.add("1,2,5")).isEqualTo(8);
    }
    @Test

    void givenThreeStringNumbersAndCommaAsDelimiterInputWithNewLineShouldReturnTheSum(){
        assertThat(StringCalc.add("1\n2,5")).isEqualTo(8);
    }

    @Test
    void givenTwoNumbersAndSemicolonAsNewDelimiterInputWithNewLineShouldReturnTheSum(){
        assertThat(StringCalc.add("//;\n1;2")).isEqualTo(3);

    }

}

