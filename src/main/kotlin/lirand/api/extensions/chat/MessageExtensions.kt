package lirand.api.extensions.chat

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.title.Title
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.time.Duration

fun chatColor(hex: String): NamedTextColor {
	val color = NamedTextColor.NAMES.value(hex)
	return color ?: NamedTextColor.WHITE
}

fun chatColor(rgb: Int): NamedTextColor {
	val color = NamedTextColor.NAMES.value(Integer.toHexString(rgb))
	return color ?: NamedTextColor.WHITE
}

inline fun CommandSender.sendMessage(
	crossinline builder: TextComponent.Builder.() -> Unit
) = sendMessage(Component.text().apply(builder))

fun CommandSender.sendMessage(component: Component) {
	this.sendMessage(component)
}

fun CommandSender.sendMessage(vararg components: Component) {
	components.forEach { this.sendMessage(it) }
}

fun Player.title(
	mainText: String? = null,
	subText: String? = null,
	fadeIn: Int = 10,
	stay: Int = 70,
	fadeOut: Int = 20
) {
	val titleComponent = Component.text()
		.content(mainText ?: "")
		.build()

	val subtitleComponent = Component.text()
		.content(subText ?: "")
		.build()
	val title = Title.title(titleComponent, subtitleComponent, Title.Times.times(Duration.ofSeconds(fadeIn.toLong()), Duration.ofSeconds(stay.toLong()), Duration.ofSeconds(fadeOut.toLong())))
	this.showTitle(title)
}

fun Player.actionBar(message: String) {
	this.sendActionBar(Component.text(message))
}

fun Player.actionBar(message: Component) {
	this.sendActionBar(message)
}

fun Player.actionBar(vararg messages: Component) {
	messages.forEach { this.sendActionBar(it) }
}

inline fun Player.actionBar(
	crossinline builder: TextComponent.Builder.() -> Unit
) {
	val message = Component.text().apply(builder).build()
	this.sendActionBar(message)
}