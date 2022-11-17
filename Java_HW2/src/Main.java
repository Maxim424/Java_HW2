public class Main {
    public static void main(String[] args) {
        Group group = new Group();
        group.addStudent(new Student("A"));
        group.addStudent(new Student("B"));
        group.addStudent(new Student("C"));
        group.addStudent(new Student("D"));

        group.startSeminar();
    }
}