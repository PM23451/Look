package com.example.aprendizagemmobile.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CidadesAdapter(context: Context, resource: Int, data: List<String>) :
    ArrayAdapter<String>(context, resource, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val textView = convertView as? TextView ?: TextView(context)
        textView.text = getItem(position)
        return textView
    }
}
