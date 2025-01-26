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

data class VideoAttachment(val video: Video) : Attachments {
    override val type: String = "video"
}

data class Video(
    val duration: Int = 120,
    val quality: String = "Хорошее"
)

data class PhotoAttachment(val photo: Photo) : Attachments {
    override val type: String = "photo"
}

data class Photo(
    val size: Int = 120,
    val permission: String = "1920 x 1080"
)

data class AudioAttachment(val audio: Audio) : Attachments {
    override val type: String = "audio"
}

data class Audio(
    val duration: Int = 120,
    val title: String = "Это вообще песня"
)

data class StickersAttachment(val sticker: Stickers) : Attachments {
    override val type: String = "sticker"
}

data class Stickers(
    val packName: String = "Крутые стикеры",
    val emoji: String?
)

data class FileAttachment(val file: File) : Attachments {
    override val type: String = "file"
}

data class File(
    val fileFormat: String = ".docx",
    val pageCount: Int = 10
)