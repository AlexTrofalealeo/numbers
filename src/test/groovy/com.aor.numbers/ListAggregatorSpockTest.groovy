import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListAggregator
import com.aor.numbers.ListDeduplicator
import com.aor.numbers.ListSorter
import org.junit.jupiter.api.Assertions
import spock.lang.Specification

class ListAggregatorSpockTest extends Specification {
    private def list=Arrays.asList(1,2,4,2,5)
    def "testing sum"(){
        given:
        def aggregator = new ListAggregator()
        when:
        def sum = aggregator.sum(list);
        then:
        sum==14
    }
    def "testing max"(){
        given:
        def aggregator = new ListAggregator()
        when:
        def max = aggregator.max(list);
        then:
        max==5
    }
    def "testing min"(){
        given:
        def aggregator = new ListAggregator()
        when:
        def min = aggregator.min(list);
        then:
        min==1
    }
    def "testing distinct"() {
        given:
        def aggregator = new ListAggregator()
        def deduplicator = new ListDeduplicator(new ListSorter())
        when:
        def distinct = aggregator.distinct(list,deduplicator)
        then:
        distinct == 4
    }
    def "testing max bug 7263"(){
        given:
        def aggregator = new ListAggregator()
        when:
        def max = aggregator.max(Arrays.asList(-1, -4, -5));
        then:
        max==-1
    }
    def "testing distinct bug 8726"() {
        given:
        def aggregator = new ListAggregator()
        def deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(_) >> Arrays.asList(1, 2, 4)
        when:
        def distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2),deduplicator)
        then:
        distinct == 3

    }
}