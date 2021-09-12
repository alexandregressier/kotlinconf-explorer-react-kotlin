import kotlinx.browser.document
import react.dom.*

external interface Video {
    val id: Int
    val title: String
    val speaker: String
    val videoUrl: String
}

data class KotlinVideo(
    override val id: Int,
    override val title: String,
    override val speaker: String,
    override val videoUrl: String,
) : Video

val unwatchedVideos = listOf(
    KotlinVideo(1, "Building and breaking things", "John Doe", "https://youtu.be/PsaFVLr8t4E"),
    KotlinVideo(2, "The development process", "Jane Smith", "https://youtu.be/PsaFVLr8t4E"),
    KotlinVideo(3, "The Web 7.0", "Matt Miller", "https://youtu.be/PsaFVLr8t4E")
)

val watchedVideos = listOf(
    KotlinVideo(4, "Mouseless development", "Tom Jerry", "https://youtu.be/PsaFVLr8t4E")
)

fun main() {
    render(document.getElementById("root")) {
        h1 { +"Hello, React & Kotlin/JS!" }
        div {
            h3 { +"Videos to watch" }
            unwatchedVideos.forEach { video ->
                p { +"${video.speaker}: ${video.title}" }
            }
            h3 { +"Videos watched" }
            watchedVideos.forEach { video ->
                p { +"${video.speaker}: ${video.title}" }
            }
        }
        div {
            h3 { +"John Doe: Building and breaking things" }
            img { attrs { src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder" } }
        }
    }
}