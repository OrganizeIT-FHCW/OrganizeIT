import kotlinx.datetime.LocalDateTime

class Task (var title: String, var description: String, var dueDate: LocalDateTime, var done: Boolean){
    fun markAsDone()
    {
        done = true
    }

    fun editDescription(description: String)
    {
        this.description = description
    }

    fun editTitle(title: String)
    {
        this.title = title
    }
}