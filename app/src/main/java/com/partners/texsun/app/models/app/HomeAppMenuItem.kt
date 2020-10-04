package com.partners.texsun.app.models.app

import android.graphics.drawable.Drawable
import com.partners.texsun.R
import com.partners.texsun.app.TexsunApp

class HomeAppMenuItem (
    val name: String = "",
    val drawable: Drawable?,
    val action:String = ""
){
    companion object {
        val default = arrayListOf<HomeAppMenuItem>().apply {
            add(HomeAppMenuItem("Mi perfil", TexsunApp.instance.getDrawable(R.drawable.ic_key_56dp), "my_profile"))
            add(HomeAppMenuItem("Agregar Paquete", TexsunApp.instance.getDrawable(R.drawable.ic_key_56dp), "add_package"))
            add(HomeAppMenuItem("Mi perfil", TexsunApp.instance.getDrawable(R.drawable.ic_key_56dp), "my_profile"))
            add(HomeAppMenuItem("Agregar Paquete", TexsunApp.instance.getDrawable(R.drawable.ic_key_56dp), "add_package"))
            add(HomeAppMenuItem("Mi perfil", TexsunApp.instance.getDrawable(R.drawable.ic_key_56dp), "my_profile"))
            add(HomeAppMenuItem("Agregar Paquete", TexsunApp.instance.getDrawable(R.drawable.ic_key_56dp), "add_package"))
            add(HomeAppMenuItem("Mi perfil", TexsunApp.instance.getDrawable(R.drawable.ic_key_56dp), "my_profile"))
            add(HomeAppMenuItem("Agregar Paquete", TexsunApp.instance.getDrawable(R.drawable.ic_key_56dp), "add_package"))

        }
    }
}