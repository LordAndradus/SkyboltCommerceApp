package edu.utsa.cs3443.skyboltcommerceapp.Fragments.LoginRegister

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import edu.utsa.cs3443.skyboltcommerceapp.Data.User
import edu.utsa.cs3443.skyboltcommerceapp.R
import edu.utsa.cs3443.skyboltcommerceapp.Util.Resource
import edu.utsa.cs3443.skyboltcommerceapp.ViewModels.RegisterViewModel
import edu.utsa.cs3443.skyboltcommerceapp.databinding.FragmentRegisterBinding
import kotlinx.coroutines.launch

/**
 * Handles the fragment xml for registering users.
 *
 * Adds functionality to the various buttons and editor text fields
 */

@AndroidEntryPoint
class RegisterFragment : Fragment()
{
    //The binder takes the Register_Fragement.xml, this is the alternative to R.layout. Thanks dagger hilt!
    private lateinit var binding : FragmentRegisterBinding
    private val viewModel by viewModels<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater);
        return binding.root
    }

    /**
     * The entire purpose of this function is to type less periods and words to EditText fields when converting to a string and trimming it.
     */
    private fun input(et: android.widget.EditText): String
    {
        return et.text.toString().trim();
    }

    /**
     * A function that create a new user when the fields are properly inputted.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        binding.apply{
            RegisterAccountNow.setOnClickListener{
                val user = User(
                    input(EnterFirstName),
                    input(EnterLastName),
                    input(EnterEmail),
                )

                val password : String = input(EnterPassword);

                if(user.FirstName.isEmpty() || user.LastName.isEmpty() || user.Email.isEmpty() || password.isEmpty())
                {
                    //Do something, for now we return
                    return@setOnClickListener;
                }

                viewModel.CreateAccountWithEmailAndPassword(user, password);
            }
        }

        //This is to specifically play an animation based on the state of Firebase, it will update when it reports anything
        lifecycleScope.launchWhenStarted {
            viewModel.register.collect{
                when(it)
                {
                    is Resource.Loading ->{
                        binding.RegisterAccountNow.startAnimation();
                    }

                    is Resource.Success ->{
                        Log.d("Registration", it.data.toString())
                        binding.RegisterAccountNow.revertAnimation();
                    }

                    is Resource.Error ->{
                        Log.e("Registration", it.message.toString())
                        binding.RegisterAccountNow.revertAnimation();
                    }
                }
            }
        }
    }
}