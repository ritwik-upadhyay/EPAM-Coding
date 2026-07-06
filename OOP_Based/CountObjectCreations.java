public class CountObjectCreations {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        System.out.println(Student.getCount());
    }
}
class Student {
    private static int count = 0;

    Student() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}
