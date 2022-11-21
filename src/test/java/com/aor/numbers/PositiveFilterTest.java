package com.aor.numbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import java.util.Arrays;
import java.util.List;

public class PositiveFilterTest {
    @Test
    public void Positive(){
        PositiveFilter yh = new PositiveFilter();
        List<Integer> pos = Arrays.asList(1,2,3,4,5,6);
        List<Integer> nPos = Arrays.asList(0,-1,-2,-3,-4,-5,-6);
        for(int x:pos){Assertions.assertTrue(yh.accept(x));}
        for(int x:nPos){Assertions.assertFalse(yh.accept(x));}
    }
}
