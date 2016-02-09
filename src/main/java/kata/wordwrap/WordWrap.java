package kata.wordwrap;

public final class WordWrap {

    private WordWrap() {
    }

    public static String wrap(String sentence, int width) {
        if (sentence.length() <= width) {
            return sentence;
        }

        return actualWrap(sentence, width);
    }

    private static String actualWrap(String sentence, int width) {
        StringBuilder result = new StringBuilder();

        int position = width;
        while (position < sentence.length()) {
            result.append(sentence.substring(position - width, position));
            result.append("\n");
            position += width;
        }
        result.append(sentence.substring(position - width));

        return result.toString();
    }

}
