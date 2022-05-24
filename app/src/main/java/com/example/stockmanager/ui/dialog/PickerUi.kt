package com.example.stockmanager.ui.dialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalContext
import java.util.*

@Composable
fun TimePicker(mTime: MutableState<String>, showDialog: MutableState<Boolean>) {
    // Fetching local context
    val mContext = LocalContext.current

    // Declaring and initializing a calendar
    val mCalendar = Calendar.getInstance()
    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
    val mMinute = mCalendar[Calendar.MINUTE]

    // Value for storing time as a string
//    val mTime = remember { mutableStateOf("") }

    // Creating a TimePicker dialod
    val mTimePickerDialog = TimePickerDialog(
        mContext,
        {_, mHour : Int, mMinute: Int ->
            mTime.value = "$mHour:$mMinute"
            showDialog.value = false
        }, mHour, mMinute, false
    )

    if (showDialog.value)
        mTimePickerDialog.show()
    else mTimePickerDialog.hide()

    mTimePickerDialog.setOnCancelListener { showDialog.value = false }
}

@Composable
fun DatePicker(mDate: MutableState<String>, showDialog: MutableState<Boolean>) {
    // Fetching the Local Context
    val mContext = LocalContext.current

    // Declaring integer values
    // for year, month and day
    val mYear: Int
    val mMonth: Int
    val mDay: Int

    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()

    // Fetching current year, month and day
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    // Declaring DatePickerDialog and setting
    // initial values as current values (present year, month and day)
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"
            showDialog.value = false
        }, mYear, mMonth, mDay
    )

    if (showDialog.value)
        mDatePickerDialog.show()
    else mDatePickerDialog.hide()

    mDatePickerDialog.setOnCancelListener { showDialog.value = false }

}