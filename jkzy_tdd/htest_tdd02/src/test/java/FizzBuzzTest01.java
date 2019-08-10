/**
 * @program: htesttdd
 * @description:
 * @author: hzhang
 * @create: 2019-08-09 23:00
 **/
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * @program: htesttdd
 * @description:
 * @author: hzhang
 * @create: 2019-08-09 22:50
 **/
public class FizzBuzzTest01 {
    @Test
    public void test_Regular_number(){
        Gamenumber name = new Gamenumber("1");
        assertthat(name.getValue(), is("1"));
    }


}

