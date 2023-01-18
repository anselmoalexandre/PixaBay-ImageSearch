package mz.co.bilheteira.pixabayimagesearch.extensions

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.view.WindowManager
import androidx.annotation.DrawableRes
import androidx.core.view.isVisible
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import mz.co.bilheteira.pixabayimagesearch.R
import java.util.*

fun Dialog.showActionDialog(
    title: String,
    message: String,
    isImageActive: Boolean = true,
    isPrimaryActive: Boolean = true,
    primaryTitle: String = "Yes",
    secondaryTitle: String = "Cancel",
    @DrawableRes imageIcon: Int = R.drawable.ic_information_outline,
    positiveAction: () -> (Unit)
) {
    setCanceledOnTouchOutside(false)
    setCancelable(true)
    setContentView(R.layout.dialog_image_details)
    val window: Window = Objects.requireNonNull<Window>(window).also {
        it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        it.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }
    show()
    val statusImage: ShapeableImageView = findViewById(R.id.image)
    val titleView: MaterialTextView = findViewById(R.id.header)
    val primaryButton: MaterialButton = findViewById(R.id.primaryButton)
    val secondaryButton: MaterialButton = findViewById(R.id.secondaryButton)
    titleView.text = title
    primaryButton.text = primaryTitle
    secondaryButton.text = secondaryTitle
    if (imageIcon != 0) {
        statusImage.setImageDrawable(
            VectorDrawableCompat.create(statusImage.context.resources, imageIcon, null)!!
        )
    }
    statusImage.isVisible = isImageActive
    primaryButton.isVisible = isPrimaryActive

    primaryButton.setOnClickListener {
        positiveAction()
        dismiss()
    }

    secondaryButton.setOnClickListener {
        dismiss()
    }
}
