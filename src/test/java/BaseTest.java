import org.junit.AfterClass;
import org.junit.BeforeClass;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    @BeforeClass
    public void setUp() {
        open("http://gmail.com");
    }

    @AfterClass
    public void tearDown() {

    }
}
