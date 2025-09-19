class Spreadsheet {
    private HashMap<String, Integer> map;

    public Spreadsheet(int rows) {
        map = new HashMap<String, Integer>();
        
    }
    
    public void setCell(String cell, int value) {
        map.put(cell, value);
    }
    
    public void resetCell(String cell) {
        map.put(cell, 0);
    }
    
    public int getValue(String formula) {
        String[] splits = formula.substring(1).split("\\+", 2);
        String left = splits[0];
        String right = splits[1];
        int left1 = Character.isUpperCase(left.charAt(0)) ? map.getOrDefault(left, 0): Integer.parseInt(left);
        int right2 = Character.isUpperCase(right.charAt(0)) ? map.getOrDefault(right, 0): Integer.parseInt(right);
        return left1+right2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */