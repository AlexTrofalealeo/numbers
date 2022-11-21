import com.aor.numbers.GenericListFilter
import com.aor.numbers.ListFilterer
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito
import spock.lang.Specification

class ListFiltererSpockTest extends Specification {
    def "testing filter"(){
        given:
        def lista = Arrays.asList(-2,0,1,2,3,4)
        def num = Mock(GenericListFilter.class);
        num.accept(-2)>>false
        num.accept(0)>>false
        num.accept(1)>>false
        num.accept(2)>>true
        num.accept(3)>>false
        num.accept(4)>>true
        when:
        def filterer = new ListFilterer(num)
        then:
        Arrays.asList(2,4)==filterer.filter(lista)
    }
}