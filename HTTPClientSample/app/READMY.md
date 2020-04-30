Problem 1
=========
ClassNotFoundException: Didn't find class "org.apache.http.impl.client.DefaultHttpClient"
result

https://stackoverflow.com/questions/51591208/noclassdeffounderror-exception-in-android-stuidio
Add the following to your manifest file under 'application':
<uses-library android:name="org.apache.http.legacy" android:required="false"/>

Add the following to your build.gradle(app) under android
useLibrary 'org.apache.http.legacy'

build.gradle(app)
minSdkVersion 23


Problem 2
=========
java.io.IOException: Cleartext traffic not permitted:
decision
https://stackoverflow.com/questions/45940861/android-8-cleartext-http-traffic-not-permitted
add to manifest
android:usesCleartextTraffic="true"