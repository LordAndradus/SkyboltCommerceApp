package edu.utsa.cs3443.skyboltcommerceapp.ViewModels

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.utsa.cs3443.skyboltcommerceapp.Data.User
import edu.utsa.cs3443.skyboltcommerceapp.Util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

/**
 * This controls the registration fragment and handles registering new users when clicking on the "REGISTER" button
 * Additionally, we will implement some Firebase back-end code.
 * Lastly, we are using Dagger Hilt as it makes the process of injecting code to ViewModels much more easier.
 */

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val _FirebaseAuthenticator: FirebaseAuth
): ViewModel() {
    //We will be using registers here to keep track of how the app is operating, and to react accordingly
    private val _register = MutableStateFlow<Resource<FirebaseUser>>(Resource.Loading())
    val register: Flow<Resource<FirebaseUser>> = _register

    //Creates a new user and uploads that data to a Firebase database
    fun CreateAccountWithEmailAndPassword(user: User, password: String)
    {
        _FirebaseAuthenticator.createUserWithEmailAndPassword(user.Email, password)
            .addOnSuccessListener {
                it.user?.let {
                    _register.value = Resource.Success(it)
                }
            }.addOnFailureListener{
                _register.value = Resource.Error(it.message.toString())
            }
    }
}