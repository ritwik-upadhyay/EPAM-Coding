import java.util.*;
public final class CloudFlexVMProvisioningDispatcher {

    //Constants
    private static final String GENERAL = "GENERAL";
    //private static final String GPU = "GPU";

    private static final String CREATE = "CREATE";
    public static final String DELETE = "DELETE";

    private static final String DC1 = "DC1";
    private static final String DC2 = "DC2";

    //VM Request
    static class VMRequest {
        
        String eventId;
        String vmId;
        String owner;
        String vmType;
        String priority;
        String action;

        VMRequest (
            String eventId,
            String vmId,
            String owner,
            String vmType,
            String priority,
            String action
        ) {
            this.eventId = eventId;
            this.vmId = vmId;
            this.owner = owner;
            this.vmType = vmType;
            this.priority = priority;
            this.action = action;
        }
    }

    //Allocation details
    static class Allocation {
        
        String dc;
        String slot;
        String owner;
        String vmType;

        Allocation(
            String dc,
            String slot,
            String owner,
            String vmType
        ) {
            this.dc = dc;
            this.slot = slot;
            this.owner = owner;
            this.vmType = vmType;
        }
    }

    //Data center structure 
    static class DataCenter {
        String name;
        LinkedHashMap<String, String> generalSlots = new LinkedHashMap<>();
        LinkedHashMap<String, String> gpuSlots = new LinkedHashMap<>();
        DataCenter(String name) {
            this.name = name;

            //GENERAL slots
            generalSlots.put("G1","free");
            generalSlots.put("G2","free");
            generalSlots.put("G3","free");

            //GPU slots
            gpuSlots.put("P1","free");
            gpuSlots.put("P2","free");
        }
    }

    //Get priority value
    private static int getPriorityValue(String priority) {
        switch(priority) {
            case "P1":
                return 1;
            case "P2":
                return 2;
            default:
                return 3;
        }
    }

    //Allocate VM
    private static boolean allocateVM(
        VMRequest req,
        List<DataCenter> dataCenters,
        Map<String,Allocation> allocations
    ) {
        for(DataCenter dc : dataCenters) {
            LinkedHashMap<String,String> slots = req.vmType.equals(GENERAL) ? dc.generalSlots : dc.gpuSlots;
            for(Map.Entry<String,String> entry : slots.entrySet()) {
                if(entry.getValue().equals("free")) {
                    String slot = entry.getKey();

                    //Allocate slot
                    slots.put(slot, req.owner);

                    allocations.put(
                        req.vmId,
                        new Allocation(
                            dc.name,
                            slot,
                            req.owner,
                            req.vmType
                        )
                    );
                    System.out.println(
                        "Dispatched -> " + 
                        req.vmId + 
                        " (" + 
                        req.owner + 
                        ") provisioned at " + 
                        dc.name + 
                        "-" + 
                        slot
                    );
                    return true;
                }
            }
        }
        return false;
    }

    //Delete VM
    private static void deleteVM(
        VMRequest req,
        DataCenter dc1,
        DataCenter dc2,
        Map<String,Allocation> allocations
    ) {
        Allocation allocation = allocations.get(req.vmId);
        if(allocation == null) {
            return;
        }
        DataCenter dc = allocation.dc.equals(DC1) ? dc1 : dc2;
        LinkedHashMap<String, String> slots = allocation.vmType.equals(GENERAL) ? dc.generalSlots : dc.gpuSlots;
        slots.put(allocation.slot,"free");
        allocations.remove(req.vmId);
        System.out.println(
            req.eventId + 
            ": " + 
            req.vmId + 
            " (" + 
            req.owner + 
            ") deleted from " +
            allocation.dc + 
            "-" + 
            allocation.slot + 
            " [slot freed]"
        );
    }

    //Lookup VM
    private static void lookupVM(
        String vmId,
        Map<String,Allocation> allocations
    ) {
        Allocation allocation = allocations.get(vmId);
        if(allocation == null) {
            System.out.println(
                "Lookup " + 
                vmId + 
                " -> Request not found"
            );
            return;
        }
        System.out.println(
            "Lookup " + 
            vmId + 
            " -> " + 
            allocation.owner + 
            " | " +
            allocation.dc + 
            "-" +
            allocation.slot + 
            " | " +
            allocation.vmType
        );
    }

    //Print occupancy report
    private static void printReport(
        DataCenter dc
    ) {
        StringBuilder sb = new StringBuilder();
        sb.append("DC ").append(dc.name).append(": ");
        for(Map.Entry<String,String> entry : dc.generalSlots.entrySet()) {
            sb.append(entry.getKey()).append("[").append(entry.getValue()).append("] ");
        }
        for(Map.Entry<String,String> entry : dc.gpuSlots.entrySet()) {
            sb.append(entry.getKey()).append("[").append(entry.getValue()).append("] ");
        }
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<VMRequest> createRequests = new ArrayList<>();
        DataCenter dc1 = new DataCenter(DC1);
        DataCenter dc2 = new DataCenter(DC2);
        List<DataCenter> dataCenters = Arrays.asList(dc1,dc2);
        Map<String, Allocation> allocations = new HashMap<>();

        //Read events
        for(int i=0;i<n;i++) {
            String[] parts = sc.nextLine().split(" ");
            String eventId = parts[0];
            String vmId = parts[1];
            String owner = parts[2];

            //DELETE request
            if(parts[3].equals(DELETE)) {
                VMRequest req = new VMRequest(eventId, vmId, owner, "", "", DELETE);
                deleteVM(req, dc1, dc2, allocations);
            }
            else {
                
                //CREATE request
                String vmType = parts[3];
                String priority = parts[4];

                VMRequest req = new VMRequest(eventId, vmId, owner, vmType, priority, CREATE);
                createRequests.add(req);
                System.out.println(
                    eventId + 
                    ": Request added -> " + 
                    vmId + 
                    " | " + 
                    owner + 
                    " | " + 
                    vmType + 
                    " | " + 
                    priority
                );
            }
        }

        System.out.println();

        //Sort requests by priority then arrival
        createRequests.sort((a,b) -> {
            int cmp = Integer.compare(
                getPriorityValue(a.priority),
                getPriorityValue(b.priority)
            );
            
            if(cmp != 0) {
                return cmp;
            }
            
            return a.eventId.compareTo(b.eventId);
        });

        //Dispatch requests
        for(VMRequest req : createRequests) {
            allocateVM(
                req,
                dataCenters,
                allocations
            );
        }

        System.out.println();

        //Lookups
        lookupVM("VM-01", allocations);
        lookupVM("VM-05", allocations);
        lookupVM("VM-99", allocations);

        System.out.println();

        //Final occupancy report 
        printReport(dc1);
        printReport(dc2);

        sc.close();
    }
}
