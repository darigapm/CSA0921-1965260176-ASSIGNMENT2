import java.util.*;

public class AttendanceTracker {
    public static class Student {
        private final String regNo;
        private final String name;

        public Student(String regNo, String name) {
            this.regNo = regNo;
            this.name = name;
        }

        public String getRegNo() { return regNo; }
        public String getName() { return name; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(regNo, student.regNo);
        }

        @Override
        public int hashCode() {
            return Objects.hash(regNo);
        }

        @Override
        public String toString() {
            return regNo + " - " + name;
        }
    }

    public static void main(String[] args) {
        Set<Student> present = new HashSet<>();

        present.add(new Student("1965260176", "Dariga P M"));
        present.add(new Student("192311002", "Divya"));
        present.add(new Student("1965260176", "Dariga PM"));

        System.out.println("Unique students count: " + present.size());
        System.out.println("Attendance List: " + present);
    }
}
