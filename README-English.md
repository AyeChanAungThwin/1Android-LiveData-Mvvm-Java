# Android (LiveData+MVVM) using Java
## Details
> We gonna learn about creating _Login Form_ with Android.
> If you're still using same old **_id mapping with resource layout_** like `findViewById(R.id.name);`, you'd better start learning about **LiveData.**

## You're learning about the followings.
- [ ] MVC Architecture (Model---View---Controller)
- [ ] MVP Architecture (Model---View---Presenter)
- [X] MVVM Architecture (Model---View---ViewModel)
- [x] Creating Login Page in android app

## More about LiveData
> [About LiveData](https://developer.android.com/topic/libraries/architecture/livedata#java)

## Explanation
> _** 1. Add the following code in your app's __build.gradle__ file. **_
```
android {
	...
    dataBinding {
        enabled = true
    }
    ...
    dependencies {
    ...
    implementation 'android.arch.lifecycle:extensions:1.1.1'
    ...
	}
}
```

> _** 2. Create **User class** which is **Model.** **_

```
public class User {
	private String email;
	private String password;
	//getters and setters
}
```

> _** 3. Create **LoginViewModel class** **_
```
public class LoginViewModel extends ViewModel {
	....
}
```
- It must extends ViewModel so that it can create a ViewModel instance.
- Normally,  we create an object like `new LoginViewModel();` but now we can do like ` ViewModelProviders.of(this).get(LoginViewModel.class)`!

> _** 4. Syntax for Data Binding **_
- One-way Data Binding syntax `@{variable}`
   - One-way Data Binding only allow us to send the data to XML layouts.

- Two-way Data Binding syntax `@={variable}`
   - Two-way Data Binding allows us to bind objects in the XML layouts.
   - The object can send data to the layout, and vice versa.
   
- To Invoke Button Click Listener Lamda, we use `@{()->loginViewMode.method()}`!

> _** 5. main_activity.xml **_
- We normally do mapping via `/@+id` but it's no longer necessary.
- We first create **data tag** in layout xml and call with its variable name.
```
<data>
	<variable
		name="viewModel"
		type="com.acat.mvvm.viewmodel.LoginViewModel" />
</data>
```

> _** 6. MainActivity.java **_
- You can observe every time the user click a button.
```
loginViewModel.getUser().observe(this, new Observer<User>() {
	@Override
	public void onChanged(User user) {
		//Observe Here!
	}
});
```

## Electronics Engineer-cum-J2EE Backend Developer ##
-  Created by - Aye Chan Aung Thwin
