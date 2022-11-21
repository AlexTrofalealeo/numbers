package com.aor.numbers

import org.junit.jupiter.api.Assertions
import spock.lang.Specification

class ListSorterSpockTest extends Specification {
    private def list = Arrays.asList(3, 2, 6, 1, 4, 5, 7)
    def "testing sort"(){
        given:
        def expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7)
        def sorter = new ListSorter()
        when:
        def sorted = sorter.sort(list)
        then:
        expected==sorted
    }
    def "testing sort bug8726"(){
        given:
        def expected = Arrays.asList(1, 2, 2, 4)
        def sorter = new ListSorter()
        when:
        def sorted = sorter.sort(Arrays.asList(1, 2, 4, 2));
        then:
        expected==sorted
    }
}
