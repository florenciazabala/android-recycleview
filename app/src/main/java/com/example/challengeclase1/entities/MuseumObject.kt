package com.example.challengeclase1.entities

import android.os.Parcel
import android.os.Parcelable

class MuseumObject(
    val objectID: Int,
    val title: String?,
    val artistDisplayName: String?,
    val objectDate: String?,
    val primaryImageSmall: String?
)  : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(objectID)
        parcel.writeString(title)
        parcel.writeString(artistDisplayName)
        parcel.writeString(objectDate)
        parcel.writeString(primaryImageSmall)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MuseumObject> {
        override fun createFromParcel(parcel: Parcel): MuseumObject {
            return MuseumObject(parcel)
        }

        override fun newArray(size: Int): Array<MuseumObject?> {
            return arrayOfNulls(size)
        }
    }
}