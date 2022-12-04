package com.ono.androidassessment.history

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ono.androidassessment.UserAgeModel

@BindingAdapter("historyRVBindingAdapter")
fun historyRVBindingAdapter(recyclerView: RecyclerView, history: MutableList<UserAgeModel>?) {
    val adapter = recyclerView.adapter as HistoryRVAdapter
    history?.let { adapter.submitData(recyclerView, history) }
}

@BindingAdapter("userDetailAdapter")
fun userDetailAdapter(textView: TextView, userAgeModel: UserAgeModel) {
    textView.text = StringBuilder().append("Name : \t").append(userAgeModel.name).append("\n Age : \t").append(userAgeModel.age).toString()
}
