class TimeMap {

    Map<String, Map<Integer, String>> keyValue;

    public TimeMap() {
        keyValue = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        if(!keyValue.containsKey(key)){
            keyValue.put(key, new HashMap<>());
        }

        keyValue.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {

        if(!keyValue.containsKey(key)) return "";

        Map<Integer, String> timeline = keyValue.get(key);

        int closestTime = -1;

        for(int time : timeline.keySet()){

            if(time <= timestamp && time > closestTime){
                closestTime = time;
            }

        }

        if(closestTime == -1) return "";

        return timeline.get(closestTime);
    }
}