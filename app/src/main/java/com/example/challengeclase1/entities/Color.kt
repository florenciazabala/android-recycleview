package com.example.challengeclase1.entities

import android.os.Parcel
import android.os.Parcelable

class Color(name: String?, hexaCode: String?): Parcelable {

    var name: String
    var hexaCode: String

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    init {
        this.name = name!!
        this.hexaCode = hexaCode!!
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(hexaCode)
    }

    companion object CREATOR : Parcelable.Creator<Color> {
        override fun createFromParcel(parcel: Parcel): Color {
            return Color(parcel)
        }

        override fun newArray(size: Int): Array<Color?> {
            return arrayOfNulls(size)
        }
    }
}