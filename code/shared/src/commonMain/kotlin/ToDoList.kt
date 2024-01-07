import kotlinx.datetime.LocalDateTime

class ToDoList (var title: String, var description: String){
    val tasks = mutableListOf<Task>()

    fun addTask(task: Task)
    {
        tasks.add(task)
    }

    fun addTask(title: String, description: String, dueDate: LocalDateTime)
    {
        val t = Task(title, description, dueDate, false)
        tasks.add(t)
    }

    fun editTitle(newTitle: String)
    {
        this.title = newTitle
    }

    fun editDescription(newDescription: String)
    {
        this.description = newDescription
    }

    fun clearToDoList()
    {
        tasks.clear()
    }
}