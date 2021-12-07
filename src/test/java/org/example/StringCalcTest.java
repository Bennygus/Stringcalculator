package org.example;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


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

    @Test( )
    void givenNegativNumbersShouldReturnIllegalArgumentException(){

        var result =  assertThrows(IllegalArgumentException.class,()-> StringCalc.add("1,2,-2,-55"));

        assertEquals("Negatives not allowed: [-2, -55]",result.getMessage());

    }

    @Test
    void givenNumbersOver1000ShouldBeIgnored(){
        assertThat(StringCalc.add("1,2000,1000")).isEqualTo(1001);
    }

    @Test
    void givenAInputsWithNewDelimiter(){
        assertThat(StringCalc.add("//[***]\n1***2***3")).isEqualTo(6);

    }


}

