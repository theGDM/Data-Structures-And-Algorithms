import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length //array of LL

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void put(K key, V value) throws Exception {
      int bi = hashFun(key); //it will give the bucket in which the key value is found
      int di = getIndexWithinBucket(key, bi); //get the data index in that found bucket

      if(di != -1){ //update
        HMNode node = buckets[bi].get(di);
        node.value = value;
      }else{ //insert
        HMNode node = new HMNode(key, value); //make new HMNode
        buckets[bi].add(node); //add the value in the linkedlist
        ++size; //increase the size by 1
      }

      double lambda = size * 1.0 / buckets.length;
      if(lambda > 2.0){
        rehash();
      }
    }

    private int getIndexWithinBucket(K key, int bi){
      int di = 0;
      for(HMNode node : buckets[bi]){
        if(node.key.equals(key)){
          return di;
        }
        ++di;
      }

      return -1;
    }

    private void rehash() throws Exception{
      LinkedList<HMNode>[] oba = buckets; //old buckets array

      initbuckets(oba.length * 2); //new buckets array with double the size of old buckets array
      size = 0; //make the size 0
      //put every key with there respective value in new buckets array
      for(int bi = 0; bi < oba.length; ++bi){
        for(HMNode node : oba[bi]){
          put(node.key, node.value);
        }
      }
    }

    private int hashFun(K key){
      int hc = key.hashCode();
      return Math.abs(hc) % buckets.length;
    } 

    public V get(K key) throws Exception {
      int bi = hashFun(key);
      int di = getIndexWithinBucket(key, bi);

      if(di != -1){ //key found in the bucket
        HMNode node = buckets[bi].get(di);
        return node.value;
      }else{ //key not found in that bucket
        return null;
      }
    }

    public boolean containsKey(K key) {
      int bi = hashFun(key);
      int di = getIndexWithinBucket(key, bi);

      if(di != -1){ //key found in the bucket
        return true;
      }else{ //key not found in that bucket
        return false;
      }
    }

    public V remove(K key) throws Exception {
      int bi = hashFun(key);
      int di = getIndexWithinBucket(key, bi);

      if(di != -1){ //key found in the bucket
        HMNode node = buckets[bi].remove(di);
        --size; //reduuce the size by 1
        return node.value;
      }else{ //key not found in that bucket
        return null;
      }
    }

    public ArrayList<K> keyset() throws Exception {
      ArrayList<K> keys = new ArrayList<>();
      for(int bi = 0; bi < buckets.length; ++bi){ //outer loop
        for(HMNode node : buckets[bi]){ //loop on each linkedlist
          keys.add(node.key);
        }
      }

      return keys;
    }

    public int size() {
      return size;
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}
