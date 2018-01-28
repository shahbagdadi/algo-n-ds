import java.util.*;

/**
 *  <a href="../README.md">Question for this problem.</a>
 */

public class PowerSet {


    public static Set<Set<Integer>> PowerSet(Set<Integer> originalSet){
        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        if (originalSet.isEmpty())
        {
            Set<Integer> set = new HashSet<Integer>();
            sets.add(set);
            return sets;
        }

        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<Integer>(list.subList(1,list.size()));
        for (Set<Integer> set : PowerSet(rest)){
            HashSet<Integer> newset = new HashSet<Integer>();
            newset.add(head);
            newset.addAll(set);
            sets.add(set);
            sets.add(newset);
        }
        return sets;
    }

    public static void main(String[] args) {
	Set<Integer> ints = new HashSet<Integer>();
        ints.add(1);
        ints.add(2);
        ints.add(3);

     Set<Set<Integer>> pset = PowerSet(ints);
     // print the powerset
        for (Set<Integer> set : pset)
        {
            System.out.print("{");
            for (Integer i : set)
                System.out.print(i + " ");
            System.out.print("}");
        }
    }
}
