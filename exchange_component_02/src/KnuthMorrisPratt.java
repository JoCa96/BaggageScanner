import javax.sound.sampled.Port;

public class KnuthMorrisPratt {
    private static KnuthMorrisPratt instance = new KnuthMorrisPratt();
    public Port port;

    public KnuthMorrisPratt() {
        port = new Port();
    }

    public boolean kmp(String haystack, String needle) {
        int[][] dfa;       // the KMP automoton
        int R = 256;
        // build DFA from pattern
        int m = needle.length();
        dfa = new int[R][m];
        dfa[needle.charAt(0)][0] = 1;
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][x];     // Copy mismatch cases.
            dfa[needle.charAt(j)][j] = j + 1;   // Set match case.
            x = dfa[needle.charAt(j)][x];     // Update restart state.
        }
        // simulate operation of DFA on text
        int n = haystack.length();
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[haystack.charAt(i)][j];
        }
        return j == m;
    }

    public class Port implements IBaggageScanner {

        @Override
        public boolean search(String haystack, String needle) {
            return kmp(haystack, needle);
        }
    }
}