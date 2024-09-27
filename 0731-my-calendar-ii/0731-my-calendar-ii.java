class MyCalendarTwo {
    List<int[]> single, duplicate;

    public MyCalendarTwo() {
        single = new ArrayList();
        duplicate = new ArrayList();
        
    }
    
    public boolean isoverlapped(int s1,int  e1,int s2,int e2){{
        return Integer.max(s1, s2) < Integer.min(e1, e2);
    }

    }
    public boolean book(int start, int end) {
        for(int[] booking: duplicate){
            if(isoverlapped(booking[0], booking[1], start, end)){
                return false;
            }
        }

        for(int[] booking:single){
            if(isoverlapped(booking[0], booking[1], start, end)){
                duplicate.add(new int[]{Integer.max(booking[0], start), Integer.min(booking[1], end)});
            }
        }
        single.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */