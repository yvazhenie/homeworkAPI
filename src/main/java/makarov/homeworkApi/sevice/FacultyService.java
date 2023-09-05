package makarov.homeworkApi.sevice;

import makarov.homeworkApi.model.Faculty;
import makarov.homeworkApi.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private static long COUNTER = 0;

    private final Map<Long, Faculty> facultyId = new HashMap<>();

    public Faculty add(String name, String color) {
        Faculty newFaculty = new Faculty(++COUNTER, name, color);
        facultyId.put(newFaculty.getId(), newFaculty);
        return newFaculty;
    }

    public Faculty get(long id) {
        return facultyId.get(id);
    }

    public Faculty update(long id, String name, String color) {
        Faculty facultyUpdate = facultyId.get(id);
        facultyUpdate.setName(name);
        facultyUpdate.setColor(color);
        return facultyUpdate;
    }

    public Faculty delete(long id) {
        Faculty facultyDelete = facultyId.get(id);
        facultyId.remove(id);
        return facultyDelete;
    }

    public List<Faculty> getColor(String color) {
        return facultyId.values().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
