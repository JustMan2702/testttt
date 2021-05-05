package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class GreetingController {
    Long id = Long.parseLong("1");
    ArrayList<Employee> employees = new ArrayList<>(Arrays.asList(new Employee("Василий", "manager", id++), new Employee("Дима", "manager", id++)));
    @GetMapping("/employees")
    public ArrayList<Employee> getAll(){
        return employees;
    }
    @PostMapping("/employees")
    public void postEmployee(@RequestBody Employee employee){
        employees.add(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
        for (Employee employee: employees){
            if (employee.getId() == id){
                employees.remove(employee);
            }
        }
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        for (Employee e: employees){
            if (e.getId() == id){
                e.setName(employee.getName());
                e.setRole(employee.getRole());
            }
        }
    }
}
