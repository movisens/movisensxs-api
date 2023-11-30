# Changelog

All notable changes to this project will be documented in this file. See [standard-version](https://github.com/conventional-changelog/standard-version) for commit guidelines.

### [0.8.2](https://github.com/movisens/movisensxs-api/compare/0.8.1...0.8.2) (2023-11-30)


### Bug Fixes

* added coroutine test ([8d4f446](https://github.com/movisens/movisensxs-api/commit/8d4f446ee3c69eafb18bae9f51ec3a8df8e7f6f9))
* deactivated tests which depend on coupled device and existing device token, which may be invalid after some time, added todo, should be fixed with other tests ([7a4899c](https://github.com/movisens/movisensxs-api/commit/7a4899c9de25266f15dd673f6883b169842f5b45))
* fixed version mismatch between retrofit and okhttp ([b6c6743](https://github.com/movisens/movisensxs-api/commit/b6c674369b1c453d973c77ac9ede4c2e769fdb1a))
* transitive dependencies ([c175bba](https://github.com/movisens/movisensxs-api/commit/c175bba587c0a2cb9845a5f527414ec9562d6027))
* updated README with kotlin examples ([7d9c31a](https://github.com/movisens/movisensxs-api/commit/7d9c31ae443e92664d17de721766d2c55a627af6))
* upgraded dependencies ([5ac3c5a](https://github.com/movisens/movisensxs-api/commit/5ac3c5a16c1f779142ed949d72165b0bb5cbc404))

### [0.8.1](https://github.com/movisens/movisensxs-api/compare/0.8.0...0.8.1) (2023-05-26)


### Features

* added plugins to toml, added versions plugin, updated to newest release kotlin ([5ebd234](https://github.com/movisens/movisensxs-api/commit/5ebd234d3e620ad72c5e0f476c63a72cbc44a705))
* added sendPushNotification end point ([0144bfc](https://github.com/movisens/movisensxs-api/commit/0144bfc0388ce4712e3bd645d0411e3c5b9015c8))
* migrated to version cataloges ([c381b59](https://github.com/movisens/movisensxs-api/commit/c381b59b383c384bfb9e44c761c71fafe3c7993b))


### Bug Fixes

* deleted code from api response, because will never be sent, is equivalent to status ([00c20e7](https://github.com/movisens/movisensxs-api/commit/00c20e7f970ad7edf9f596776789f170292f2c23))
* maven publishing ([0dfc07c](https://github.com/movisens/movisensxs-api/commit/0dfc07c1c6025ed8bdccd4b0257acf23be59ec31))
* updated all dependencies, fixed warnings ([3be4a86](https://github.com/movisens/movisensxs-api/commit/3be4a8600ce9128c921ffcf9b01e4002a0f08987))

## [0.8.0](https://github.com/movisens/movisensxs-api/compare/v0.7.1...v0.8.0) (2023-05-24)


### Features

* added kotlin and buildSrc versioning ([fadebac](https://github.com/movisens/movisensxs-api/commit/fadebac135df66491da9ef032e75c723acc00934))
* added standard notes and converted gradle files to kotlin ([4d46d26](https://github.com/movisens/movisensxs-api/commit/4d46d26ca9bb6d304dd4b5d7e3c6a6b0815e230e))
* **kotlin-conversion:** converted high level retrofit classes ([6ef8f0b](https://github.com/movisens/movisensxs-api/commit/6ef8f0b3ef7139f8a33fdb38c59ae91448fa8875))
* **kotlin-conversion:** converted tests and subpackages to kotlin ([e84c444](https://github.com/movisens/movisensxs-api/commit/e84c444ebfdb350e0bd0043d84f1a8dba9865792))
* **kotlin-conversion:** fixed tests to not create files in root, instead use temporary folder rule ([63e75b8](https://github.com/movisens/movisensxs-api/commit/63e75b8fbd5e45fed1ae910b7361c9961eb814be))
* **kotlin-conversion:** upgraded retrofit version and added coroutine test ([214b27a](https://github.com/movisens/movisensxs-api/commit/214b27ab7e51b9c798d2e834638619b6b10a9d18))
* upgraded gradle version ([3b8259e](https://github.com/movisens/movisensxs-api/commit/3b8259e7db576ad29a81a460f25409b0cee8c365))


### Bug Fixes

* add config to remove tag prefix ([cd46911](https://github.com/movisens/movisensxs-api/commit/cd469114a4aeb7df232aa7266f9ba1c6c352c953))
* deleted not usable routes ([5d950fa](https://github.com/movisens/movisensxs-api/commit/5d950fa3e7b2c4896b0ec7b8928c86fa896112b7))

### 0.7.1 (2022-03-21)


### Features

* add list of monitorings ([812f1d8](https://github.com/movisens/movisensxs-api/commit/812f1d8fc161d3aa2dc49ccc68628dc236625126))
* added api to post compliance data ([3b959bf](https://github.com/movisens/movisensxs-api/commit/3b959bf49a6f7c98a12cd88d0e0d9a916544b7cd))
* remove MonitoringType from MonitoringAlert and MonitoringCompliance constructors ([a430bcb](https://github.com/movisens/movisensxs-api/commit/a430bcb99cd07058587d1a61b794c4eec2abc833))
* renamed compliance to monitoring ([0161cac](https://github.com/movisens/movisensxs-api/commit/0161cacdef10d3391e025640562b984e59363571))
* update monitoring client with the new format for request body ([4248fed](https://github.com/movisens/movisensxs-api/commit/4248fed3fb5f5be794cb6cc3fa3ef0329faaf44c))


### Bug Fixes

* fixed tests ([e455958](https://github.com/movisens/movisensxs-api/commit/e455958de792b213d04f89eec57daad70e587335))
