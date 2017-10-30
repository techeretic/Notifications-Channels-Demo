# Notifications-Channels-Demo
Demo for Android Oreo's Notification Channels

I was investigating how Notification Channels in Android Oreo work and ended up implementing an app.
It is solely for the purpose of testing notification channels with the various importance levels
available in NotificationManager in Android 8.0.

Currently, this app demos following importance levels by setting channels for them.
1. **DEFAULT** - Makes Sound
2. **HIGH** - Makes Sound and Pop-up on Screen
3. **MIN** - Now Sound, but icon appears in notification bar
4. **LOW** - No Sound, no icon in notification bar, but its amongst the 
5. **NONE** - Off by default, if user activates then similar to MIN

License
=======

    Copyright 2017, Prathamesh Shetye
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.