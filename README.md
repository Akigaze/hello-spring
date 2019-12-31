**注意：** 切换成gradle的项目结构后，需要把spring的xml配置文件放到resources文件中才能视为是在类路径下

### gradle 多模块
#### 1. 根目录
```groovy
// setting.gradle
rootProject.name = 'hello-spring'
include 'xml'
include 'config'
include 'annotation'
include 'data'
``` 

```groovy
//build.gradle
subprojects{
// 所有子模块都要用到的，且只对子模块起作用
}
allprojects{
对所有模块起作用
}
```

#### 2. 子模块
需要添加 **build.gradle** 和 **settings.gradle** 两个文件
```groovy
//setting.gradle
rootProject.name = 'data'
```

#### 3. 项目目录
root
    - src
        - main
            - java
            - resources
        - test
            - java
            - resources
    build.gradle
    setting.gradle

#### 4. 重新导入项目，在根目录运行 gradle build

#### 5. 模块依赖
```groovy
dependencies {
//    compile project(":xml") //依赖其他子模块项目
}
```
