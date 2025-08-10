class Solution {
    public int shortestWay(String source, String target) {
        int slength = source.length(), tlength = target.length(), count = 0;

        // Preprocessing: store all characters of source in a set for quick lookup
        Set<Character> sourceChars = new HashSet<>();
        for (char c : source.toCharArray()) {
            sourceChars.add(c);
        }

        // If target contains a character not in source, it's impossible
        for (char c : target.toCharArray()) {
            if (!sourceChars.contains(c)) return -1;
        }

        int i = 0;
        while (i < tlength) {
            int old_i = i;
            for (int j = 0; j < slength && i < tlength; j++) {
                if (target.charAt(i) == source.charAt(j)) {
                    i++;
                }
            }
            if (old_i == i) return -1; // no progress, stuck
            count++;
        }
        return count;
    }
}
