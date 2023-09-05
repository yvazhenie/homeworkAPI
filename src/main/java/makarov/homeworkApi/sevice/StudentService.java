package makarov.homeworkApi.sevice;

import makarov.homeworkApi.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private static long COUNTER = 0;

    private final Map<Long, Student> studentId = new HashMap<>();

    public Student add(String name, int age) {
        Student newStudent = new Student(++COUNTER, name, age);
        studentId.put(newStudent.getId(), newStudent);
        return newStudent;
    }

    public Student get(long id) {
        return studentId.get(id);
    }

    public Student update(long id, String name, int age) {
        Student studentForUpdate = studentId.get(id);
        studentForUpdate.setName(name);
        studentForUpdate.setAge(age);
        return studentForUpdate;
    }

    public Student remove(long id) {
        Student studentDelete = studentId.get(id);
        studentId.remove(id);
        return studentDelete;
    }

    public List<Student> getAge(int age) {
        return studentId.values().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }
}
