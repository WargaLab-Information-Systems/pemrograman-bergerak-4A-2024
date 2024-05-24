package com.example.modul4.room;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.File;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PostDao_Impl implements PostDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PostDatabase> __insertionAdapterOfPostDatabase;

  private final AppConverter __appConverter = new AppConverter();

  public PostDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPostDatabase = new EntityInsertionAdapter<PostDatabase>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `PostDatabase` (`id`,`post_title`,`post_desc`,`post_image`,`post_like`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PostDatabase value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        final String _tmp = __appConverter.fromFile(value.getImage());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
        stmt.bindLong(5, value.getLike());
      }
    };
  }

  @Override
  public void insertPost(final PostDatabase postDatabase) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPostDatabase.insert(postDatabase);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<PostDatabase>> getAllPost() {
    final String _sql = "SELECT * FROM postdatabase ORDER BY post_title ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"postdatabase"}, false, new Callable<List<PostDatabase>>() {
      @Override
      public List<PostDatabase> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "post_title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "post_desc");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "post_image");
          final int _cursorIndexOfLike = CursorUtil.getColumnIndexOrThrow(_cursor, "post_like");
          final List<PostDatabase> _result = new ArrayList<PostDatabase>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PostDatabase _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final File _tmpImage;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfImage);
            }
            _tmpImage = __appConverter.toFile(_tmp);
            final int _tmpLike;
            _tmpLike = _cursor.getInt(_cursorIndexOfLike);
            _item = new PostDatabase(_tmpId,_tmpName,_tmpDescription,_tmpImage,_tmpLike);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
