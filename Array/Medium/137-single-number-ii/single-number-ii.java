class Solution {

    boolean checkBit(int n,int i){
        if(((n>>i)&1)==1) return true;
        else return false;
    }
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<32;i++){
            int cnt=0;
            for(int j=0;j<nums.length;j++){
                if(checkBit(nums[j],i)) cnt++;
            }
            if(cnt%3==1) ans = ans | (1<<i);
        }
        return ans;
    }
}