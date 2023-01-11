package com.example.project_contact.DataBase

import androidx.room.*

@Dao
interface UserDao {

    @Query("select * from Users")
    fun getAllUser(): List<UserDatas>

    @Insert
    fun addUser(userData: UserDatas)

    @Delete
    fun deletUser(userData: UserDatas)

    @Update
    fun editUser(userData: UserDatas)

    @Query("select *from Users where id=:id")
    fun getUserById(id: Long): UserDatas

    @Query("select * from Users where Foidalanuvchilar =:Name ")
    fun getUserByName(Name:String):List<UserDatas>
}