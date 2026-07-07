import java.util.*;
public final class CustomerSupportTicketPrioritizer {
    static class CustomerPriority {
            String customerID;
            int severityScore;
            public CustomerPriority(String customerID, int severityScore) {
                this.customerID = customerID;
                this.severityScore = severityScore;
            }
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<String,Integer> ticketMap = new HashMap<>();
        for(int i=0;i<N;i++) {
            String customerID = sc.next();
            int severityScore = sc.nextInt();
            ticketMap.put(customerID,Math.max(ticketMap.getOrDefault(customerID, 0),severityScore));
        }
        List<CustomerPriority> customers = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : ticketMap.entrySet()) {
            CustomerPriority cp = new CustomerPriority(entry.getKey(), entry.getValue());
            customers.add(cp);
        }
        customers.sort((a,b)->{
            int compareSeverity = Integer.compare(
                b.severityScore,
                a.severityScore
            );
            if(compareSeverity!=0) {
                return compareSeverity;
            }
            return a.customerID.compareTo(b.customerID);
        });
        for(CustomerPriority cp : customers) {
            System.out.println(cp.customerID);
        }
        sc.close();
    }
}
