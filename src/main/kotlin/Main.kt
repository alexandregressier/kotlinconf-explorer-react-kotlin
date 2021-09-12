import kotlinx.browser.document
import react.dom.render

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

fun main() {
    render(document.getElementById("root")) {
        child(App::class) {}
    }
}