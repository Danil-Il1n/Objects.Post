fun main() {

    val video = VideoAttachment("https://example.com/video.mp4")
    val photo = PhotoAttachment("https://example.com/image.jpg")
    val audio = AudioAttachment("https://example.com/audio.mp3")
    val file = FileAttachment("https://example.com/file.docx")
    val sticker = StickersAttachment("https://example.com/sticker.png")

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