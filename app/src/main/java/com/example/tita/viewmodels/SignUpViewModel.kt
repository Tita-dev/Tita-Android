package com.example.tita.viewmodels

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tita.R
import com.example.tita.base.BaseViewModel

class SignUpViewModel(layoutInflater: LayoutInflater, application: Application) :
    BaseViewModel(application = application) {

    @SuppressLint("StaticFieldLeak")
    private val context = Application().applicationContext

    @SuppressLint("StaticFieldLeak")

    val dialogView = layoutInflater.inflate(R.layout.custom_dialog_layout, null)

    fun naverLogin(view: View) {


        val builder = AlertDialog.Builder(context)
        val dialogMainText = dialogView.findViewById<TextView>(R.id.main_text)
        val dialogText = dialogView.findViewById<TextView>(R.id.scrollView_Text)
        dialogMainText.text = "서비스 이용약관"
        dialogText.setText(R.string.Zunmun)

        if (dialogView.getParent() != null)
            (dialogView.getParent() as ViewGroup)
                .removeView(dialogView)
            builder.setView(dialogView)
            .setNegativeButton("확인") { dialogInterface, i ->
                dialogMainText.text = "서비스 이용약관"
                dialogText.setText(R.string.Zunmun)
            }
            .show()
    }

}
