package packageLevelAccessManagement.userManager;
import packageLevelAccessManagement.user.User; 
import packageLevelAccessManagement.user.AdminUser;
public class UserManager {
    public static void main(String[] args) {
        User u = new User("Ritwik",22,"Tester");
        AdminUser a = new AdminUser("Rohan", 22, 1234, "CEO");
        u.setName("Rahul");
        System.out.println(u);
        System.out.println(a);
    }
}
