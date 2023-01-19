# PixaBay-ImageSearch
This app uses PixaBay api to search for different images types based on user inputs

- ### What things gave me problems
Uhm, I had no problems doing this task.
It's true that I had to think and re-think about my approach but, to be honest, I just had fun
working on it.

- ### Other thoughts, where I would like to improve if given more time, etc
Just for the sack of time, I decided to make those change only. But yes, there are lots of things
that can be improved on the code base, such as:
- `Improve the UX/UI`
- `Handle/add more offline first approach`
- `Migrate the app to MDC-3`
- `Add more gradle tasks to automate code checks, formating`, etc

Given more time, some of these item can be improved.

Libraries Used
--------------
* [Foundation][0] - Components for core system capabilities, Kotlin extensions and support for
  multidex and automated testing.
    * [AppCompat][1] - Degrade gracefully on older versions of Android.
    * [Android KTX][2] - Write more concise, idiomatic Kotlin code.
    * [Test][4] - An Android testing framework for unit and runtime UI tests.
* [Architecture][5] - A collection of libraries that help you design robust, testable, and
  maintainable apps. Start with classes for managing your UI component lifecycle and handling data
  persistence.
    * [Lifecycles][6] - Create a UI that automatically responds to lifecycle events.
    * [LiveData][7] - Build data objects that notify views when the underlying database changes.
    * [Navigation][8] - Handle everything needed for in-app navigation.
    * [Room][9] - Access your app's SQLite database with in-app objects and compile-time checks.
    * [ViewModel][10] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
      asynchronous tasks for optimal execution.
* [UI][11] - Details on why and how to use UI Components in your apps - together or separate
    * [Fragment][12] - A basic unit of composable UI.
    * [Layout][13] - Lay out widgets using different algorithms.
* Third party and miscellaneous libraries
    * [Coil][14] for image loading
    * [Hilt][15]: for [dependency injection][16]
    * [Kotlin Coroutines][17] for managing background threads with simplified code and reducing needs for callbacks
    * [MockK][18] for unit test mocks

[0]: https://developer.android.com/jetpack/components
[1]: https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat
[2]: https://developer.android.com/kotlin/ktx
[4]: https://developer.android.com/training/testing/
[5]: https://developer.android.com/jetpack/arch/
[6]: https://developer.android.com/topic/libraries/architecture/lifecycle
[7]: https://developer.android.com/topic/libraries/architecture/livedata
[8]: https://developer.android.com/topic/libraries/architecture/navigation/
[9]: https://developer.android.com/topic/libraries/architecture/room
[10]: https://developer.android.com/topic/libraries/architecture/viewmodel
[11]: https://developer.android.com/guide/topics/ui
[12]: https://developer.android.com/guide/components/fragments
[13]: https://developer.android.com/guide/topics/ui/declaring-layout
[14]: https://coil-kt.github.io/coil/
[15]: https://developer.android.com/training/dependency-injection/hilt-android
[16]: https://developer.android.com/training/dependency-injection
[17]: https://kotlinlang.org/docs/reference/coroutines-overview.html
[18]: https://mockk.io

Android Studio IDE setup
------------------------
For development, the latest version of Android Studio is required. The latest version can be
downloaded from [here](https://developer.android.com/studio/).

License
-------

Copyright 2018 Google, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.

