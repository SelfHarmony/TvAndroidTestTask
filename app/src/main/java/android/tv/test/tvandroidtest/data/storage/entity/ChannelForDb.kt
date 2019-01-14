package android.tv.test.tvandroidtest.data.storage.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.tv.test.tvandroidtest.data.storage.Tables

@Entity(tableName = Tables.CHANNEL_DATA)
class ChannelForDb (
    @PrimaryKey(autoGenerate = true)
    var id: Int
)