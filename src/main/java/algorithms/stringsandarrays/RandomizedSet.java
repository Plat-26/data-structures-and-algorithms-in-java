package algorithms.stringsandarrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Implement the RandomizedSet class:
 *
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements
 * (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * Output
 * [null, true, false, true, 2, true, false, 2]
 *
 * Explanation
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 */
public class RandomizedSet {

  //value, index pair
  private HashMap<Integer, Integer> dict;
  private List<Integer> values;
  private Random random;

  /**
   * Time: O(1)
   * Space: O(n) where n is the number of insertions to the set
   */
  public RandomizedSet() {
    this.dict = new HashMap<>();
    this.random = new Random();
    this.values = new ArrayList<>();
  }

  /*
   * Store value and index in hash map and add value at that specific index to list
   */
  public boolean insert(int val) {
    if(dict.containsKey(val)) {
      return false;
    }
    int currIndex = values.size();
    dict.put(val, currIndex);
    values.add(currIndex, val);
    return true;
  }

  /*
   * To have constant delete, swap value with last index in list before removing
   */
  public boolean remove(int val) {
    if(!dict.containsKey(val)) {
      return false;
    }

    int valueToRemoveIndex = dict.get(val);
    int lastIndex = values.size() - 1;
    dict.put(values.get(lastIndex), valueToRemoveIndex);
    values.set(valueToRemoveIndex, values.get(lastIndex));
    values.remove(lastIndex);
    dict.remove(val);
    return true;
  }

  public int getRandom() {
    int randomInt = random.nextInt(values.size());
    return values.get(randomInt);
  }
}

/*
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */