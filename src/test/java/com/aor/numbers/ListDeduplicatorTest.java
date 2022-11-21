package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    public List<Integer> sacaAiDaLista(){
        return Arrays.asList(1,2,4,2,5);
    }

    @Test
    public void deduplicate() {
        List<Integer> expected = Arrays.asList(1,2,4,5);
        GenericListSorter sorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(sorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1,2,2,4,5));
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(sacaAiDaLista());

        Assertions.assertEquals(expected, distinct);
    }
    @Test
    public void bug_deduplicate_8726() {
        List<Integer> expected = Arrays.asList(1,2,4);
        List<Integer> list = Arrays.asList(1,2,4,2);
        GenericListSorter sorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(sorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1,2,2,4));
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected,distinct);
    }

}
