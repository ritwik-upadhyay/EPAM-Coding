import java.util.*;
public class MergeAnalyticsCounts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> pairs = new HashMap<>();
        int A = sc.nextInt();
        for(int i=0;i<A;i++) {
            String key = sc.next();
            int count = sc.nextInt();
            pairs.put(key,pairs.getOrDefault(key, 0)+count);
        }
        int B = sc.nextInt();
        for(int i=0;i<B;i++) {
            String key = sc.next();
            int count = sc.nextInt();
            pairs.put(key,pairs.getOrDefault(key, 0)+count);
        }
        pairs.entrySet().removeIf(entry -> entry.getValue()==0);
        if(!pairs.isEmpty()) {
           List<String> keys = new ArrayList<>(pairs.keySet());
           Collections.sort(keys);
           for(String k : keys) {
            System.out.println(k + " " + pairs.get(k));
           }
        }
        else {
            System.out.println("EMPTY");
        }
        sc.close();
    }
}



//------------------OR------------------------

import java.util.*;

public class MergeAnalyticsCounts {

    // Pair class to store key-count entries
    static class Pair {

        String key;
        long count;

        Pair(String key, long count) {
            this.key = key;
            this.count = count;
        }
    }

    // Merge analytics counts
    public static List<Pair> mergeCounts(
            List<Pair> systemA,
            List<Pair> systemB
    ) {

        // Store final merged counts
        Map<String, Long> mergedMap = new HashMap<>();

        // Process System A
        for (Pair entry : systemA) {

            mergedMap.put(
                    entry.key,
                    mergedMap.getOrDefault(
                            entry.key,
                            0L
                    ) + entry.count
            );
        }

        // Process System B
        for (Pair entry : systemB) {

            mergedMap.put(
                    entry.key,
                    mergedMap.getOrDefault(
                            entry.key,
                            0L
                    ) + entry.count
            );
        }

        // Store non-zero results
        List<Pair> result = new ArrayList<>();

        for (Map.Entry<String, Long> entry
                : mergedMap.entrySet()) {

            if (entry.getValue() != 0) {

                result.add(
                        new Pair(
                                entry.getKey(),
                                entry.getValue()
                        )
                );
            }
        }

        // Sort lexicographically by key
        result.sort((a, b) ->
                a.key.compareTo(b.key)
        );

        return result;
    }

    // Print final output
    public static void printResult(
            List<Pair> result
    ) {

        // If all totals become zero
        if (result.isEmpty()) {

            System.out.println("EMPTY");
            return;
        }

        // Print each pair
        for (Pair entry : result) {

            System.out.println(
                    entry.key + " " + entry.count
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read size of System A
        int a = sc.nextInt();

        List<Pair> systemA =
                new ArrayList<>();

        // Read System A pairs
        for (int i = 0; i < a; i++) {

            String key = sc.next();
            long count = sc.nextLong();

            systemA.add(
                    new Pair(key, count)
            );
        }

        // Read size of System B
        int b = sc.nextInt();

        List<Pair> systemB =
                new ArrayList<>();

        // Read System B pairs
        for (int i = 0; i < b; i++) {

            String key = sc.next();
            long count = sc.nextLong();

            systemB.add(
                    new Pair(key, count)
            );
        }

        // Merge reports
        List<Pair> result =
                mergeCounts(systemA, systemB);

        // Print final merged report
        printResult(result);

        sc.close();
    }
}