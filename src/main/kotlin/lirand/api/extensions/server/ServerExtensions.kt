package lirand.api.extensions.server

import org.bukkit.Bukkit
import org.bukkit.Server
import org.bukkit.WorldCreator

val server get() = Bukkit.getServer()

val nmsVersion = server.javaClass.getPackage().name
	.split(".")[3].substring(1)

val splitNmsVersion = nmsVersion.split("_")
val nmsNumberVersion: Int = if (splitNmsVersion.size > 1) {
	splitNmsVersion[1].toInt()
} else {
	// Handle the case where the splitNmsVersion has less than 2 elements
	0 // or any default value
}

val Server.mainWorld get() = worlds[0]!!

var Server.whitelist: Boolean
	get() = hasWhitelist()
	set(value) = setWhitelist(value)

fun WorldCreator.create() = server.createWorld(this)