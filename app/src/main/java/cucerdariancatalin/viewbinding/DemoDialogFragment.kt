package cucerdariancatalin.viewbinding

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager
import com.hoc081098.viewbindingdelegate.DefaultViewBindingDialogFragment
import com.hoc081098.viewbindingdelegate.dialogFragmentViewBinding
import cucerdariancatalin.viewbinding.databinding.DialogFragmentDemoBinding

class DemoDialogFragment : DefaultViewBindingDialogFragment() {
    private val viewBinding by dialogFragmentViewBinding(R.id.root, DialogFragmentDemoBinding::bind) {
        Log.d("###", "onDestroyView$this")
        Log.d("###", "onDestroyView$textInputLayout")
    }
    private val viewBinding2 by dialogFragmentViewBinding<DialogFragmentDemoBinding>(R.id.root) {
        Log.d("###", "onDestroyView$this")
        Log.d("###", "onDestroyView$textInputLayout")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Demo dialog")
            .setNegativeButton("Cancel") { _, _ -> }
            .setPositiveButton("OK") { _, _ -> }
            .setView(R.layout.dialog_fragment_demo)
            .create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        access()
    }

    override fun onResume() {
        super.onResume()
        access()
    }

    private fun access() {
        Log.d("###", viewBinding.toString())
        Log.d("###", viewBinding.textInputLayout.toString())

        Log.d("###", viewBinding2.toString())
        Log.d("###", viewBinding2.textInputLayout.toString())
    }

    companion object {
        private val tag = DemoDialogFragment::class.java.simpleName

        fun show(fm: FragmentManager) {
            (fm.findFragmentByTag(tag) as? DemoDialogFragment)?.let {
                fm.beginTransaction().remove(it).commit()
            }
            DemoDialogFragment().show(fm, tag)
        }
    }
}
