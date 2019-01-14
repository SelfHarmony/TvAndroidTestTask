package android.tv.test.tvandroidtest.data.storage

import android.arch.persistence.room.Database
import android.arch.persistence.room.TypeConverters
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.tv.test.tvandroidtest.data.storage.dao.ChannelDao
import android.tv.test.tvandroidtest.data.storage.entity.ChannelForDb
import java.nio.channels.Channel


@Database(
        entities = [ChannelForDb::class],
        version = 1, exportSchema = false
)

abstract class DataBase : RoomDatabase() {
    abstract fun getChannelDao(): ChannelDao


}