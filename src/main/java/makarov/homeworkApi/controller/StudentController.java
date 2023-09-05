package makarov.homeworkApi.controller;

import makarov.homeworkApi.model.Student;
import makarov.homeworkApi.sevice.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.add(student.getName(), student.getAge());
    }

    @GetMapping
    public Student get(@RequestParam long id) {
        return studentService.get(id);
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return studentService.update(student.getId(), student.getName(), student.getAge());
    }

    @DeleteMapping
    public Student delete(@RequestParam long id) {
        return studentService.remove(id);
    }

    @GetMapping("/age")
    public List<Student> getAge(@RequestParam int age) {
        return studentService.getAge(age);
    }
}
