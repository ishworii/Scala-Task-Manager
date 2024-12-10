object Main extends App {
  val taskManager = new TaskManager()
  
  val task1 = taskManager.addTask(
    "Learn Scala",
    "Complete Scala tutorials",
    TaskPriority.High
  )

  val task2 = taskManager.addTask(
    "Project Setup",
    "Set up IntelliJ project",
    TaskPriority.Urgent
  )

  println("All Tasks:")
  taskManager.getAllTasks.foreach(println)

  // Filter high priority tasks
  println("\nHigh Priority Tasks:")
  taskManager.filterTasks(priority = Some(TaskPriority.High))
    .foreach(println)
}