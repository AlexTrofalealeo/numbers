import com.aor.numbers.DivisibleByFilter
import org.junit.jupiter.api.Assertions
import spock.lang.Specification

class DivisibleByFilterSpockTest extends Specification {
    def "testing DivisibleBy"(){
        given:
        def num = new DivisibleByFilter(2)
        when:
        def divisiveis = Arrays.asList(0,2,4,6,8,10)
        def naoDivisiveis = Arrays.asList(1,3,5,7,9,11)
        then:
        for(int x:divisiveis){true==num.accept(x)}
        for(int x:naoDivisiveis){false==num.accept(x)}
    }
}