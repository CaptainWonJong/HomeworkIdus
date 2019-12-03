import android.view.View
import androidx.annotation.LayoutRes
import com.wonjong.idus.R
import com.wonjong.idus.ui.common.IViewHolder

enum class IHolderType(@LayoutRes val layoutRes: Int, val creator: (View) -> IViewHolder<*>) {

    ProductsList(R.layout.holder_item_products, { com.wonjong.idus.ui.holder.ProductsListHolder(it) }),
}