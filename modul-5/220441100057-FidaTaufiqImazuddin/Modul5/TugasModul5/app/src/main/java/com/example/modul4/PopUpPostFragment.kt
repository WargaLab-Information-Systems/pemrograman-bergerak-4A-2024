package com.example.modul4

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.modul4.room.PostDatabase
import com.example.modul4.room.PostViewModel
import com.example.modul4.room.PostViewModelFactory
import com.google.android.material.button.MaterialButton

class PopUpPostFragment(private val postDatabase: PostDatabase) : DialogFragment()  {


    // Mendeklarasikan ViewModel untuk interaksi dengan database
    private lateinit var postViewModel: PostViewModel

    // Fungsi getTheme digunakan untuk mendapatkan tema dialog.
//    override fun getTheme(): Int {
//        return R.style.DialogTheme
//    }

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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pop_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = PostViewModelFactory.getInstance(requireContext())
        postViewModel = ViewModelProvider(this, factory)[PostViewModel::class.java]

        val btnUbah: Button = view.findViewById(R.id.btn_ubah)
        val btnHapus: Button = view.findViewById(R.id.btn_hapus)

        btnUbah.setOnClickListener{
            val intent = Intent(requireContext(), UpdatePostActivity::class.java)
            intent.putExtra("Posting", postDatabase)
            startActivity(intent)
            dismiss()
        }

        btnHapus.setOnClickListener{
            postViewModel.deletePost(postDatabase)
            dismiss()
        }
    }

    companion object {
        const val TAG = "PopUpFragment"
    }
}