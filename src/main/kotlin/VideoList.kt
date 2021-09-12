import kotlinx.browser.window
import kotlinx.html.js.onClickFunction
import react.Props
import react.RBuilder
import react.RComponent
import react.State
import react.dom.attrs
import react.dom.p

external interface VideoListProps : Props {
    var videos: List<Video>
}

@JsExport
class VideoList : RComponent<VideoListProps, State>() {

    override fun RBuilder.render() {
        props.videos.forEach { video ->
            p {
                key = "${video.id}"
                attrs {
                    onClickFunction = { window.alert("Clicked $video!") }
                }
                +"${video.speaker}: ${video.title}"
            }
        }
    }
}

fun RBuilder.videoList(handler: VideoListProps.() -> Unit) =
    child(VideoList::class) {
        attrs(handler)
    }