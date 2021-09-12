import kotlinx.html.js.onClickFunction
import react.*
import react.dom.attrs
import react.dom.p

external interface VideoListProps : Props {
    var videos: List<Video>
}
external interface VideoListState : State {
    var selectedVideo: Video?
}
@JsExport
class VideoList : RComponent<VideoListProps, VideoListState>() {

    override fun RBuilder.render() {
        props.videos.forEach { video ->
            p {
                key = "${video.id}"
                attrs {
                    onClickFunction = { setState { selectedVideo = video } }
                }
                if (video == state.selectedVideo) +"▶ "
                +"${video.speaker}: ${video.title}"
            }
        }
    }
}

fun RBuilder.videoList(handler: VideoListProps.() -> Unit) =
    child(VideoList::class) {
        attrs(handler)
    }