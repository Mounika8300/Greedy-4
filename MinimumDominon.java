class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // Try all 6 possible domino face values (1 to 6)
        for (int i = 1; i <= 6; i++) {
            int rotations = check(i, tops, bottoms);
            if (rotations != -1) {
                return rotations;
            }
        }
        return -1;
    }

    // Check if we can make all values equal to target, return min rotations if possible
    private int check(int target, int[] tops, int[] bottoms) {
        int rotationTop = 0;
        int rotationBottom = 0;

        for (int i = 0; i < tops.length; i++) {
            // If neither top nor bottom has the target, impossible
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            } else if (tops[i] != target) {
                rotationTop++; // need to rotate top
            } else if (bottoms[i] != target) {
                rotationBottom++; // need to rotate bottom
            }
        }

        return Math.min(rotationTop, rotationBottom);
    }
}
