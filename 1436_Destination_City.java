///////////////////////////////////////////
//1436. Destination City
///////////////////////////////////////////


class Solution {
    public String destCity(List<List<String>> paths) {
        String result="";
        
        Set<String> from = new HashSet();
        Set<String> to = new HashSet();
        
        for(List<String> l : paths) {
            
            from.add(l.get(0));
            to.add(l.get(1));
        }
        
        Iterator<String> it = to.iterator();
        
        while(it.hasNext()){
            String city=it.next();
           if(!from.contains(city)) {
               result=city;
               break;
           }
               
         }

        return result;
    }
}