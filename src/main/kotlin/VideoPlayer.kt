import kotlinx.css.Position.absolute
import kotlinx.css.position
import kotlinx.css.px
import kotlinx.css.right
import kotlinx.css.top
import react.Props
import react.RBuilder
import react.RComponent
import react.State
import react.dom.attrs
import react.dom.h3
import react.dom.img
import styled.css
import styled.styledDiv

external interface VideoPlayerProps : Props {
    var video: Video
}
@JsExport
class VideoPlayer : RComponent<VideoPlayerProps, State>() {

    override fun RBuilder.render() {
        styledDiv {
            css {
                position = absolute
                top = 10.px
                right = 10.px
            }
            h3 { props.video.run { +"$speaker: $title" } }
            img {
                attrs {
                    src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
                    alt = "Video Player Placeholder"
                }
            }
        }
    }
}

fun RBuilder.videoPlayer(handler: VideoPlayerProps.() -> Unit) =
    child(VideoPlayer::class) { attrs(handler) }