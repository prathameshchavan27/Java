package com.taskmanager.tester;

import java.util.Scanner;

import com.taskmanager.operations.TaskOperationsImpl;

public class TestTaskManager {
	public static void main(String[] args) {
		TaskOperationsImpl ops = new TaskOperationsImpl();
		boolean exit = false;
		try(Scanner sc = new Scanner(System.in)){
			while(!exit) {
				System.out.println("1. Add Task\n2. Display a task\n3. Update task status\n"
						+ "4. Display all pending task\n5. Display all task for today\n"
						+ "6. Display all task sorted by taskDate\nEnter choice");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter taskName and description");
						ops.addTask(sc.next(), sc.next());
						break;
					case 2:
						System.out.println("Enter taskId");
						ops.displayTask(sc.nextInt());
						break;
					case 3:
						System.out.println("Enter taskId and status");
						ops.updateTaskStatus(sc.nextInt(), sc.next());
						break;
					case 4:
						System.out.println("Pending tasks");
						ops.displayAllPendingTask();
						break;
					case 5:
						System.out.println("Today's Tasks");
						ops.displayAllTasksForToday();
						break;
					case 6:
						System.out.println("Task sorted by taskDate");
						ops.displayTasksSortedByTaskDate();
						break;
					default:
						break;
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				
			}
		}
	}
}
