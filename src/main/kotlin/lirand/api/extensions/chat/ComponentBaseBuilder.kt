package lirand.api.extensions.chat

import lirand.api.extensions.chat.toComponent
import net.kyori.adventure.text.Component

class ComponentBaseBuilder {

	private val components = mutableListOf<Component>()

	fun add(text: String = "", builder: Component.() -> Unit = {}) {
		components.add(Component.text(text).apply(builder))
	}

	fun add(component: Component, builder: Component.() -> Unit = {}) {
		components.add(component.apply(builder))
	}

	fun addLegacy(text: String, builder: Component.() -> Unit = {}) {
		components.add(text.toComponent().apply(builder))
	}

	fun addNewLine() {
		components.add(Component.newline())
	}

	fun addEmptyLine() {
		addNewLine()
		addNewLine()
	}

	fun build() = Component.text().append(components).build()
}