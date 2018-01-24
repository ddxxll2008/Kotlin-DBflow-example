#Kotlin-DBflow-example

DBFlow是一个功能强大的，非常简单的，带有注解处理的ORM Android数据库。github地址[Raizlabs/DBFlow](https://github.com/Raizlabs/DBFlow)

如果想在kotlin中使用DBFlow，可以查看官方示例，地址[JetBrains/kotlin-examples/gradle/android-dbflow](https://github.com/JetBrains/kotlin-examples/tree/master/gradle/android-dbflow)

不过官方的示例只是简单演示了下如何创建数据库，增加数据和查找数据，并没有详细的介绍。所以在此建立一个库，简单记录一些DBFlow在kotlin中的使用。

##gradle依赖

project build.gradle

```
    ext.kotlin_version = '1.2.20'
    ext.dbflow_version = '4.2.4'
    
    dependencies {
        classpath 'com.android.tools.build:gradle:3.0.1'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        }
```

app build.gradle

```
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'
apply plugin: 'kotlin-kapt'

    // DBFlow
    kapt "com.github.Raizlabs.DBFlow:dbflow-processor:${dbflow_version}"
    compile "com.github.Raizlabs.DBFlow:dbflow-core:${dbflow_version}"
    compile "com.github.Raizlabs.DBFlow:dbflow:${dbflow_version}"
    compile "com.github.Raizlabs.DBFlow:dbflow-kotlinextensions:${dbflow_version}"

    // Kotlin
    compile "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
```

##初始化

使用DBFlow需要在app的Application中初始化配置：

```
//初始化配置DBFlow
FlowManager.init(getApplicationContext());
```


**不要忘记在Manifest文件下配置自定义的Application**

##APP效果

![image](https://github.com/ddxxll2008/Kotlin-DBflow-example/blob/master/dbflow-kotlin-example.gif)

输入姓名，选择性别，点击添加按钮，则将数据存入数据库中。点击该数据，则将此数据从数据库中删除。
