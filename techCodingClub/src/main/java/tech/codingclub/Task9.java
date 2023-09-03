package tech.codingclub;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Task9 {

    public static void main(String[] args) {
        System.out.println("This is Mehak Garg");
        System.out.println("Task6 running at " + new Date().toString() + " sharp.");

        Map<String,String> countryToCapital = new HashMap<String,String>();
        countryToCapital.put("India","Delhi");
        countryToCapital.put("China","Beijing");
        countryToCapital.put("Canada" ,"Ottawa");

        if(countryToCapital.containsKey("Canada")){
            System.out.println("Capital of Canada : " + countryToCapital.get("Canada"));
        }else{
            System.out.println("Capital of Canada doesn't exists in database");
        }

        if(countryToCapital.containsKey("Russia")){
            System.out.println("Capital of Russia : " + countryToCapital.get("Canada"));
        }else{
            System.out.println("Capital of Russia doesn't exists in database");
        }

        System.out.println("All key values  : ");
        for(String x:countryToCapital.keySet()){
            System.out.println(x);
        }

        System.out.println("All values  : ");
        for(String x:countryToCapital.values()){
            System.out.println(x);
        }

        System.out.println("#######################");
        for(String x:countryToCapital.keySet()){
            System.out.println(x + " : " + countryToCapital.get(x));
        }

        System.out.println("########################");
        for(Map.Entry<String, String> x:countryToCapital.entrySet()){
            System.out.println(x.getKey() + " " + x.getValue());
        }

        countryToCapital.clear();
        System.out.println("#######################");
        for(String x:countryToCapital.keySet()){
            System.out.println(x + " : " + countryToCapital.get(x));
        }
    }

}
