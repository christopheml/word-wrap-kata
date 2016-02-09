package kata.wordwrap;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordWrapTest {

    @Test
    public void test_no_wrap() {
        String result = WordWrap.wrap("a simple test", 200);
        assertThat(result).isEqualTo("a simple test");
    }

}
