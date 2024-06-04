package com.avrzll.implementasi5

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.avrzll.implementasi5.room.PostDatabase
import com.avrzll.implementasi5.room.PostViewModel
import com.avrzll.implementasi5.room.PostViewModelFactory
import com.google.android.material.button.MaterialButton

class PopUpPracticeFragment(private val postEntity: PostDatabase) : DialogFragment() {

    // Mendeklarasikan ViewModel untuk interaksi dengan database
    private lateinit var postViewModel: PostViewModel

    // Fungsi getTheme digunakan untuk mendapatkan tema dialog.
    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

    // Fungsi onStart dipanggil ketika dialog dimulai.
    // Fungsi ini digunakan untuk mengatur layout dialog.
    override fun onStart() {
        super.onStart()
        requireDialog().window?.apply {
            setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }

        view?.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            setMargins(16, 16, 16, 16)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pop_up_practice, container, false)
    }

    // Fungsi onViewCreated dipanggil setelah tampilan dialog dibuat.
    // Fungsi ini digunakan untuk menginisialisasi ViewModel dan menangani aksi klik pada tombol ubah dan hapus.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mendapatkan instance ViewModel.
        val factory = PostViewModelFactory.getInstance(requireContext())
        postViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]

        // Mendapatkan referensi ke tombol ubah dan hapus.
        val btnUbah: Button = view.findViewById(R.id.btn_ubah)
        val btnHapus: Button = view.findViewById(R.id.btn_hapus)

        // Menangani aksi klik pada tombol ubah.
        // Ketika tombol ubah diklik, intent baru dibuat untuk memulai UpdatePlayerRoomActivity dan pemain yang dipilih dikirim sebagai extra.
        btnUbah.setOnClickListener {
            val intent = Intent(requireContext(), UpdatePostActivity::class.java)
            intent.putExtra("post", postEntity)
            startActivity(intent)
            dismiss()
        }

        // Menangani aksi klik pada tombol hapus.
        // Ketika tombol hapus diklik, pemain yang dipilih dihapus dari database dan dialog ditutup.
        btnHapus.setOnClickListener {
            postViewModel.deletePost(postEntity)
            dismiss()
        }
    }

    companion object {
        const val TAG = "PopUpPracticeFragment"
    }

}