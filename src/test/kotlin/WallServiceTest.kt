import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WallServiceTest {
    val photo = PhotoAttachment("https://example.com/image.jpg")

    @Test
    fun add() {
        val service = WallService()

        val actual = service.add(
            Post(
                1,
                1,
                currentDate,
                0,
                1,
                true,
                Likes(
                    1,
                    true,
                    true,
                    true
                ),
                "text",
                attachments = listOf(photo)
            )
        )

        assertTrue(actual.id != 0)
    }

    @Test
    fun update1() {
        val service = WallService()

        service.add(
            Post(
                1,
                1,
                currentDate,
                0,
                1,
                true,
                Likes(
                    1,
                    true,
                    true,
                    true
                ),
                "text",
                attachments = listOf(photo)
            )
        )

        val actual = service.update(
            Post(
                2,
                1,
                currentDate,
                0,
                1,
                true,
                Likes(
                    1,
                    true,
                    true,
                    true
                ),
                "text",
                attachments = listOf(photo)
            )
        )

        assertFalse(actual)
    }

    @Test
    fun update2() {
        val service = WallService()

        val added = service.add(
            Post(
                1,
                1,
                currentDate,
                0,
                1,
                true,
                Likes(
                    1,
                    true,
                    true,
                    true
                ),
                "text",
                attachments = listOf(photo)
            )
        )

        val actual = service.update(added.copy(id = 1, text = "updated text"))

        assertTrue(actual)
    }
}