package com.example.interviewstarter.`data`.local

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import com.example.interviewstarter.`data`.local.dao.ArticleDao
import com.example.interviewstarter.`data`.local.dao.ArticleDao_Impl
import com.example.interviewstarter.`data`.local.dao.UserDao
import com.example.interviewstarter.`data`.local.dao.UserDao_Impl
import javax.`annotation`.processing.Generated
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class AppDatabase_Impl : AppDatabase() {
  private val _userDao: Lazy<UserDao> = lazy {
    UserDao_Impl(this)
  }

  private val _articleDao: Lazy<ArticleDao> = lazy {
    ArticleDao_Impl(this)
  }

  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(2, "fc6c96c477890010db6fc8021fd3f04d", "b7b6219505813554e375af4ab4071cd6") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `users` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `username` TEXT NOT NULL, `email` TEXT NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `articles` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `summary` TEXT NOT NULL, `content` TEXT NOT NULL, `url` TEXT NOT NULL, `imageUrl` TEXT NOT NULL, `categoryTag` TEXT NOT NULL, `author` TEXT NOT NULL, `publishedAt` TEXT NOT NULL, `readTimeMinutes` INTEGER NOT NULL, `tagsRaw` TEXT NOT NULL, `isBookmarked` INTEGER NOT NULL, `cachedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'fc6c96c477890010db6fc8021fd3f04d')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `users`")
        connection.execSQL("DROP TABLE IF EXISTS `articles`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection): RoomOpenDelegate.ValidationResult {
        val _columnsUsers: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsUsers.put("id", TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsUsers.put("name", TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsUsers.put("username", TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsUsers.put("email", TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysUsers: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesUsers: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoUsers: TableInfo = TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers)
        val _existingUsers: TableInfo = read(connection, "users")
        if (!_infoUsers.equals(_existingUsers)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |users(com.example.interviewstarter.data.local.entity.UserEntity).
              | Expected:
              |""".trimMargin() + _infoUsers + """
              |
              | Found:
              |""".trimMargin() + _existingUsers)
        }
        val _columnsArticles: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsArticles.put("id", TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsArticles.put("title", TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsArticles.put("summary", TableInfo.Column("summary", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsArticles.put("content", TableInfo.Column("content", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsArticles.put("url", TableInfo.Column("url", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsArticles.put("imageUrl", TableInfo.Column("imageUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsArticles.put("categoryTag", TableInfo.Column("categoryTag", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsArticles.put("author", TableInfo.Column("author", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsArticles.put("publishedAt", TableInfo.Column("publishedAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsArticles.put("readTimeMinutes", TableInfo.Column("readTimeMinutes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsArticles.put("tagsRaw", TableInfo.Column("tagsRaw", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsArticles.put("isBookmarked", TableInfo.Column("isBookmarked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsArticles.put("cachedAt", TableInfo.Column("cachedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysArticles: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesArticles: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoArticles: TableInfo = TableInfo("articles", _columnsArticles, _foreignKeysArticles, _indicesArticles)
        val _existingArticles: TableInfo = read(connection, "articles")
        if (!_infoArticles.equals(_existingArticles)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |articles(com.example.interviewstarter.data.local.entity.ArticleEntity).
              | Expected:
              |""".trimMargin() + _infoArticles + """
              |
              | Found:
              |""".trimMargin() + _existingArticles)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "users", "articles")
  }

  public override fun clearAllTables() {
    super.performClear(false, "users", "articles")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(UserDao::class, UserDao_Impl.getRequiredConverters())
    _typeConvertersMap.put(ArticleDao::class, ArticleDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>): List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }

  public override fun userDao(): UserDao = _userDao.value

  public override fun articleDao(): ArticleDao = _articleDao.value
}
