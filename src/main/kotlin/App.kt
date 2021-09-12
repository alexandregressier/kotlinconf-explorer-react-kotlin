import react.*
import react.dom.div
import react.dom.h1
import react.dom.h3

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
        state.currentVideo?.let { videoPlayer { video = it } }
    }
}