import com.aor.numbers.GenericListSorter
import com.aor.numbers.ListDeduplicator
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito
import spock.lang.Specification

class ListDeduplicatorSpockTest extends Specification {
    private def list=Arrays.asList(1,2,4,2,5)
    def "testing deduplicate"() {
        given:
        def expected = Arrays.asList(1,2,4,5);
        GenericListSorter sorter = Mock(GenericListSorter.class);
        sorter.sort(_)>>Arrays.asList(1,2,2,4,5)
        def deduplicator = new ListDeduplicator(sorter);
        when:
        def distinct = deduplicator.deduplicate(list);
        then:
        expected==distinct
    }
    def "testing deduplicate bug 8726"(){
        given:
        def expected = Arrays.asList(1,2,4)
        def lista = Arrays.asList(1,2,4,2)
        def sorter = Mock(GenericListSorter.class)
        sorter.sort(_)>>Arrays.asList(1,2,2,4)
        def deduplicator = new ListDeduplicator(sorter)
        when:
        def distinct = deduplicator.deduplicate(lista);
        then:
        expected==distinct
    }
}