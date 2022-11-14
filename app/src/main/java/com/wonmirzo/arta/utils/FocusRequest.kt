package com.wonmirzo.arta.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

object FocusRequest {
    fun focusRequest(etCurrent: EditText, etRequest: EditText) {
        var textSize = 0
        etCurrent.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                textSize++
                if (textSize == 2) {
                    etRequest.requestFocus()
                }
            }
        })
    }
}