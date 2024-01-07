package navigation

sealed interface SpaceScreenEvent {
    data object  ClickButtonNew: SpaceScreenEvent
    data class UpdateTexT(val text:String): SpaceScreenEvent
}