public class KnuthMorrisPratt implements IBaggageScanner {

    @Override
    public boolean search(String haystack, String needle) {
        int givenStringLetterPosition = 0;
        int searchedStringLetterPosition = 0;
        int foundAt = -1;

        while (givenStringLetterPosition < haystack.length()) {
            if (haystack.charAt(givenStringLetterPosition) == needle.charAt(searchedStringLetterPosition)) {
                if (searchedStringLetterPosition == 0) {
                    foundAt = givenStringLetterPosition;
                }
                searchedStringLetterPosition++;
                givenStringLetterPosition++;
                if (searchedStringLetterPosition == needle.length()) {
                    return true;
                }
            } else {
                searchedStringLetterPosition = 0;
                foundAt++;
                givenStringLetterPosition = foundAt;
                if (haystack.length() == givenStringLetterPosition) {
                    return false;
                }
            }
        }
        return false;
    }
}