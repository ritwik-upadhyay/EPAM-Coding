import java.util.*;
public final class GroupJumbledProductLabels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<String,List<String>> groups = new HashMap<>();
        for(int i=0;i<N;i++) {
            String word = sc.next();
            String lower = word.toLowerCase();
            char[] c = lower.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(lower);
        }
        List<List<String>> anagrams = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : groups.entrySet()) {
            List<String> l = entry.getValue();
            Collections.sort(l);
            anagrams.add(l);
        }
        anagrams.sort((a,b)->{
            return a.get(0).compareTo(b.get(0));
        });
        for(List<String> e : anagrams) {
            for(String w : e) {
                System.out.print(w+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
