class Solution {
    public int reverseBits(int n) {
        int res = 0; 
        int i = 0;  
        while(i < 32) {
            if(((n >> i) & 1)==1) res|=(1<<(31-i));
            i++;
        }
        return res;
    }
}
