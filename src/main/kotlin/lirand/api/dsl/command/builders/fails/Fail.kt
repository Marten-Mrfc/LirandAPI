package lirand.api.dsl.command.builders

import lirand.api.extensions.chat.ComponentBaseBuilder
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.minimessage.MiniMessage

// Define a custom exception for command failures
class CommandFailException(message: Component? = null) : RuntimeException(message?.toString())

// Extension function to throw a failure with a given message component
fun BrigadierCommandContext<*>.fail(
	message: Component? = null
): Nothing = throw CommandFailException(message)

// Extension function to throw a failure with multiple message components
fun BrigadierCommandContext<*>.fail(
	message: Component,
	vararg messages: Component
): Nothing {
	val newMessage = messages.fold(message) { acc, component -> acc.append(component) }
	throw CommandFailException(newMessage)
}
// Extension function to throw a failure with a builder for message components
inline fun BrigadierCommandContext<*>.fail(
	crossinline builder: ComponentBaseBuilder.() -> Unit
): Nothing = throw CommandFailException(ComponentBaseBuilder().apply(builder).build())

fun BrigadierCommandContext<*>.fail(
	message: String
): Nothing = fail(Component.text(message))
