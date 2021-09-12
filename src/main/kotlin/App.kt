import kotlinx.css.Position.absolute
import kotlinx.css.position
import kotlinx.css.px
import kotlinx.css.right
import kotlinx.css.top
import react.*
import react.dom.*
import styled.css
import styled.styledDiv

external interface AppState : State {
    var currentVideo: Video?
}
@JsExport
class App : RComponent<Props, AppState>() {

    override fun RBuilder.render() {
        h1 { +"Hello, React & Kotlin/JS!" }
        div {
            h3 { +"Videos to watch" }
            videoList {
                videos = unwatchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { setState { currentVideo = it } }
            }
            h3 { +"Videos watched" }
            videoList {
                videos = watchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { setState { currentVideo = it } }
            }
        }
        styledDiv {
            css {
                position = absolute
                top = 10.px
                right = 10.px
            }
            h3 { +"John Doe: Building and breaking things" }
            img {
                attrs {
                    src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
                    alt = "Video Player Placeholder"
                }
            }
        }
    }
}