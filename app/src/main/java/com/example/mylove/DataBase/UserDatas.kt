package com.example.project_contact.DataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Users")
data class UserDatas(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name = "Foidalanuvchilar")
    val textName: String,
    val textInfo: String
)
