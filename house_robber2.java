class Solution {
    public int rob(int[] nums) {
/*
here we divdie array into parts from 0 to n-1 as one part and 1 to n as other part
for example
1 2 3 4 is divided into two arrays
1 2 3 as first array
2 3 4 as second array 
we get maximum from these two arrays

*/
        
        if(nums.length==1)
            return nums[0];
        else if(nums.length==2)
            return Integer.max(nums[0],nums[1]);
        // int[] dp1=new int[nums.length+1];
        // for(int i=0;i<dp1.length;i++)
        //     dp1[i]=dp2[i]=-1;
        int preptr=nums[0];
        int ptr=Integer.max(nums[0],nums[1]);
        int a=ptr;
        for(int i=2;i<nums.length-1;i++){
            a=Integer.max(nums[i]+preptr,ptr);
            preptr=ptr;
            ptr=a;

        }
        // int a=dp1[nums.length-2];
        preptr=nums[1];
        int b=ptr=Integer.max(nums[1],nums[2]);
        for(int i=3;i<nums.length;i++){
            b=Integer.max(nums[i]+preptr,ptr);
            preptr=ptr;
            ptr=b;
        }

        return Integer.max(a,b);

        // return Integer.max(getRob1(nums,nums.length-2,dp1),getRob2(nums,nums.length-1,dp2));
    }
    // public int getRob1(int[] nums,int n,int[] dp){
    //     if(n<0)
    //         return 0;
    //     if(n==0)
    //         return nums[0];
    //     if(dp[n]!=-1)
    //         return dp[n];
    //     int adj=nums[n]+getRob1(nums,n-2,dp);
    //     int nextAdj=getRob1(nums,n-1,dp);
    //     return dp[n]=Integer.max(adj,nextAdj);
    // }
    // public int getRob2(int[] nums,int n,int[] dp){
    //     if(n<1)
    //         return 0;
    //     if(n==1)
    //         return nums[1];
    //     if(dp[n]!=-1)
    //         return dp[n];
    //     int adj=nums[n]+getRob2(nums,n-2,dp);
    //     int nextAdj=getRob2(nums,n-1,dp);
    //     return dp[n]=Integer.max(adj,nextAdj);
    // }
}
