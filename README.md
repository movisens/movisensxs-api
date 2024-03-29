movisensXS API for Java
============
<a href="https://jitpack.io/#movisens/movisensxs-api/"><img src="https://img.shields.io/github/tag/movisens/movisensxs-api.svg?label=Maven%20on%20JitPack" /></a>

The movisensXS API for Java enables Java developers to easily work with the movisensXS server.

Warning: This API is currently in early beta and will be subject to change!

A Postman collection of the movisensXS API is available here: https://www.getpostman.com/collections/0d55d82e27882ca7fbb8

### Set up ###

Add the JitPack repository and the dependency to your build file:
#### Gradle ####
```gradle
repositories {
    maven { url "https://jitpack.io" }
}
dependencies {
    compile 'com.github.movisens:movisensxs-api:0.8.2'
}
```
#### Maven ####
```maven
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
<dependency>
    <groupId>com.github.movisens</groupId>
    <artifactId>movisensxs-api</artifactId>
    <version>0.8.2</version>
</dependency>
```
### Example Usage ###
#### Java
```java

// Create movisensXS Service
String SERVER_URL = "https://xs.movisens.com";
String API_KEY = "API KEY HERE";

XSService service = new XSApi.Builder(API_KEY).setServer(SERVER_URL).build().create(XSService.class);

// Call API synchronous
List<Proband> probands = service.getProbands(STUDY_ID).execute().body();

// Or asynchronous	
call.enqueue(new Callback<List<Proband>>() {
	@Override
	public void onResponse(Response<List<Proband>> response, Retrofit retrofit) {
		// TODO: Handle response
	}

	@Override
	public void onFailure(Throwable t) {
		// TODO: Handle error
	}
});
```

#### Kotlin
```kotlin

// Create movisensXS Service
val SERVER_URL = "https://xs.movisens.com";
val API_KEY = "API KEY HERE";

private val service = XSApi.Builder(API_KEY)
        .setServer(SERVER_URL)
        .build()
        .create(XSService::class.java)

// Call API via coroutine
val probands = service.getProbands(STUDY_ID).await()
```


### Error handling ###

If there is an unsuccessful response then an MovisensXSException or a subclass of MovisensXSException will be thrown.

The API throws the following exceptions:

  - AuthorizationException: for a 401 or 403 response 
  - NotFoundException: for a 404 response 
  - ServerException: for a 500 or 503 response
  - NetworkIOException: for network problems
  - MovisensXSException: general exception 

### License ###
Copyright 2015 movisens GmbH

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
