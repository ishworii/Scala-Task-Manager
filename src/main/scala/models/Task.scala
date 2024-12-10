import java.time.LocalDateTime
import TaskPriority.*

case class Task(
               id : Long,
               title : String,
               description : String,
               priority : TaskPriority,
               dueDate : Option[LocalDateTime] = None,
               isComplete : Boolean = false
               ){
  def markCompleted : Task = copy(isComplete = true)

  def updatePriority(newPriority : TaskPriority) : Task = copy(priority = newPriority)
}
