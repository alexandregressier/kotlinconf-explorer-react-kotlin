import react.Props
import react.RBuilder
import react.RComponent
import react.State
import react.dom.p

external interface VideoListProps : Props {
    var videos: List<Video>
}

@ExperimentalJsExport
@JsExport
class VideoList : RComponent<VideoListProps, State>() {

    override fun RBuilder.render() {
        props.videos.forEach { video ->
            p {
                key = "${video.id}"
                +"${video.speaker}: ${video.title}"
            }
        }
    }
}