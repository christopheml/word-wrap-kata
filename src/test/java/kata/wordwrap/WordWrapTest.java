package kata.wordwrap;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordWrapTest {

    @Test
    public void should_not_wrap_if_sentence_smaller_than_width() {
        String result = WordWrap.wrap("a simple test", 200);
        assertThat(result).isEqualTo("a simple test");
    }

    @Test
    public void should_wrap_inside_word_if_word_larger_than_with() {
        String result = WordWrap.wrap("absolutely", 4);
        assertThat(result).isEqualTo("abso\nlute\nly");
    }

    @Test
    public void should_not_wrap_if_word_exactly_as_large_as_width() {
        String result = WordWrap.wrap("absolutely", 12);
        assertThat(result).isEqualTo("absolutely");
    }

}
