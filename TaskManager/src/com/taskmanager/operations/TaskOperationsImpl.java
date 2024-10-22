package com.taskmanager.operations;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.taskmanager.core.Status;
import com.taskmanager.core.Task;
import com.taskmanager.custom_exception.TaskException;

public class TaskOperationsImpl implements TaskOperations{
	private Map<Integer, Task> tasks;
	private static int idCounter = 0;
	
	public TaskOperationsImpl() {
		// TODO Auto-generated constructor stub
		tasks = new HashMap<Integer, Task>();
		int id = ++idCounter;
		tasks.put(id, new Task(id, "task1", "task1", LocalDate.parse("2024-10-19"), Status.COMPLETED, false));
		id = ++idCounter;
		tasks.put(id, new Task(id, "task2", "task2", LocalDate.parse("2024-10-19"), Status.COMPLETED, false));
		id = ++idCounter;
		tasks.put(id, new Task(id, "task3", "task3", LocalDate.parse("2024-10-20"), Status.PENDING, true));
		id = ++idCounter;
		tasks.put(id, new Task(id, "task4", "task4", LocalDate.parse("2024-10-20"), Status.PENDING, true));
		id = ++idCounter;
		tasks.put(id, new Task(id, "task5", "task5", LocalDate.parse("2024-10-20"), Status.INPROGRESS, true));
		id = ++idCounter;
		tasks.put(id, new Task(id, "task6", "task6", LocalDate.parse("2024-10-20"), Status.COMPLETED, false));
		
	}

	@Override
	public void addTask(String taskName, String description) {
		// TODO Auto-generated method stub
		int id = ++idCounter;
		tasks.put(id, new Task(id, taskName, description, LocalDate.now(), Status.PENDING, true));
		System.out.println("Task added : id="+id);
	}

	@Override
	public void displayTask(int taskId) throws TaskException {
		// TODO Auto-generated method stub
		if(!tasks.containsKey(taskId))
			throw new TaskException("Task not found");
		System.out.println(tasks.get(taskId));
	}

	@Override
	public void updateTaskStatus(int taskId, String status) throws TaskException {
		// TODO Auto-generated method stub
		if(!tasks.containsKey(taskId))
			throw new TaskException("Task not found");
		tasks.get(taskId).setStatus(Status.valueOf(status.toUpperCase()));
	}

	@Override
	public void displayAllPendingTask() {
		// TODO Auto-generated method stub
		tasks.values().stream()
		.filter(t->t.getStatus()==Status.PENDING).forEach(t->System.out.println(t));
		
	}
	
	@Override
	public void displayAllTasksForToday() {
		// TODO Auto-generated method stub
		tasks.values().stream()
		.filter(t->t.getTaskDate().equals(LocalDate.now())).forEach(t->System.out.println(t));
		
	}

	@Override
	public void displayTasksSortedByTaskDate() {
		// TODO Auto-generated method stub
		tasks.values().stream()
		.sorted(Comparator.comparing(Task::getTaskDate)).forEach(t->System.out.println(t));
	}

	
}
	
	
