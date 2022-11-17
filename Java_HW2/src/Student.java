public class Student {
    private final String name;
    private boolean isHere;
    private int grade;

    public Student(String name) {
        this.name = name;
    }

    public void setHere(boolean here) {
        isHere = here;
    }


    public boolean isHere() {
        return isHere;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + ";\tGrade: " + grade + ";\n";
    }
}
