package com.kunrambostudio.postreaderkotlin.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by rambo on 5/1/2561.
 */

@Entity(tableName = "post")
class Post {

    @PrimaryKey
    @ColumnInfo(name="id")
    lateinit var id: String

    @ColumnInfo(name = "title")
    lateinit var title:String

    @ColumnInfo(name = "body")
    lateinit var body:String
}

