import java.text.SimpleDateFormat
import java.util.*

val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
val currentDate = sdf.format(Date())

data class Post(
    val id: Int = 1,
    val ownerId: Int = 1,
    val date: String = currentDate,
    val text: String = "Hello world",
    val reposts: Int = 0,
    val views: Int = 15,
    val attachments: Int = 2,
    val isFavorite: Boolean = true,
    val likes: Likes = Likes()
)