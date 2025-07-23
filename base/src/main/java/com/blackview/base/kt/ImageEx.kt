package com.blackview.base.kt

import android.graphics.Bitmap
import android.os.Build
import android.widget.ImageView
import androidx.annotation.DrawableRes
import coil.ImageLoader
import coil.bitmap.BitmapPool
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load
import coil.size.Size
import coil.size.ViewSizeResolver
import coil.transform.RoundedCornersTransformation
import coil.transform.Transformation
import com.blackview.base.R
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.ImageUtils
import com.blankj.utilcode.util.Utils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import java.io.ByteArrayOutputStream
import java.io.File
import java.util.Locale

/**
 * @author : tiaozi
 * time : 2020/11/28 0:29
 */
fun ImageView.loadRadius(imageUrl: String?, radius: Float = 8f, error: Int? = null) {
    loadRadius(imageUrl, radius, radius, radius, radius, error)
}

fun ImageView.loadGif(imageUrl: String, placeholder: Int? = null) {
    val url = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        imageUrl
    } else {
        imageUrl.split("?").getOrNull(0)
    }
    load(url, ImageLoader.Builder(context)
        .componentRegistry {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                add(ImageDecoderDecoder())
            } else {
                add(GifDecoder())
            }
        }
        .build())
    {
        //transformations(LargeBitMapTransformation())  影响GIF
        size(ViewSizeResolver(this@loadGif))
        error(R.mipmap.ic_norm_goods)
        if (placeholder != null) {
            placeholder(placeholder)
        }
    }
}

fun ImageView.loadGif(file: File, placeholder: Int? = null) {
    load(file, ImageLoader.Builder(context)
        .componentRegistry {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                add(ImageDecoderDecoder())
            } else {
                add(GifDecoder())
            }
        }
        .build())
    {
        //transformations(LargeBitMapTransformation())  影响GIF
        size(ViewSizeResolver(this@loadGif))
        error(R.mipmap.ic_norm_goods)
        if (placeholder != null) {
            placeholder(placeholder)
        }
    }
}

fun ImageView.loadGif(@DrawableRes drawableResId: Int, placeholder: Int? = null) {
    load(drawableResId, ImageLoader.Builder(context)
        .componentRegistry {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                add(ImageDecoderDecoder())
            } else {
                add(GifDecoder())
            }
        }
        .build())
    {
        //transformations(LargeBitMapTransformation())  影响GIF
        size(ViewSizeResolver(this@loadGif))
        error(R.mipmap.ic_norm_goods)
        if (placeholder != null) {
            placeholder(placeholder)
        }
    }
}

fun ImageView.loadThumb(file: File) {
    Glide.with(this)
        .load(file)
        .into(this)
}

fun glideOptions(): RequestOptions {
    val options = RequestOptions()
    options.fitCenter().placeholder(R.mipmap.img_default).error(R.mipmap.img_default)
        .fallback(R.mipmap.img_default).override(88.dp.toInt(), 88.dp.toInt())
    return options
}

fun ImageView.loadThumb(path: String) {
    Glide.with(this)
        .load(File(path))
        .placeholder(R.mipmap.img_default)
        .error(R.mipmap.img_default)
        .into(this)
}

// 加载图片缩略图并转换为字节数组
fun ImageView.loadThumbnail(imagePath: String) {
    val requestOptions = RequestOptions()
        .override(88, 88) // 设置缩略图的尺寸
        .centerCrop() // 可选，根据需要设置图片缩放方式，这里使用centerCrop作为示例

    Glide.with(Utils.getApp())
        .asBitmap()
        .load(imagePath) // 图片路径
        .apply(requestOptions) // 应用请求选项
        .into(object : SimpleTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                this@loadThumbnail.setImageBitmap(resource)
            }
        })
}

fun ImageView.loadThumb(bitmap: Bitmap?) {
    Glide.with(this)
        .load(bitmap)
        .into(this)
}

fun ImageView.loadRadius(
    imageUrl: String?,
    topLeft: Float = 0f,
    topRight: Float = 0f,
    bottomLeft: Float = 0f,
    bottomRight: Float = 0f,
    @DrawableRes error: Int? = null
) {
    val image = imageUrl ?: ""
    load(image) {
        size(ViewSizeResolver(this@loadRadius))
        val topLeftFloat = ConvertUtils.dp2px(topLeft).toFloat()
        val topRightFloat = ConvertUtils.dp2px(topRight).toFloat()
        val bottomLeftFloat = ConvertUtils.dp2px(bottomLeft).toFloat()
        val bottomRightFloat = ConvertUtils.dp2px(bottomRight).toFloat()
        transformations(
            RoundedCornersTransformation(
                topLeft = topLeftFloat,
                topRight = topRightFloat,
                bottomLeft = bottomLeftFloat,
                bottomRight = bottomRightFloat
            )
        )
        placeholder(R.mipmap.ic_norm_goods)
        error(error ?: R.mipmap.ic_norm_goods)
    }
}

class LargeBitMapTransformation : Transformation {

    override fun key(): String = LargeBitMapTransformation::class.java.name

    override suspend fun transform(pool: BitmapPool, input: Bitmap, size: Size): Bitmap {
        return ImageUtils.bytes2Bitmap(ImageUtils.compressByQuality(input, 100))
    }

    override fun equals(other: Any?) = other is LargeBitMapTransformation

    override fun hashCode() = javaClass.hashCode()

    override fun toString() = "LargeBitMapTransformation()"

}