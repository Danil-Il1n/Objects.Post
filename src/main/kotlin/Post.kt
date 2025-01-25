import java.text.SimpleDateFormat
import java.util.*

val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
val currentDate = sdf.format(Date())

data class Post(
    val id: Int = 1,
    val ownerId: Int = 1,
    val date: String = currentDate,
    val reposts: Int = 0,
    val views: Int = 15,
    val isFavorite: Boolean = true,
    val likes: Likes = Likes(),
    val text: String?,
    val attachments: List<Attachments>?
)

data class VideoAttachment(val videoUrl: String) : Attachments {
    override val type: String = "video"
}

data class PhotoAttachment(val photoUrl: String) : Attachments {
    override val type: String = "photo"
}

data class AudioAttachment(val audioUrl: String) : Attachments {
    override val type: String = "audio"
}

data class StickersAttachment(val stickerUrl: String) : Attachments {
    override val type: String = "sticker"
}

data class FileAttachment(val fileUrl: String) : Attachments {
    override val type: String = "file"
}