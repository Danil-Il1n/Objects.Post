import org.junit.Assert
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()

        val actual = service.add(Post(id = 10))

        assertTrue(actual.id != 0)
    }

    @Test
    fun update1() {
        val service = WallService()

        val actual = service.update(Post(id = 100))

        assertFalse(actual)
    }

    @Test
    fun update2() {
        val service = WallService()

        val added = service.add(Post(id = 10))
        val actual = service.update(added.copy(text = "Test"))

        assertTrue(actual)
    }
}