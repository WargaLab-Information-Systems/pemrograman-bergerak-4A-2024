package com.example.modul4.room;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\'\u00a8\u0006\t"}, d2 = {"Lcom/example/modul4/room/PostDao;", "", "getAllPost", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/modul4/room/PostDatabase;", "insertPost", "", "postDatabase", "app_debug"})
@androidx.room.Dao
public abstract interface PostDao {
    
    @androidx.room.Insert(onConflict = 5)
    public abstract void insertPost(@org.jetbrains.annotations.NotNull
    com.example.modul4.room.PostDatabase postDatabase);
    
    @androidx.room.Query(value = "SELECT * FROM postdatabase ORDER BY post_title ASC")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.modul4.room.PostDatabase>> getAllPost();
}