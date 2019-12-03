import android.view.View
import androidx.annotation.LayoutRes
import com.wonjong.idus.ui.common.IViewHolder

enum class IHolderType(@LayoutRes val layoutRes: Int, val creator: (View) -> IViewHolder<*>) {

}