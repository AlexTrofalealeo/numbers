package com.aor.numbers;

import java.util.List;
import java.util.ArrayList;


public class ListFilterer {
    private final GenericListFilter filter;
    public ListFilterer(GenericListFilter filter) {
        this.filter=filter;
    }
    public List<Integer> filter(List<Integer> list){
        List<Integer> lista = new ArrayList<>();
        for (int j:list){
            if (filter.accept(j)){
                lista.add(j);
            }
        }
        return lista;
    }


}
