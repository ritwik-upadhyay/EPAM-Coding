package packageLevelAccessManagement.user;
public class AdminUser extends User{
    public int adminId;
    public AdminUser(String name, int age, int adminId, String role) {
        super(name,age,role);
        this.adminId = adminId;
    }
    @Override
    public String toString() {
        return "======= Admin User =======\n" 
               +"Admin User ID: "+adminId+"\n"
               +"Admin User Name: "+getName()+"\n"
               +"Admin User Age: "+getAge()+"\n"
               +"Admin User Role: "+role+"\n"
               +"\n";
    }
}
