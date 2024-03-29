package com.tjoeun.a191107_02_datetimepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.YEAR

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }


    override fun setupEvents() {


        selectTimeBtn.setOnClickListener {

            var timePickerDialog = TimePickerDialog ( this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->

                var selectedTime = Calendar.getInstance()
                selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
                selectedTime.set(Calendar.MINUTE, minute)

                var sdf = SimpleDateFormat ("a h:m")
                timeTxt.text = sdf.format(selectedTime.time)


            }, 10, 20, true)
            timePickerDialog.show()

        }




        selectDateBtn.setOnClickListener {
           var datePickerDialog = DatePickerDialog(this,
               DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                   var selectedDate = Calendar.getInstance()
                   selectedDate.set(Calender, YEAR, year)

                   selectedDate.set (year, month, dayOfMonth)

                   var sdf = SimpleDateFormat ("yyyy년 M월 d일")
                   var resultStr = sdf.format(selectedDate.time)

                   dateTxt.text =resultStr

                   dateTet.text = "${year}년 ${month+1}월 ${dayOfMonth}일"
               }, 2019, Calender.NOVEMBER, 9)

            datePickerDialog.show()
        }
    }

    override fun setValues() {

    }


}
