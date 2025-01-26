class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()


    fun createComment(postId: Int, comment: Comment): Comment {
        val check = posts.any {it.id == postId}
        if (!check) {
            throw PostNotFoundException("Post with id $postId not found")
        }
        comments += comment
        return comment
    }

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for (i in posts.indices) {
            val current = posts[i]
            if (current.id == post.id) {
                posts[i] = post

                return true
            }
        }
        return false
    }
}
data class Comment(val id: Int, val postId: Int, val text: String)
class PostNotFoundException(message: String) : RuntimeException(message)
