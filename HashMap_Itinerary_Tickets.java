import java.util.*;

public class HashMap_Itinerary_Tickets {

    public static String getStartingCity(HashMap<String, String> fromToMap) {
        HashMap<String, String> toFromMap = new HashMap<>();
        for (String city : fromToMap.keySet()) {
            toFromMap.put(fromToMap.get(city), city);
        }

        for (String city : fromToMap.keySet()) {
            if(!toFromMap.containsKey(city)) {
                return city;    // Starting City
            }
        }
        return null;
    }

    public static void main(String[] args) {    // O(n)
        
        HashMap<String, String> fromToMap = new HashMap<>();
        fromToMap.put("Chennai", "Bengaluru");
        fromToMap.put("Mumbai", "Delhi");
        fromToMap.put("Goa", "Chennai");
        fromToMap.put("Delhi", "Goa");


        String startingCity = getStartingCity(fromToMap);
        System.out.print(startingCity);
        for (String city : fromToMap.keySet()) {
            System.out.print("-->" + fromToMap.get(startingCity));
            startingCity = fromToMap.get(startingCity);
        }

    }
}
