package kata.wordwrap;

public final class WordWrap {

    private WordWrap() {
    }

    /**
     * Split a sentence ine lines to fit a given width.
     *
     * The algorithm will try to split at the last space of a line, replacing the space with a newline, or in the
     * middle of a word if none available.
     *
     * @param sentence Sentence to split
     * @param width Width of a line
     * @return Split sentence with lines no longer that the provided width
     */
    public static String wrap(String sentence, int width) {
        if (sentence.length() <= width) {
            return sentence;
        }

        return splitSentence(sentence, width);
    }

    /**
     * Splits the sentence when needed.
     *
     * This implementation only creates one new {@code String} by line.
     */
    private static String splitSentence(String sentence, int width) {
        StringBuilder result = new StringBuilder();

        int origin = 0;
        int position = getNextSplitPosition(sentence, 0, width);
        while (position < sentence.length()) {
            boolean splitAtSpace = Character.isSpaceChar(sentence.charAt(position));
            result.append(sentence.substring(origin, position));
            origin = splitAtSpace ? position + 1 : position;
            position = getNextSplitPosition(sentence, origin, width);
            result.append("\n");
        }
        result.append(sentence.substring(origin));

        return result.toString();
    }

    /**
     * Finds the next place where the sentence can be split.
     *
     * At first, the algorithm tries to split a chunk the size of the width (this is the "naive" split location).
     * This works if the string is shorter that the width or if a space exists at the split location.
     * Otherwise, the algorithm backtracks positions until it finds a space and splits there.
     * If no space can be found in this part of the sentence, the split is made at the naive location.
     *
     * @param sentence Sentence to split
     * @param position Current position (initially 0, then the index of the character right after previous split)
     * @param width Width that defines the split
     * @return a place to split the sentence
     */
    private static int getNextSplitPosition(CharSequence sentence, int position, int width) {
        int naiveSplitPosition = position + width;

        if (naiveSplitPosition < sentence.length() && !Character.isSpaceChar(sentence.charAt(naiveSplitPosition))) {
            int backtrackedPosition = Math.min(naiveSplitPosition, sentence.length());
            while (backtrackedPosition > position) {
                if (Character.isSpaceChar(sentence.charAt(backtrackedPosition))) {
                    return backtrackedPosition;
                }
                backtrackedPosition--;
            }
        }

        return naiveSplitPosition;
    }

}
