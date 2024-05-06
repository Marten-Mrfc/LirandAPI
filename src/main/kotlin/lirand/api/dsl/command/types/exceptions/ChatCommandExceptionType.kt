package lirand.api.dsl.command.types.exceptions

import com.mojang.brigadier.ImmutableStringReader
import com.mojang.brigadier.exceptions.CommandExceptionType
import lirand.api.extensions.chat.toComponent
import net.kyori.adventure.text.Component

class ChatCommandExceptionType(
	val messageBuilder: (Array<out Any>) -> Unit
) : CommandExceptionType {

	constructor(message: Component) : this({ message })
	constructor(message: String) : this(message.toComponent())

	fun create(vararg args: Any): ChatCommandSyntaxException {
		return ChatCommandSyntaxException(this, messageBuilder(args))
	}

	fun createWithContext(
		reader: ImmutableStringReader,
		vararg args: Any
	): ChatCommandSyntaxException {
		return ChatCommandSyntaxException(this, messageBuilder(args), reader.string, reader.cursor)
	}
}