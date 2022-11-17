import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Group {
    private final ArrayList<Student> students;
    private final Scanner in;

    public Group() {
        students = new ArrayList<>();
        in = new Scanner(System.in);
    }

    public void addStudent(Student newStudent) {
        students.add(newStudent);
    }

    public void printStudents() {
        for (Student student : students) {
            if (student.isHere()) {
                System.out.print(student);
            }
        }
    }

    public void getRandomStudent() {
        int index = (int) (Math.random() * students.size());
        if (students.get(index).isHere()) {
            System.out.println("Студент " + students.get(index).getName() + " уже отвечал");
            return;
        }
        System.out.println("Отвечает студент " + students.get(index).getName());
        getAnswers(index);
    }

    public void getStudent() {
        System.out.println("Введите номер студента по списку (индексация начинается с 1):");
        int index = in.nextInt();
        getAnswers(index - 1);
    }

    private void getAnswers(int index) {
        System.out.println("Присутствует ли на паре? (y/n)");
        String answer = "";
        while (!Objects.equals(answer, "y") && !Objects.equals(answer, "n")) {
            answer = in.nextLine();
        }
        students.get(index).setHere(answer.equals("y"));
        if (students.get(index).isHere()) {
            System.out.println("Оценка за ответ:");
            int grade;
            grade = in.nextInt();
            students.get(index).setGrade(grade);
        }
        System.out.println("Ok");
    }

    public void startSeminar() {
        printHelp();
        String line = "";
        while (!Objects.equals(line, "/exit")) {
            line = in.nextLine();
            if (line.equals("/r")) {
                getRandomStudent();
            } else if (line.equals("/l")) {
                printStudents();
            } else if (line.equals("/h")) {
                printHelp();
            } else if (line.equals("/i")) {
                getStudent();
            }
        }
    }

    private void printHelp() {
        System.out.println("Подсказка:");
        System.out.println("/r - выбрать случайного студента\n" +
                "/i - выбрать студента, указав его номер в списке\n" +
                "/l - вывести список ответивших студентов\n" +
                "/h - вывести эту подсказку\n" +
                "/exit - завершить программу");
    }
}
