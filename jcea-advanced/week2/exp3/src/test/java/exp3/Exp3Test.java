package exp3;
import static exp3.Exp3.verifyEmail;
import static exp3.Exp3.verifyQQ;
import static exp3.Exp3.verifyTel;
import org.junit.Assert;
import org.junit.Test;
public class Exp3Test {
    @Test
    public void verifyEmailTest() {
        Assert.assertTrue(verifyEmail("114514@qq.com"));
    }
    @Test
    public void verifyTelTest() {
        Assert.assertTrue(verifyTel("19198101919"));
    }
    @Test
    public void verifyQQTest() {
        Assert.assertTrue(verifyQQ("114514"));
    }
}