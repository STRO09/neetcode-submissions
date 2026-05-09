class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxFreq = Integer.MIN_VALUE;
        int countOfMaxFreq = 0;
        int[] alphas = new int[26];

        for(char task : tasks) { 
            alphas[task - 'A']++;
        }

        for(int i = 0; i < alphas.length ; i++) { 
            if(maxFreq == alphas[i]) { 
                countOfMaxFreq++;
            }
            else if(maxFreq < alphas[i]) { 
                maxFreq = alphas[i];
                countOfMaxFreq = 0;
            }  
        }

        return Math.max(tasks.length, (maxFreq-1)*(n+1) + 1 + countOfMaxFreq);
    }
}
