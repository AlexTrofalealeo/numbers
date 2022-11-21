package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    @Test
    public void filter() {
        List<Integer> lista = Arrays.asList(-2,0,1,2,3,4);
        GenericListFilter num = Mockito.mock(GenericListFilter.class);
        Mockito.when(num.accept(-2)).thenReturn(false);
        Mockito.when(num.accept(0)).thenReturn(false);
        Mockito.when(num.accept(1)).thenReturn(false);
        Mockito.when(num.accept(2)).thenReturn(true);
        Mockito.when(num.accept(3)).thenReturn(false);
        Mockito.when(num.accept(4)).thenReturn(true);
        ListFilterer filterer = new ListFilterer(num);
        Assertions.assertEquals(Arrays.asList(2,4), filterer.filter(lista));
    }
}
