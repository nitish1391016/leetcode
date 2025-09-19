class Spreadsheet {
    private int[][] sheet;
    public Spreadsheet(int rows) {
        sheet = new int[28][rows+2];
    }
    
    public void setCell(String cell, int value) {
        int x = (int)(cell.charAt(0)-'A')+1;
        int y = Integer.parseInt(cell.substring(1));
        System.out.println("x "+x + "y: "+ y);
        sheet[x][y] = value;
    }
    
    public void resetCell(String cell) {
        int x = (int)(cell.charAt(0)-'A')+1;
        int y = Integer.parseInt(cell.substring(1));
        sheet[x][y] = 0;        
    }
    
    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] split = formula.split("\\+", 2); 
        int num1=0, num2=0;
        if(split[0].charAt(0) >= 'A' && split[0].charAt(0) <= 'Z') {
            num1 = getCell(split[0]);
        }
        else
            num1 = Integer.parseInt(split[0]);
        if(split[1].charAt(0) >= 'A' && split[1].charAt(0) <= 'Z') {
            num2 = getCell(split[1]);
        }
        else
            num2 = Integer.parseInt(split[1]);
        System.out.print("num1:"+num1);
        System.out.println("num2:"+num2);
        return num1+num2;
    }
    private int getCell(String cell){
        int x = (int)(cell.charAt(0)-'A')+1;
        int y = Integer.parseInt(cell.substring(1));
        System.out.println("get cell");
        System.out.println("x "+x + "y: "+ y);
        return sheet[x][y];
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */