package cucerdariancatalin.viewbinding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hoc081098.viewbindingdelegate.viewBinding
import cucerdariancatalin.viewbinding.databinding.FragmentThirdBinding
import cucerdariancatalin.viewbinding.databinding.FragmentThirdIncludeBinding

class Reflection2Fragment : Fragment(R.layout.fragment_third) {
    private val includeBinding by viewBinding<FragmentThirdIncludeBinding>()
    private val binding by viewBinding<FragmentThirdBinding> {
        buttonThird.setOnClickListener(null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        includeBinding.textViewThirdInclude.text = "Working..."
        binding.buttonThird.setOnClickListener {
            findNavController().navigate(R.id.actionThirdFragmentToFourthFragment)
        }
    }
}
