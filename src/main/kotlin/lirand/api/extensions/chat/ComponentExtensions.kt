package lirand.api.extensions.chat

import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.JoinConfiguration
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.event.HoverEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.entity.Entity
private val mm = MiniMessage.builder().build()

fun String.toComponent() =
    mm.deserialize(this)

fun Array<String>.toComponent() =
    Component.join(JoinConfiguration.separator(Component.newline()), map { mm.deserialize(it) })

fun Collection<String>.toComponent() =
    Component.join(JoinConfiguration.separator(Component.newline()), map { mm.deserialize(it) })

fun HoverTextEvent(text: String): HoverEvent<Component> {
    return HoverEvent.showText(mm.deserialize(text))
}

fun HoverItemEvent(itemStack: ItemStack): HoverEvent.ShowItem {
    val itemKey = Key.key(itemStack.type.key.namespace(), itemStack.type.key.value())
    return HoverEvent.ShowItem.showItem(itemKey, itemStack.amount)
}

fun HoverEntityEvent(entity: Entity): HoverEvent.ShowEntity {
    val entityTypeKey = Key.key(entity.type.key.namespace(), entity.type.key.value())
    return HoverEvent.ShowEntity.showEntity(entityTypeKey, entity.uniqueId, Component.text(entity.name))
}

fun RunCommandClickEvent(command: String): ClickEvent {
    return ClickEvent.runCommand(command)
}

fun SuggestCommandClickEvent(command: String): ClickEvent {
    return ClickEvent.suggestCommand(command)
}

fun CopyTextClickEvent(text: String): ClickEvent {
    return ClickEvent.copyToClipboard(text)
}

fun OpenUrlClickEvent(url: String): ClickEvent {
    return ClickEvent.openUrl(url)
}

fun ChangePageClickEvent(page: Int): ClickEvent {
    return ClickEvent.changePage(page)
}