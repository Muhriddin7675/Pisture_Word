package com.example.presentation.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.findwordkotlin.R

class HelpDialog : DialogFragment() {
    private var listener: HelpListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return inflater.inflate(R.layout.help_dialog, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.btn_yes).setOnClickListener { v: View? ->
            listener!!.yes()
            dismiss()
        }
        view.findViewById<View>(R.id.btn_no).setOnClickListener { v: View? ->
            listener!!.no()
            dismiss()
        }
    }

    fun setExitListener(listener: HelpListener?) {
        this.listener = listener
    }

    override fun onStart() {
        super.onStart()
        val width = resources.displayMetrics.widthPixels * 0.9    // 90% of screen width
        val height = ViewGroup.LayoutParams.WRAP_CONTENT         // Automatic height
        dialog?.window?.setLayout(width.toInt(), height)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.setCanceledOnTouchOutside(false)
    }
}