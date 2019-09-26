package com.example.startlibtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import CentralTendency
import android.R.attr.mode



class MainActivity() : AppCompatActivity(), Parcelable {

    constructor(parcel: Parcel) : this() {

        val numbers = ArrayList()
        val r = Random()

        for (i in 0..14) {
            numbers.add(r.nextInt(7) + 1)
        }

        val mean = CentralTendency.arithmeticMean(numbers).toDouble()
        val median = CentralTendency.median(numbers)
        val mode = CentralTendency.mode(numbers)

        Collections.sort(numbers)

        val res = String.format(
            "Numbers:\n\n%s\nMean: %.1f\nMedian: %.1f\nMode: %s\n",
            numbers, mean, median, mode
        )


        textView.setText(res)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}
