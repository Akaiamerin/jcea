package exp2;
import static exp2.Exp2.leastCommonMultiple;
import org.junit.Assert;
import org.junit.Test;
public class Exp2Test {
    @Test
    public void leastCommonMultipleTest() {
        Assert.assertEquals(12, leastCommonMultiple(4, 6));
        Assert.assertEquals(24, leastCommonMultiple(4, 6));
    }
}