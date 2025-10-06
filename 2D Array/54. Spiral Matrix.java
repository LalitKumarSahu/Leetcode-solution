class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0) return result;

        int stRow = 0, endRow = matrix.length - 1;
        int stCol = 0, endCol = matrix[0].length - 1;

        while (stRow <= endRow && stCol <= endCol) {
            // Left to Right
            for (int j = stCol; j <= endCol; j++) {
                result.add(matrix[stRow][j]);
            }

            // Top to Bottom
            for (int i = stRow + 1; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }

            // Right to Left
            if (stRow < endRow) {
                for (int j = endCol - 1; j >= stCol; j--) {
                    result.add(matrix[endRow][j]);
                }
            }

            // Bottom to Top
            if (stCol < endCol) {
                for (int i = endRow - 1; i > stRow; i--) {
                    result.add(matrix[i][stCol]);
                }
            }

            stRow++;
            endRow--;
            stCol++;
            endCol--;
        }

        return result;
    }
}
