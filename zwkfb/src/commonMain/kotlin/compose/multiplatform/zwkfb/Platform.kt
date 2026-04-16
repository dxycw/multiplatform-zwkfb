package compose.multiplatform.zwkfb

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform