package com.partners.texsun.app.utils.dialogs

import android.content.Context
import android.view.LayoutInflater
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.callbacks.onDismiss
import com.afollestad.materialdialogs.customview.customView
import com.partners.texsun.R
import com.partners.texsun.app.TexsunApp
import kotlinx.android.synthetic.main.dialog_progressbar.view.*

object Dialogs {

    fun infoDialog(
        context: Context,
        titleResourceId: Int? = null,
        messageResourceId: Int? = null,
        message: String? = null,
        onDismiss: (() -> Unit)? = null
    ): MaterialDialog {
        val dialog = MaterialDialog(context)
            .positiveButton(R.string.ok)
            .cornerRadius(res = R.dimen.dialog_corner_radius)
            .onDismiss {
                onDismiss?.invoke()
            }

        if (messageResourceId != null) {
            dialog.message(messageResourceId)
        } else if (message != null) {
            dialog.message(text = message)
        }

        titleResourceId?.let {
            dialog.title(it)
        }

        return dialog
    }

    fun confirmationDialog(
        context: Context,
        titleResourceId: Int,
        message: String,
        onAccept: (() -> Unit)? = null
    ): MaterialDialog {
        return MaterialDialog(context)
            .title(titleResourceId)
            .message(text = message)
            .cornerRadius(res = R.dimen.dialog_corner_radius)
            .positiveButton(R.string.accept, click = { onAccept?.invoke() })
            .negativeButton(R.string.cancel, click = { it.dismiss() })
    }

    fun confirmationDialog(
        context: Context,
        titleResourceId: Int,
        onAccept: (() -> Unit)? = {}
    ): MaterialDialog {
        return MaterialDialog(context)
            .title(titleResourceId)
            .cornerRadius(res = R.dimen.dialog_corner_radius)
            .positiveButton(R.string.accept, click = { onAccept?.invoke() })
            .negativeButton(R.string.cancel, click = { it.dismiss() })
    }


    fun acceptDialog(
        context: Context,
        titleResourceId: Int,
        messageId: Int? = null
    ): MaterialDialog {
        val dialog =  MaterialDialog(context)
            .title(titleResourceId)
            .cornerRadius(res = R.dimen.dialog_corner_radius)
            .positiveButton(R.string.accept, click = { it.dismiss() })
            .cancelable(false)
        messageId?.let {
            dialog.message(messageId)
        }
        return  dialog
    }

    fun loadingDialog(
        context: Context,
        titleResourceId: Int,
        messageResourceId: Int
    ): MaterialDialog {
        val dialog = MaterialDialog(context)
        val view =
            LayoutInflater.from(context).inflate(R.layout.dialog_progressbar, dialog.view, false)
        view.txLoadingMsg.text = TexsunApp.instance.getString(messageResourceId)
        return dialog
            .title(titleResourceId)
            .customView(view = view)
            .cornerRadius(res = R.dimen.dialog_corner_radius)
            .cancelable(false)
            .noAutoDismiss()
    }
}