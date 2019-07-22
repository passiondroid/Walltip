# Walltip  
An android app to add your words on beautiful wallpapers.

![](https://s3.amazonaws.com/imagga-demo-uploads/tagging-demo/e6e70b4ab58c36a60103e2cdef2f4a63.png =200x380)

Images are taken from Unsplash.

App is architectured in 3 modules :

- app
- core
- categories

# app 
This is the main module of the app. Currently it contains the Splash Activity

# core
This module contains core components like `ConnectivityChecker`, `ViewModelFactory` etc which can be used from all other 
modules so all the common code resides here.

# categories
This module contains all categories related tasks like fetching categories from backend and showing `CategoryDetailActivity` 
All the categories related task stay here.
 