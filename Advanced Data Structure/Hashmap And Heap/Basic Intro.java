import java.util.*;

public class Main {

  public static void main(String[] args) {
    //creation of HashMap
    HashMap<String, Integer> hm = new HashMap<>();
    System.out.println(hm); //How empty HashMap looks like

    //putting (key, value) pairs O(1)
    hm.put("India", 1391);
    hm.put("Switzerland", 1398);
    hm.put("Spain", 390);
    hm.put("Italy", 90);
    System.out.println(hm);

    //when we try to insert same key with different value
    hm.put("Italy", 100);
    System.out.println(hm);

    //getting values of the key O(1)
    //if key already present in HasMap
    System.out.println("Population of Spain is : " + hm.get("Spain"));

    //if key does not present in HasMap
    System.out.println("Population of USA is : " + hm.get("USA"));

    //containsKey O(1)
    System.out.println(hm.containsKey("India"));
    System.out.println(hm.containsKey("Chile"));

    //keySet function
    Set<String> keys = hm.keySet();
    System.out.println(keys);

    //iteration over keySet array
    for(String key : hm.keySet()){
      System.out.println(key + " : " + hm.get(key));
    }
  }
}
