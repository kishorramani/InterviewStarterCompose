package com.example.interviewstarter.`data`.local.dao

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performInTransactionSuspending
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.interviewstarter.`data`.local.entity.ArticleEntity
import javax.`annotation`.processing.Generated
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class ArticleDao_Impl(
  __db: RoomDatabase,
) : ArticleDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfArticleEntity: EntityInsertAdapter<ArticleEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfArticleEntity = object : EntityInsertAdapter<ArticleEntity>() {
      protected override fun createQuery(): String = "INSERT OR REPLACE INTO `articles` (`id`,`title`,`summary`,`content`,`url`,`imageUrl`,`categoryTag`,`author`,`publishedAt`,`readTimeMinutes`,`tagsRaw`,`isBookmarked`,`cachedAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: ArticleEntity) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.title)
        statement.bindText(3, entity.summary)
        statement.bindText(4, entity.content)
        statement.bindText(5, entity.url)
        statement.bindText(6, entity.imageUrl)
        statement.bindText(7, entity.categoryTag)
        statement.bindText(8, entity.author)
        statement.bindText(9, entity.publishedAt)
        statement.bindLong(10, entity.readTimeMinutes.toLong())
        statement.bindText(11, entity.tagsRaw)
        val _tmp: Int = if (entity.isBookmarked) 1 else 0
        statement.bindLong(12, _tmp.toLong())
        statement.bindLong(13, entity.cachedAt)
      }
    }
  }

  public override suspend fun insertArticles(articles: List<ArticleEntity>): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfArticleEntity.insert(_connection, articles)
  }

  public override suspend fun toggleBookmark(id: String): Boolean = performInTransactionSuspending(__db) {
    super@ArticleDao_Impl.toggleBookmark(id)
  }

  public override fun getAllArticles(): Flow<List<ArticleEntity>> {
    val _sql: String = "SELECT * FROM articles ORDER BY cachedAt DESC"
    return createFlow(__db, false, arrayOf("articles")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfSummary: Int = getColumnIndexOrThrow(_stmt, "summary")
        val _columnIndexOfContent: Int = getColumnIndexOrThrow(_stmt, "content")
        val _columnIndexOfUrl: Int = getColumnIndexOrThrow(_stmt, "url")
        val _columnIndexOfImageUrl: Int = getColumnIndexOrThrow(_stmt, "imageUrl")
        val _columnIndexOfCategoryTag: Int = getColumnIndexOrThrow(_stmt, "categoryTag")
        val _columnIndexOfAuthor: Int = getColumnIndexOrThrow(_stmt, "author")
        val _columnIndexOfPublishedAt: Int = getColumnIndexOrThrow(_stmt, "publishedAt")
        val _columnIndexOfReadTimeMinutes: Int = getColumnIndexOrThrow(_stmt, "readTimeMinutes")
        val _columnIndexOfTagsRaw: Int = getColumnIndexOrThrow(_stmt, "tagsRaw")
        val _columnIndexOfIsBookmarked: Int = getColumnIndexOrThrow(_stmt, "isBookmarked")
        val _columnIndexOfCachedAt: Int = getColumnIndexOrThrow(_stmt, "cachedAt")
        val _result: MutableList<ArticleEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: ArticleEntity
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpSummary: String
          _tmpSummary = _stmt.getText(_columnIndexOfSummary)
          val _tmpContent: String
          _tmpContent = _stmt.getText(_columnIndexOfContent)
          val _tmpUrl: String
          _tmpUrl = _stmt.getText(_columnIndexOfUrl)
          val _tmpImageUrl: String
          _tmpImageUrl = _stmt.getText(_columnIndexOfImageUrl)
          val _tmpCategoryTag: String
          _tmpCategoryTag = _stmt.getText(_columnIndexOfCategoryTag)
          val _tmpAuthor: String
          _tmpAuthor = _stmt.getText(_columnIndexOfAuthor)
          val _tmpPublishedAt: String
          _tmpPublishedAt = _stmt.getText(_columnIndexOfPublishedAt)
          val _tmpReadTimeMinutes: Int
          _tmpReadTimeMinutes = _stmt.getLong(_columnIndexOfReadTimeMinutes).toInt()
          val _tmpTagsRaw: String
          _tmpTagsRaw = _stmt.getText(_columnIndexOfTagsRaw)
          val _tmpIsBookmarked: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsBookmarked).toInt()
          _tmpIsBookmarked = _tmp != 0
          val _tmpCachedAt: Long
          _tmpCachedAt = _stmt.getLong(_columnIndexOfCachedAt)
          _item = ArticleEntity(_tmpId,_tmpTitle,_tmpSummary,_tmpContent,_tmpUrl,_tmpImageUrl,_tmpCategoryTag,_tmpAuthor,_tmpPublishedAt,_tmpReadTimeMinutes,_tmpTagsRaw,_tmpIsBookmarked,_tmpCachedAt)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getArticlesByCategory(categoryTag: String): Flow<List<ArticleEntity>> {
    val _sql: String = "SELECT * FROM articles WHERE categoryTag = ? ORDER BY cachedAt DESC"
    return createFlow(__db, false, arrayOf("articles")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, categoryTag)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfSummary: Int = getColumnIndexOrThrow(_stmt, "summary")
        val _columnIndexOfContent: Int = getColumnIndexOrThrow(_stmt, "content")
        val _columnIndexOfUrl: Int = getColumnIndexOrThrow(_stmt, "url")
        val _columnIndexOfImageUrl: Int = getColumnIndexOrThrow(_stmt, "imageUrl")
        val _columnIndexOfCategoryTag: Int = getColumnIndexOrThrow(_stmt, "categoryTag")
        val _columnIndexOfAuthor: Int = getColumnIndexOrThrow(_stmt, "author")
        val _columnIndexOfPublishedAt: Int = getColumnIndexOrThrow(_stmt, "publishedAt")
        val _columnIndexOfReadTimeMinutes: Int = getColumnIndexOrThrow(_stmt, "readTimeMinutes")
        val _columnIndexOfTagsRaw: Int = getColumnIndexOrThrow(_stmt, "tagsRaw")
        val _columnIndexOfIsBookmarked: Int = getColumnIndexOrThrow(_stmt, "isBookmarked")
        val _columnIndexOfCachedAt: Int = getColumnIndexOrThrow(_stmt, "cachedAt")
        val _result: MutableList<ArticleEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: ArticleEntity
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpSummary: String
          _tmpSummary = _stmt.getText(_columnIndexOfSummary)
          val _tmpContent: String
          _tmpContent = _stmt.getText(_columnIndexOfContent)
          val _tmpUrl: String
          _tmpUrl = _stmt.getText(_columnIndexOfUrl)
          val _tmpImageUrl: String
          _tmpImageUrl = _stmt.getText(_columnIndexOfImageUrl)
          val _tmpCategoryTag: String
          _tmpCategoryTag = _stmt.getText(_columnIndexOfCategoryTag)
          val _tmpAuthor: String
          _tmpAuthor = _stmt.getText(_columnIndexOfAuthor)
          val _tmpPublishedAt: String
          _tmpPublishedAt = _stmt.getText(_columnIndexOfPublishedAt)
          val _tmpReadTimeMinutes: Int
          _tmpReadTimeMinutes = _stmt.getLong(_columnIndexOfReadTimeMinutes).toInt()
          val _tmpTagsRaw: String
          _tmpTagsRaw = _stmt.getText(_columnIndexOfTagsRaw)
          val _tmpIsBookmarked: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsBookmarked).toInt()
          _tmpIsBookmarked = _tmp != 0
          val _tmpCachedAt: Long
          _tmpCachedAt = _stmt.getLong(_columnIndexOfCachedAt)
          _item = ArticleEntity(_tmpId,_tmpTitle,_tmpSummary,_tmpContent,_tmpUrl,_tmpImageUrl,_tmpCategoryTag,_tmpAuthor,_tmpPublishedAt,_tmpReadTimeMinutes,_tmpTagsRaw,_tmpIsBookmarked,_tmpCachedAt)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getArticleById(id: String): Flow<ArticleEntity?> {
    val _sql: String = "SELECT * FROM articles WHERE id = ? LIMIT 1"
    return createFlow(__db, false, arrayOf("articles")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, id)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfSummary: Int = getColumnIndexOrThrow(_stmt, "summary")
        val _columnIndexOfContent: Int = getColumnIndexOrThrow(_stmt, "content")
        val _columnIndexOfUrl: Int = getColumnIndexOrThrow(_stmt, "url")
        val _columnIndexOfImageUrl: Int = getColumnIndexOrThrow(_stmt, "imageUrl")
        val _columnIndexOfCategoryTag: Int = getColumnIndexOrThrow(_stmt, "categoryTag")
        val _columnIndexOfAuthor: Int = getColumnIndexOrThrow(_stmt, "author")
        val _columnIndexOfPublishedAt: Int = getColumnIndexOrThrow(_stmt, "publishedAt")
        val _columnIndexOfReadTimeMinutes: Int = getColumnIndexOrThrow(_stmt, "readTimeMinutes")
        val _columnIndexOfTagsRaw: Int = getColumnIndexOrThrow(_stmt, "tagsRaw")
        val _columnIndexOfIsBookmarked: Int = getColumnIndexOrThrow(_stmt, "isBookmarked")
        val _columnIndexOfCachedAt: Int = getColumnIndexOrThrow(_stmt, "cachedAt")
        val _result: ArticleEntity?
        if (_stmt.step()) {
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpSummary: String
          _tmpSummary = _stmt.getText(_columnIndexOfSummary)
          val _tmpContent: String
          _tmpContent = _stmt.getText(_columnIndexOfContent)
          val _tmpUrl: String
          _tmpUrl = _stmt.getText(_columnIndexOfUrl)
          val _tmpImageUrl: String
          _tmpImageUrl = _stmt.getText(_columnIndexOfImageUrl)
          val _tmpCategoryTag: String
          _tmpCategoryTag = _stmt.getText(_columnIndexOfCategoryTag)
          val _tmpAuthor: String
          _tmpAuthor = _stmt.getText(_columnIndexOfAuthor)
          val _tmpPublishedAt: String
          _tmpPublishedAt = _stmt.getText(_columnIndexOfPublishedAt)
          val _tmpReadTimeMinutes: Int
          _tmpReadTimeMinutes = _stmt.getLong(_columnIndexOfReadTimeMinutes).toInt()
          val _tmpTagsRaw: String
          _tmpTagsRaw = _stmt.getText(_columnIndexOfTagsRaw)
          val _tmpIsBookmarked: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsBookmarked).toInt()
          _tmpIsBookmarked = _tmp != 0
          val _tmpCachedAt: Long
          _tmpCachedAt = _stmt.getLong(_columnIndexOfCachedAt)
          _result = ArticleEntity(_tmpId,_tmpTitle,_tmpSummary,_tmpContent,_tmpUrl,_tmpImageUrl,_tmpCategoryTag,_tmpAuthor,_tmpPublishedAt,_tmpReadTimeMinutes,_tmpTagsRaw,_tmpIsBookmarked,_tmpCachedAt)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getBookmarkedArticles(): Flow<List<ArticleEntity>> {
    val _sql: String = "SELECT * FROM articles WHERE isBookmarked = 1 ORDER BY cachedAt DESC"
    return createFlow(__db, false, arrayOf("articles")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfSummary: Int = getColumnIndexOrThrow(_stmt, "summary")
        val _columnIndexOfContent: Int = getColumnIndexOrThrow(_stmt, "content")
        val _columnIndexOfUrl: Int = getColumnIndexOrThrow(_stmt, "url")
        val _columnIndexOfImageUrl: Int = getColumnIndexOrThrow(_stmt, "imageUrl")
        val _columnIndexOfCategoryTag: Int = getColumnIndexOrThrow(_stmt, "categoryTag")
        val _columnIndexOfAuthor: Int = getColumnIndexOrThrow(_stmt, "author")
        val _columnIndexOfPublishedAt: Int = getColumnIndexOrThrow(_stmt, "publishedAt")
        val _columnIndexOfReadTimeMinutes: Int = getColumnIndexOrThrow(_stmt, "readTimeMinutes")
        val _columnIndexOfTagsRaw: Int = getColumnIndexOrThrow(_stmt, "tagsRaw")
        val _columnIndexOfIsBookmarked: Int = getColumnIndexOrThrow(_stmt, "isBookmarked")
        val _columnIndexOfCachedAt: Int = getColumnIndexOrThrow(_stmt, "cachedAt")
        val _result: MutableList<ArticleEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: ArticleEntity
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpSummary: String
          _tmpSummary = _stmt.getText(_columnIndexOfSummary)
          val _tmpContent: String
          _tmpContent = _stmt.getText(_columnIndexOfContent)
          val _tmpUrl: String
          _tmpUrl = _stmt.getText(_columnIndexOfUrl)
          val _tmpImageUrl: String
          _tmpImageUrl = _stmt.getText(_columnIndexOfImageUrl)
          val _tmpCategoryTag: String
          _tmpCategoryTag = _stmt.getText(_columnIndexOfCategoryTag)
          val _tmpAuthor: String
          _tmpAuthor = _stmt.getText(_columnIndexOfAuthor)
          val _tmpPublishedAt: String
          _tmpPublishedAt = _stmt.getText(_columnIndexOfPublishedAt)
          val _tmpReadTimeMinutes: Int
          _tmpReadTimeMinutes = _stmt.getLong(_columnIndexOfReadTimeMinutes).toInt()
          val _tmpTagsRaw: String
          _tmpTagsRaw = _stmt.getText(_columnIndexOfTagsRaw)
          val _tmpIsBookmarked: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsBookmarked).toInt()
          _tmpIsBookmarked = _tmp != 0
          val _tmpCachedAt: Long
          _tmpCachedAt = _stmt.getLong(_columnIndexOfCachedAt)
          _item = ArticleEntity(_tmpId,_tmpTitle,_tmpSummary,_tmpContent,_tmpUrl,_tmpImageUrl,_tmpCategoryTag,_tmpAuthor,_tmpPublishedAt,_tmpReadTimeMinutes,_tmpTagsRaw,_tmpIsBookmarked,_tmpCachedAt)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun searchArticles(query: String): Flow<List<ArticleEntity>> {
    val _sql: String = "SELECT * FROM articles WHERE title LIKE '%' || ? || '%' OR summary LIKE '%' || ? || '%' OR tagsRaw LIKE '%' || ? || '%' ORDER BY cachedAt DESC"
    return createFlow(__db, false, arrayOf("articles")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, query)
        _argIndex = 2
        _stmt.bindText(_argIndex, query)
        _argIndex = 3
        _stmt.bindText(_argIndex, query)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _columnIndexOfSummary: Int = getColumnIndexOrThrow(_stmt, "summary")
        val _columnIndexOfContent: Int = getColumnIndexOrThrow(_stmt, "content")
        val _columnIndexOfUrl: Int = getColumnIndexOrThrow(_stmt, "url")
        val _columnIndexOfImageUrl: Int = getColumnIndexOrThrow(_stmt, "imageUrl")
        val _columnIndexOfCategoryTag: Int = getColumnIndexOrThrow(_stmt, "categoryTag")
        val _columnIndexOfAuthor: Int = getColumnIndexOrThrow(_stmt, "author")
        val _columnIndexOfPublishedAt: Int = getColumnIndexOrThrow(_stmt, "publishedAt")
        val _columnIndexOfReadTimeMinutes: Int = getColumnIndexOrThrow(_stmt, "readTimeMinutes")
        val _columnIndexOfTagsRaw: Int = getColumnIndexOrThrow(_stmt, "tagsRaw")
        val _columnIndexOfIsBookmarked: Int = getColumnIndexOrThrow(_stmt, "isBookmarked")
        val _columnIndexOfCachedAt: Int = getColumnIndexOrThrow(_stmt, "cachedAt")
        val _result: MutableList<ArticleEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: ArticleEntity
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_columnIndexOfTitle)
          val _tmpSummary: String
          _tmpSummary = _stmt.getText(_columnIndexOfSummary)
          val _tmpContent: String
          _tmpContent = _stmt.getText(_columnIndexOfContent)
          val _tmpUrl: String
          _tmpUrl = _stmt.getText(_columnIndexOfUrl)
          val _tmpImageUrl: String
          _tmpImageUrl = _stmt.getText(_columnIndexOfImageUrl)
          val _tmpCategoryTag: String
          _tmpCategoryTag = _stmt.getText(_columnIndexOfCategoryTag)
          val _tmpAuthor: String
          _tmpAuthor = _stmt.getText(_columnIndexOfAuthor)
          val _tmpPublishedAt: String
          _tmpPublishedAt = _stmt.getText(_columnIndexOfPublishedAt)
          val _tmpReadTimeMinutes: Int
          _tmpReadTimeMinutes = _stmt.getLong(_columnIndexOfReadTimeMinutes).toInt()
          val _tmpTagsRaw: String
          _tmpTagsRaw = _stmt.getText(_columnIndexOfTagsRaw)
          val _tmpIsBookmarked: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfIsBookmarked).toInt()
          _tmpIsBookmarked = _tmp != 0
          val _tmpCachedAt: Long
          _tmpCachedAt = _stmt.getLong(_columnIndexOfCachedAt)
          _item = ArticleEntity(_tmpId,_tmpTitle,_tmpSummary,_tmpContent,_tmpUrl,_tmpImageUrl,_tmpCategoryTag,_tmpAuthor,_tmpPublishedAt,_tmpReadTimeMinutes,_tmpTagsRaw,_tmpIsBookmarked,_tmpCachedAt)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun isBookmarked(id: String): Boolean? {
    val _sql: String = "SELECT isBookmarked FROM articles WHERE id = ? LIMIT 1"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, id)
        val _result: Boolean?
        if (_stmt.step()) {
          val _tmp: Int?
          if (_stmt.isNull(0)) {
            _tmp = null
          } else {
            _tmp = _stmt.getLong(0).toInt()
          }
          _result = _tmp?.let { it != 0 }
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun updateBookmarkStatus(id: String, isBookmarked: Boolean) {
    val _sql: String = "UPDATE articles SET isBookmarked = ? WHERE id = ?"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        val _tmp: Int = if (isBookmarked) 1 else 0
        _stmt.bindLong(_argIndex, _tmp.toLong())
        _argIndex = 2
        _stmt.bindText(_argIndex, id)
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun clearNonBookmarkedArticles() {
    val _sql: String = "DELETE FROM articles WHERE isBookmarked = 0"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun clearAll() {
    val _sql: String = "DELETE FROM articles"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
