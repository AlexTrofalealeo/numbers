package com.aor.numbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import java.util.Arrays;
import java.util.List;

public class DivisibleByFilterTest {
    @Test
    public void DivisibleBy(){
        DivisibleByFilter num = new DivisibleByFilter(2);
        List<Integer> divisiveis = Arrays.asList(0,2,4,6,8,10);
        List<Integer> naoDivisiveis = Arrays.asList(1,3,5,7,9,11);
        for(int x:divisiveis){Assertions.assertTrue(num.accept(x));}
        for(int x:naoDivisiveis){Assertions.assertFalse(num.accept(x));}
    }
}
