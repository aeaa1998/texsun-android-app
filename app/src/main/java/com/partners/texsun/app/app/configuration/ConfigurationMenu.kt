package com.partners.texsun.app.app.configuration

class ConfigurationMenu (
    var id:Int = 0,
    var name:String = "",
    var action:String = "",
    var isHeader: Boolean = false) {
    val type: MenuType get() {
        return if (isHeader){
            MenuType.header
        }else{
            MenuType.row
        }
    }
    enum class MenuType{
        header, row
    }
    companion object {
        val default = arrayListOf<ConfigurationMenu>().apply {
            add(ConfigurationMenu(id = 1000, name = "Mi perfil", isHeader = true))
            add(ConfigurationMenu(id = 1001, name = "Cerrar Sesión", action = "log_out"))
        }
    }
}