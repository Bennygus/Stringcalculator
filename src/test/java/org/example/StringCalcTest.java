package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalcTest {

    @Test

    void givenEmptyStringShouldReturnZero(){
        assertThat(StringCalc.add("")).isEqualTo(0);
    }



    @Test

    void givenThreeStringInputShouldReturnTheSum(){
        assertThat(StringCalc.add("1,2,5")).isEqualTo(8);
    }
    @Test

    void givenThreeStringInputWithNewLineShouldReturnTheSum(){
        assertThat(StringCalc.add("1\n2,5")).isEqualTo(8);
    }

}

