import java.util.*;
public class SimpleVotingSystem {
    static List<String> winners = new ArrayList<>();
    public static void tallyVotes(Map<String,Integer> votes) {
        int maxVotes = 0;
        for(Map.Entry<String,Integer> entry : votes.entrySet()) {
            String k = entry.getKey();
            int v = entry.getValue();
            if(v>maxVotes) {
                maxVotes = v;
                winners.clear();
                winners.add(k);
            }
            else if(v==maxVotes) {
                winners.add(k);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N==0) {
            System.out.println("No Votes");
            return;
        }
        Map<String, Integer> votes = new HashMap<>();
        for(int i=0;i<N;i++) {
            String name = sc.next();
            name = name.trim().toLowerCase();
            votes.put(name,votes.getOrDefault(name, 0)+1);
        }
        tallyVotes(votes);
        List<String> candidates = new ArrayList<>(votes.keySet());
        Collections.sort(candidates);
        for(String c : candidates) {
            System.out.println(c + " " + votes.get(c));
        }
        System.out.print("winner(s): ");
        for(String winner : winners) {
            System.out.print(winner + " ");
        }
        System.out.println();
    }
}


//OR
// import java.util.*;

// public class SimpleVotingSystem {

//     // Read and count votes
//     public static Map<String, Integer> countVotes(
//             Scanner sc,
//             int n
//     ) {

//         Map<String, Integer> voteCount =
//                 new HashMap<>();

//         for (int i = 0; i < n; i++) {

//             // Normalize:
//             // remove extra spaces + lowercase
//             String name = sc.nextLine()
//                     .trim()
//                     .toLowerCase();

//             // Ignore empty names
//             if (name.length() == 0) {
//                 continue;
//             }

//             voteCount.put(
//                     name,
//                     voteCount.getOrDefault(name, 0) + 1
//             );
//         }

//         return voteCount;
//     }

//     // Get maximum vote count
//     public static int getMaxVotes(
//             Map<String, Integer> voteCount
//     ) {

//         int maxVotes = 0;

//         for (int votes : voteCount.values()) {

//             maxVotes = Math.max(
//                     maxVotes,
//                     votes
//             );
//         }

//         return maxVotes;
//     }

//     // Print vote results
//     public static void printResults(
//             Map<String, Integer> voteCount
//     ) {

//         // No valid votes
//         if (voteCount.isEmpty()) {

//             System.out.println("No Votes");
//             return;
//         }

//         // Sort candidates lexicographically
//         List<String> candidates =
//                 new ArrayList<>(voteCount.keySet());

//         Collections.sort(candidates);

//         // Print vote counts
//         for (String candidate : candidates) {

//             System.out.println(
//                     candidate + " "
//                             + voteCount.get(candidate)
//             );
//         }

//         // Find maximum votes
//         int maxVotes =
//                 getMaxVotes(voteCount);

//         // Store winners
//         List<String> winners =
//                 new ArrayList<>();

//         for (String candidate : candidates) {

//             if (voteCount.get(candidate)
//                     == maxVotes) {

//                 winners.add(candidate);
//             }
//         }

//         // Print winners
//         System.out.print("winner(s): ");

//         for (int i = 0;
//              i < winners.size();
//              i++) {

//             System.out.print(
//                     winners.get(i)
//             );

//             if (i != winners.size() - 1) {
//                 System.out.print(" ");
//             }
//         }

//         System.out.println();
//     }

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         // Read number of votes
//         int n = Integer.parseInt(
//                 sc.nextLine().trim()
//         );

//         // Count votes
//         Map<String, Integer> voteCount =
//                 countVotes(sc, n);

//         // Print final results
//         printResults(voteCount);

//         sc.close();
//     }
// }