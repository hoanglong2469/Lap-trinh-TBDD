package com.example.on_tap.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.on_tap.entity.Book;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings("unchecked")
public final class BookDAO_Impl extends BookDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfBook;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfBook;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfBook;

  public BookDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBook = new EntityInsertionAdapter<Book>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `books`(`id`,`ten`,`tacGia`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Book value) {
        stmt.bindLong(1, value.getId());
        if (value.getTen() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTen());
        }
        if (value.getTacGia() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTacGia());
        }
      }
    };
    this.__deletionAdapterOfBook = new EntityDeletionOrUpdateAdapter<Book>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `books` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Book value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfBook = new EntityDeletionOrUpdateAdapter<Book>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `books` SET `id` = ?,`ten` = ?,`tacGia` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Book value) {
        stmt.bindLong(1, value.getId());
        if (value.getTen() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTen());
        }
        if (value.getTacGia() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTacGia());
        }
        stmt.bindLong(4, value.getId());
      }
    };
  }

  @Override
  public void insert(Book book) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfBook.insert(book);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(Book book) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfBook.handle(book);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(Book book) {
    __db.beginTransaction();
    try {
      __updateAdapterOfBook.handle(book);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Book findById(String id) {
    final String _sql = "SELECT * FROM books WHERE id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final Book _result;
      if(_cursor.moveToFirst()) {
        _result = __entityCursorConverter_comExampleOnTapEntityBook(_cursor);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  private Book __entityCursorConverter_comExampleOnTapEntityBook(Cursor cursor) {
    final Book _entity;
    final int _cursorIndexOfId = cursor.getColumnIndex("id");
    final int _cursorIndexOfTen = cursor.getColumnIndex("ten");
    final int _cursorIndexOfTacGia = cursor.getColumnIndex("tacGia");
    _entity = new Book();
    if (_cursorIndexOfId != -1) {
      final int _tmpId;
      _tmpId = cursor.getInt(_cursorIndexOfId);
      _entity.setId(_tmpId);
    }
    if (_cursorIndexOfTen != -1) {
      final String _tmpTen;
      _tmpTen = cursor.getString(_cursorIndexOfTen);
      _entity.setTen(_tmpTen);
    }
    if (_cursorIndexOfTacGia != -1) {
      final String _tmpTacGia;
      _tmpTacGia = cursor.getString(_cursorIndexOfTacGia);
      _entity.setTacGia(_tmpTacGia);
    }
    return _entity;
  }
}
