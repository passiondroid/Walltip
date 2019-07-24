# <img src="./walltip.png">

<img src="https://dl.dropboxusercontent.com/s/a3j5mntrl8e8gs4/Artboa.png" width="500">

#### An android app to add your words on beautiful wallpapers.

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



## MIT License

Copyright (c) 2019 Arif Khan

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
