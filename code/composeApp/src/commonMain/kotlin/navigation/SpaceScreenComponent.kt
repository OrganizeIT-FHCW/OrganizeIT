package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class SpaceScreenComponent(
    componentContext: ComponentContext,
    private val onNavigateToScreenToDoList: (String) -> Unit
): ComponentContext by componentContext {

    private var _text = MutableValue("")
    val text: Value<String> = _text

    fun onEvent(event: SpaceScreenEvent) {
        when (event) {
            SpaceScreenEvent.ClickButtonNew -> onNavigateToScreenToDoList(text.value)
            is SpaceScreenEvent.UpdateTexT -> {
                _text.value = event.text
            }
        }
    }
}