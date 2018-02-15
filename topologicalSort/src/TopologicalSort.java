public class TopologicalSort {

    private static void printOrder(String[] words, int alpha) {
        // Create a graph with 'aplha' edges
        Graph graph = new Graph(alpha);

        for (int i = 0; i < words.length - 1; i++) {
            // Take the current two words and find the first mismatching
            // character
            String word1 = words[i];
            String word2 = words[i + 1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                // If we find a mismatching character, then add an edge
                // from character of word1 to that of word2
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
                    break;
                }
            }
        }

        // Print topological sort of the above created graph
        graph.topologicalSort();
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        //String[] words = {"caa", "aaa", "aab"};
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        printOrder(words, 4);
    }
}
