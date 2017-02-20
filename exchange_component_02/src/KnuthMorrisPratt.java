public class KnuthMorrisPratt implements IBaggageScanner{

    @Override
    public boolean search(String text) {
        private String givenString = "ABC ABCDAB ABCDABCDABDE";
        String searchedString = "ABCDABD";
        int givenStringLetterPosition = 0;
        int searchedStringLetterPosition = 0;
        int foundAt = -1;

        while(givenStringLetterPosition < giv)
        {
            if (givenString.charAt(givenStringLetterPosition) == searchedString.charAt(searchedStringLetterPosition)) {
                if (searchedStringLetterPosition == 0) {
                    foundAt = givenStringLetterPosition;
                }
                searchedStringLetterPosition++;
                givenStringLetterPosition++;
                if (searchedStringLetterPosition == searchedString.length()) {
                    System.out.println("String found at " + foundAt + " position.");
                    break;
                }
            } else {
                searchedStringLetterPosition = 0;
                foundAt++;
                givenStringLetterPosition = foundAt;
                if (givenString.length() == givenStringLetterPosition) {
                    System.out.println("String was not found.");
                    break;
                }
            }
        }
    }
}