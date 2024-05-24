package com.example.modul4.room;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/modul4/room/PostRepository;", "", "postDao", "Lcom/example/modul4/room/PostDao;", "appExecutors", "Lcom/example/modul4/utils/AppExecutors;", "(Lcom/example/modul4/room/PostDao;Lcom/example/modul4/utils/AppExecutors;)V", "getAllPost", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/modul4/room/PostDatabase;", "insertPost", "", "post", "Companion", "app_debug"})
public final class PostRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.modul4.room.PostDao postDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.modul4.utils.AppExecutors appExecutors = null;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.example.modul4.room.PostRepository instance;
    @org.jetbrains.annotations.NotNull
    public static final com.example.modul4.room.PostRepository.Companion Companion = null;
    
    private PostRepository(com.example.modul4.room.PostDao postDao, com.example.modul4.utils.AppExecutors appExecutors) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.modul4.room.PostDatabase>> getAllPost() {
        return null;
    }
    
    public final void insertPost(@org.jetbrains.annotations.NotNull
    com.example.modul4.room.PostDatabase post) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/modul4/room/PostRepository$Companion;", "", "()V", "instance", "Lcom/example/modul4/room/PostRepository;", "getInstance", "postDao", "Lcom/example/modul4/room/PostDao;", "appExecutors", "Lcom/example/modul4/utils/AppExecutors;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.modul4.room.PostRepository getInstance(@org.jetbrains.annotations.NotNull
        com.example.modul4.room.PostDao postDao, @org.jetbrains.annotations.NotNull
        com.example.modul4.utils.AppExecutors appExecutors) {
            return null;
        }
    }
}