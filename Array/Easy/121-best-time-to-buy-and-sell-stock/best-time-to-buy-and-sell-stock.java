class Solution {
    public int maxProfit(int[] prices) {
       int max=0;
      int buy=0,sell=1;
    
    while(sell<prices.length)
    { 
        if(prices[buy]<=prices[sell])
        {
            max = Math.max(max,(prices[sell]-prices[buy]));
            sell++;
        } 
        else if(prices[buy]>prices[sell])
        {
            buy = sell;
            sell++;
        }
    }
    return max;
    }
}