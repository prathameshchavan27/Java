package com.taskmanager.operations;

import com.taskmanager.custom_exception.TaskException;

public interface TaskOperations {

	void addTask(String taskName, String description);
	void displayTask(int taskId) throws TaskException;
	void updateTaskStatus(int taskId,String status) throws TaskException;
	void displayAllPendingTask();
	void displayAllTasksForToday();
	void displayTasksSortedByTaskDate();
}
