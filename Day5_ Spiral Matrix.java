class Solution {
    private String[] d = new String[]{"RIGHT", "DOWN", "LEFT", "UP"};
    
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        
        int p = 0;
        int q = -1;
        List<Integer> ret = new ArrayList<>();
        int directionIndex = 0;
        while ( rowSize !=0 && colSize != 0) {
            String direction = d[directionIndex];
            switch(direction) {
                case "RIGHT":
                    for (int i=0; i<colSize; i++) {
                        ret.add(matrix[p][++q]);
                    }
                    rowSize--;
                    break;
                case "DOWN":
                    for (int i=0; i<rowSize; i++) {
                        ret.add(matrix[++p][q]);
                    }
                    colSize--;
                    break;
                case "LEFT":
                    for (int i=0; i<colSize; i++) {
                        ret.add(matrix[p][--q]);
                    }
                    rowSize--;
                    break;
                case "UP":
                    for (int i=0; i<rowSize; i++) {
                        ret.add(matrix[--p][q]);
                    }
                    colSize--;
                    break;
            }
            directionIndex = (directionIndex+1)%4;
        }
        
        return ret;
    }
}