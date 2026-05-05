package compose.multiplatform.zwkfb

class DESKTOPPlatform : Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = DESKTOPPlatform()