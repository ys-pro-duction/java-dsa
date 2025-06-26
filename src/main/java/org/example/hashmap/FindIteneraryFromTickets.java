package org.example.hashmap;

import java.util.HashMap;

public class FindIteneraryFromTickets {
    public static void main(String[] args) {
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai","Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");

        String route = findFullJourney(tickets);
        System.out.println(route);
    }

    private static String findFullJourney(HashMap<String, String> tickets) {
        String from = null;
        {
            HashMap<String, String> m = new HashMap<>();
            for (String key : tickets.keySet()) {
                m.put(tickets.get(key), key);
            }
            for (String starting : m.values()) {
                if (m.get(starting) == null) {
                    from = starting;
                    break;
                }
            }
        }
        assert from != null;
        StringBuilder result = new StringBuilder(from);
        while ( (from = tickets.get(from)) != null){
            result.append(" --> ");
            result.append(from);
        }
        return result.toString();
    }

}
