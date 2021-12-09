package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

 class StringCalcTest {

    @Test

    void givenEmptyStringShouldReturnZero(){
        assertThat(StringCalc.add("")).isZero();
    }

    @Test

    void givenThreeStringNumbersAndCommaAsDefaultDelimiterInputShouldReturnTheSum(){
        assertThat(StringCalc.add("1,2,5")).isEqualTo(8);
    }
     @Test

     void givenOneNumber() {
         assertThat(StringCalc.add("1")).isEqualTo(1);
     }
    @Test

    void givenThreeStringNumbersWithNewLineShouldReturnTheSum(){
        assertThat(StringCalc.add("1\n2,5")).isEqualTo(8);
    }

    @Test
    void givenTwoBackslashToDefineSemicolonAsNewDelimiterAndTwoNumbersShouldReturnTheSum(){
        assertThat(StringCalc.add("//;\n1;2")).isEqualTo(3);

    }

    @Test( )
    void givenNegativeNumbersShouldReturnIllegalArgumentException(){

        var result =  assertThrows(IllegalArgumentException.class,()-> StringCalc.add("0,1,2,-1,-55"));

        assertEquals("Negatives not allowed: [-1, -55]",result.getMessage());

    }

    @Test
    void givenNumbersOver1000ShouldBeIgnored(){
        assertThat(StringCalc.add("1,1001,1000")).isEqualTo(1001);
    }

    @Test
    void givenAInputsWithNewAsteriskDelimiter(){
        assertThat(StringCalc.add("//[***]\n1***2***3")).isEqualTo(6);

    }

    @Test
    void givenAInputsWithTwoDelimitersAsteriskAndPercent(){

        assertThat(StringCalc.add("//[***][%]\n1***2%1%3")).isEqualTo(7);

    }


}

