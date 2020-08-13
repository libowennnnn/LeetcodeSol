class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length < 1) return "";
        int idx = 0;
        StringBuilder prefix = new StringBuilder();
        int minLen = strs[0].length();
        for(String str: strs){
            if(str.length() < minLen) minLen = str.length();
        }
        while(idx < minLen){
            char c = strs[0].charAt(idx);
            if (check(strs, idx, c)){
                prefix.append(c);
                idx++;
                }
            else break;
        }
        return prefix.toString();
    }

    public boolean check(String[] strs, int idx, char c ){
        for(int i = 1; i < strs.length; i++){
            if(strs[i].charAt(idx) != c) return false;
        }
        return true;
    }
}
