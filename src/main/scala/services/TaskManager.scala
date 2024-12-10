import java.time.LocalDateTime
import TaskPriority.*

class TaskManager{
  private var tasks : List[Task] = List.empty
  private var nextId : Long = 1

  def addTask(
             title : String,
             description : String,
             priority : TaskPriority = TaskPriority.Medium,
             dueDate : Option[LocalDateTime] = None,
             ) : Task  = {
    val newTask = Task(nextId,title,description,priority,dueDate)
    tasks = newTask :: tasks
    nextId += 1
    newTask
  }

  def getAllTasks : List[Task] = tasks

  def getTaskById(id : Long) : Option[Task] = tasks.find(_.id == id)

  def removeTask(id : Long) : Unit = {
    tasks = tasks.filterNot(_.id == id)
  }

  def updateTask(
                id : Long,
                title : Option[String] = None,
                description : Option[String] = None,
                priority : Option[TaskPriority] = None,
                dueDate : Option[Option[LocalDateTime]] = None
                ) : Option[Task] = {
    tasks.indexWhere(_.id == id) match {
      case -1 => None
      case index =>
        val updatedTask = tasks(index).copy(
          title = title.getOrElse(tasks(index).title),
          description = description.getOrElse(tasks(index).description),
          priority = priority.getOrElse(tasks(index).priority),
          dueDate = dueDate.getOrElse(tasks(index).dueDate),
        )
        tasks = tasks.updated(index,updatedTask)
        Some(updatedTask)
    }
  }

  def filterTasks(
                 completed : Option[Boolean] = None,
                 priority: Option[TaskPriority] = None
                 ) : List[Task] = {
    tasks.filter { task =>
      (completed.isEmpty || task.isComplete == completed.get) &&
        (priority.isEmpty || task.priority == priority.get)
    }
  }
}