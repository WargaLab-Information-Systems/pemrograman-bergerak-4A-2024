package com.example.modul4.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
// Kelas PostViewModel adalah kelas yang bertugas untuk menghubungkan Repository dan UI.
// Kelas ini mewarisi ViewModel, yang merupakan kelas dari Android Architecture Components yang digunakan untuk menyimpan dan mengelola data yang terkait dengan UI.
//membuat viewmodel untuk akses repository
class PostViewModel(private val postRepository: PostRepository) : ViewModel() {
    // Memasukkan data postingan ke dalam database
    fun insertPost(post: PostDatabase) {
        postRepository.insertPost(post)
    }
    // Mendapatkan semua data postingan dari database
    fun getAllPost(): LiveData<List<PostDatabase>> {
        return postRepository.getAllPost()
    }
    // menghapus data postingan di database
    fun deletePost(post: PostDatabase) {
        postRepository.deletePost(post)
    }
    // mengubah data postingan di database
    fun updatePlayer(post: PostDatabase) {
        postRepository.updatePlayer(post)
    }
}