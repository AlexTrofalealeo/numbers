import com.aor.numbers.PositiveFilter
import org.junit.jupiter.api.Assertions
import spock.lang.Specification

class PositiveFilterSpockTest extends Specification {
    def "testing Positive"(){
        given:
        def yh = new PositiveFilter()
        when:
        def pos = Arrays.asList(1,2,3,4,5,6)
        def nPos = Arrays.asList(0,-1,-2,-3,-4,-5,-6)
        then:
        for(int x:pos){true==yh.accept(x)}
        for(int x:nPos){false==yh.accept(x)}
    }
}