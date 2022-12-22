package cucerdariancatalin.viewbinding

import android.app.Application
import cucerdariancatalin.viewbinding.databinding.FragmentFourthBinding
import cucerdariancatalin.viewbinding.databinding.FragmentThirdBinding
import cucerdariancatalin.viewbinding.databinding.FragmentThirdIncludeBinding
import cucerdariancatalin.viewbinding.databinding.ItemRecyclerBinding
import com.hoc081098.viewbindingdelegate.preloadBindMethods
import com.hoc081098.viewbindingdelegate.preloadInflateMethods

class MyApp : Application() {
  override fun onCreate() {
    super.onCreate()

    preloadBindMethods(
      FragmentThirdBinding::class,
      FragmentThirdIncludeBinding::class,
      FragmentFourthBinding::class
    )
    preloadInflateMethods(
      ItemRecyclerBinding::class
    )
  }
}
