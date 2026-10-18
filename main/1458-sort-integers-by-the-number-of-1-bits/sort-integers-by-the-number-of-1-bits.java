class Solution {
    int count(int n){
          int c=0;
          while(n>0){
             n = n&(n-1);
             c++;
          }
          return c;
    }

    public int[] sortByBits(int[] arr) {
         Integer[] temp = new Integer[arr.length];
         for(int i=0;i<arr.length;i++){
            temp[i]=arr[i];
         }

         Arrays.sort(temp,(a,b) -> {
              int c1=count(a), c2=count(b);
              if(c1!=c2) return Integer.compare(c1,c2);
              return Integer.compare(a,b);   //agr c1,c2 equal ho
         });

         for(int i=0;i<arr.length;i++)
         arr[i]=temp[i];

         return arr;
    }
}