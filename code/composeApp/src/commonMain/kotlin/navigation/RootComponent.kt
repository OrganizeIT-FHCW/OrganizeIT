package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.*
import kotlinx.serialization.Serializable

class RootComponent (
    componentContext : ComponentContext
): ComponentContext by componentContext {
    private val navigation = StackNavigation<Configuation>()

    val childStack = childStack(
        source = navigation,
        serializer = Configuation.serializer(),
        initialConfiguration = Configuation.SpaceScreen,
        handleBackButton = true,
        childFactory = ::createChild
    )

    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        config: Configuation,
        context: ComponentContext
    ): Child {
        return when(config) {
            Configuation.ToDoScreen -> Child.ToDoScreen(
                ToDoScreenComponent(
                    componentContext = context,
                    onGoBack = {
                        navigation.pop()
                    }
                )
            )
            is Configuation.SpaceScreen -> Child.SpaceScreen(
                SpaceScreenComponent(
                    componentContext = context,
                    onNavigateToScreenToDoList = {
                        navigation.pushNew(Configuation.ToDoScreen)
                    }
                )
            )
        }
    }

    sealed class Child {
        data class ToDoScreen(val component: ToDoScreenComponent): Child()
        data class SpaceScreen(val component: SpaceScreenComponent): Child()
    }

    @Serializable
    sealed class  Configuation {
        @Serializable
        data object ToDoScreen : Configuation()

        @Serializable
        data object SpaceScreen : Configuation()
    }
}