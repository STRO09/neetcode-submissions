class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append(':').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {

        String appendedstrs = new String(str);
        List<String> strs = new ArrayList<>();
        int i = 0; 
        while( i < appendedstrs.length()) {
            int j = i ; 
            while( appendedstrs.charAt(j)!= ':') {
                j++;
            }

            int len = Integer.parseInt(appendedstrs.substring(i,j));
            j++;

            strs.add(appendedstrs.substring(j,j+len));
            i=j+len;
        }

        return strs;
    }
}
