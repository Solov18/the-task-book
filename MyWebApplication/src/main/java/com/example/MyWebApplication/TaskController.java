package com.example.MyWebApplication;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTask();
    }
    @GetMapping("/{id}")
    public Task getDyId(@PathVariable UUID id){
        return taskService.getTask(id);

    }
    @PostMapping
    public Task addByID(@PathVariable Task task){
        return taskService.addTask(task);
    }
    @PutMapping("/{id}")
    public Task getById(@PathVariable UUID id, @RequestBody Task task){
        return taskService.updateTask(id,task);
    }
    public void delete(@PathVariable UUID id){
        taskService.deleteTask(id);
    }
}
