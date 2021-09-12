import kotlinx.css.*
import kotlinx.css.Color.Companion.lightGreen
import kotlinx.css.Color.Companion.red
import kotlinx.css.Display.block
import kotlinx.css.Position.absolute
import kotlinx.html.js.onClickFunction
import react.Props
import react.RBuilder
import react.RComponent
import react.State
import react.dom.attrs
import react.dom.h3
import react.dom.img
import styled.css
import styled.styledButton
import styled.styledDiv

external interface VideoPlayerProps : Props {
    var video: Video
    var onWatchedButtonPressed: (Video) -> Unit
    var unwatchedVideo: Boolean
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
            styledButton {
                css {
                    display = block
                    backgroundColor = if (props.unwatchedVideo) lightGreen else red
                }
                attrs {
                    onClickFunction = { props.onWatchedButtonPressed(props.video) }
                }
                +"Mark as ${if (!props.unwatchedVideo) "unwatched" else "watched"}"
            }
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