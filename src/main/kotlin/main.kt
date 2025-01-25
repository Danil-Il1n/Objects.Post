fun main() {

    val video = VideoAttachment(video = Video(110, "Хорошее"))
    val photo = PhotoAttachment(photo = Photo(120, "1920 x 1080"))
    val audio = AudioAttachment(audio = Audio(120, "Это вообще песня"))
    val file = FileAttachment(file = File(".docx", 10))
    val sticker = StickersAttachment(sticker = Stickers("Крутые стикеры", null))

    val post1 = Post(
        id = 1,
        ownerId = 1,
        date = currentDate,
        reposts = 0,
        views = 15,
        isFavorite = true,
        likes = Likes(),
        text = "Это мой первый пост",
        attachments = listOf(photo, video)
    )

    val post2 = Post(
        id = 2,
        ownerId = 1,
        date = currentDate,
        reposts = 10,
        views = 15,
        isFavorite = false,
        likes = Likes(),
        text = "Это мой второй пост",
        attachments = listOf(file, sticker)
    )

    val post3 = Post(
        id = 3,
        ownerId = 1,
        date = currentDate,
        reposts = 20,
        views = 15,
        isFavorite = true,
        likes = Likes(),
        text = "Это мой третий пост",
        attachments = listOf(audio, photo)
    )

    val wallService = WallService()

    val addedPost1 = wallService.add(post1)
    val addedPost2 = wallService.add(post2)
    val addedPost3 = wallService.add(post3)

    println("Добавленные посты:")
    println(addedPost1)
    println(addedPost2)
    println(addedPost3)

    val updatedPost = post2.copy(text = "Обновленный текст второго поста")
    val isUpdated = wallService.update(updatedPost)

    println("\nРезультат обновления поста с id=${post2.id}: $isUpdated")
    if (isUpdated) {
        println("Обновленный пост: $updatedPost")
    }
}