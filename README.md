movisensXS API for Java
============
<a href="https://jitpack.io/#movisens/movisensxs-api/"><img src="https://img.shields.io/github/tag/movisens/movisensxs-api.svg?label=Maven on JitPack" /></a>

The movisensXS API for Java enables Java developers to easily work with the movisensXS server.

Warning: This API is currently in early beta and will be subject to change!

### Set up ###

Add the JitPack repository and the dependency to your build file:
#### Gradle ####
```gradle
repositories {
    maven { url "https://jitpack.io" }
}
dependencies {
    compile 'com.github.movisens:movisensxs-api:0.4'
}
```
#### SBT ####
```sbt
resolvers += "jitpack" at "https://jitpack.io"
libraryDependencies += "com.github.movisens" % "movisensxs-api" % "0.4"
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
    <version>0.4</version>
</dependency>
```
### Example Usage ###
```java

// Create movisensXS Service
String SERVER_URL = "https://xs.movisens.com";
String API_KEY = "API KEY HERE";
	
XSService service = new XSApi.Builder(API_KEY).setServer(SERVER_URL)
			.build().create(XSService.class);

// Call API synchronous
List<Proband> probands = service.getProbands(989);

// Or asynchronous	
service.getProbands(989, new Callback<List<Proband>>() {
	@Override
	public void success(List<Proband> probands, Response response) {
    // TODO: Handle response
	}

	@Override
	public void failure(RetrofitError error) {
    // TODO: Handle response
	}
});
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
