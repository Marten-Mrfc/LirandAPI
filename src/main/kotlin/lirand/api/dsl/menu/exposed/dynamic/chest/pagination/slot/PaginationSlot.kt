package lirand.api.dsl.menu.exposed.dynamic.chest.pagination.slot

import lirand.api.dsl.menu.exposed.dynamic.Slot
import lirand.api.dsl.menu.exposed.fixed.MenuPlayerDataMap
import lirand.api.dsl.menu.exposed.fixed.MenuTypedDataMap
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

interface PaginationSlot<T> {

	val slotRoot: Slot<Inventory>

	val eventHandler: PaginationSlotEventHandler<T>

	val slotData: MenuTypedDataMap
	val playerSlotData: MenuPlayerDataMap

}