package com.example.modul4.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/modul4/adapter/PostAdapterRoom;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/modul4/adapter/PostAdapterRoom$PostViewHolder;", "postList", "", "Lcom/example/modul4/room/PostDatabase;", "(Ljava/util/List;)V", "onItemClickCallback", "Lcom/example/modul4/adapter/PostAdapterRoom$OnItemClickCallback;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemClickCallback", "shorten", "", "maxLength", "OnItemClickCallback", "PostViewHolder", "app_debug"})
public final class PostAdapterRoom extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.modul4.adapter.PostAdapterRoom.PostViewHolder> {
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.modul4.room.PostDatabase> postList;
    private com.example.modul4.adapter.PostAdapterRoom.OnItemClickCallback onItemClickCallback;
    
    public PostAdapterRoom(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.modul4.room.PostDatabase> postList) {
        super();
    }
    
    public final void setOnItemClickCallback(@org.jetbrains.annotations.NotNull
    com.example.modul4.adapter.PostAdapterRoom.OnItemClickCallback onItemClickCallback) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.modul4.adapter.PostAdapterRoom.PostViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.modul4.adapter.PostAdapterRoom.PostViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    private final java.lang.String shorten(java.lang.String $this$shorten, int maxLength) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/modul4/adapter/PostAdapterRoom$OnItemClickCallback;", "", "onItemClicked", "", "data", "Lcom/example/modul4/room/PostDatabase;", "app_debug"})
    public static abstract interface OnItemClickCallback {
        
        public abstract void onItemClicked(@org.jetbrains.annotations.NotNull
        com.example.modul4.room.PostDatabase data);
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/example/modul4/adapter/PostAdapterRoom$PostViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "btnLike", "Landroid/widget/LinearLayout;", "getBtnLike", "()Landroid/widget/LinearLayout;", "btnMore", "Landroid/widget/ImageView;", "getBtnMore", "()Landroid/widget/ImageView;", "postDesc", "Landroid/widget/TextView;", "getPostDesc", "()Landroid/widget/TextView;", "postImg", "Lcom/google/android/material/imageview/ShapeableImageView;", "getPostImg", "()Lcom/google/android/material/imageview/ShapeableImageView;", "postLike", "getPostLike", "postTitle", "getPostTitle", "app_debug"})
    public static final class PostViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView postTitle = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView postDesc = null;
        @org.jetbrains.annotations.NotNull
        private final com.google.android.material.imageview.ShapeableImageView postImg = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView postLike = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.LinearLayout btnLike = null;
        @org.jetbrains.annotations.NotNull
        private final android.widget.ImageView btnMore = null;
        
        public PostViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getPostTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getPostDesc() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.android.material.imageview.ShapeableImageView getPostImg() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getPostLike() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.LinearLayout getBtnLike() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getBtnMore() {
            return null;
        }
    }
}