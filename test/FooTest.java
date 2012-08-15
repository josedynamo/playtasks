import org.junit.Test;
import play.mvc.Result;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class FooTest {

    @Test
    public void testFooRoute() {
        Result result = routeAndCall(fakeRequest(GET, "/foo"));
        assertThat(result).isNotNull();
    }

}