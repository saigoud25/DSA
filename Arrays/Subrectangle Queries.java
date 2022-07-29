1476. Subrectangle Queries
https://leetcode.com/problems/subrectangle-queries/


/*
->Create a ArrayList, store the given data in the ArrayList as Objects
->Iterate ArrarList from back side, if the row is between r1, r2 and col is between c1, c2, return the newData
*/
class Data {
    int r1, r2, c1, c2, val;
    Data(int row1, int col1, int row2, int col2, int newValue) {
        r1 = row1;
        r2 = row2;
        c1 = col1;
        c2 = col2;
        val = newValue;
    }
}
class SubrectangleQueries {
    int[][] rectangle;
    ArrayList<Data> arr;
    public SubrectangleQueries(int[][] rectangle) {
        arr = new ArrayList<>();
        this.rectangle = rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        arr.add(new Data(row1, col1, row2, col2, newValue));
    }
    
    public int getValue(int row, int col) {
        for(int i = arr.size()-1; i>=0; i--) {
            Data data = arr.get(i);
            if(data.r1<=row && data.c1<=col && row<=data.r2 && col<=data.c2) {
                return data.val;
            }
        }
        
        return rectangle[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
