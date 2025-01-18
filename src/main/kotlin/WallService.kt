class WallService {
    private var posts = emptyArray<Post>()

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