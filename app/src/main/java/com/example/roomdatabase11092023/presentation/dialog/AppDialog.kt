package com.example.roomdatabase11092023.presentation.dialog

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import com.example.roomdatabase11092023.R


object AppDialog {

    fun makeDialogCreateTask(
        context: Context,
        onClickButtonSave: ((String) -> Unit)? = null
    ) {
        Dialog(context).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.layout_create_task_dialog)

            window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )

            val edtInputTask = findViewById<EditText>(R.id.edit_text_input_task)
            val btnCancel = findViewById<Button>(R.id.button_cancel)
            val btnSave = findViewById<Button>(R.id.button_save)

            btnCancel.setOnClickListener { dismiss() }
            btnSave.setOnClickListener {
                onClickButtonSave?.invoke(edtInputTask.text.toString())
                dismiss()
            }
            show()
        }
    }
}