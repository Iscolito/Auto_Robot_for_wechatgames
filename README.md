# 截图软件

<!--环境要求：java18.0.2.1-->

其中Auto_click类实现robot类功能的扩展，但是为了保证应用性并没有继承。

截图框选的ui选择重写mouselistener类，自定义了其中的click方法，由于mouselistener只能对自建窗体内的鼠标行为进行捕捉，因此考虑将窗口透视化便于用户点选，其中两点只需要**选择希望截取的区域对角线上的两点**即可。

<!--注意透明蒙版并不会在截图中出现，多屏用户在希望截图的屏幕下打开bash即可-->

使用方法：

1.有jdk的用户直接下载src源文件，在`.../src/`下打开bash页面执行：

```bash
`$ javac main.Motion.java`

`$ java main.Motion`
```



2.有jre的用户直接下载bin二进制编译后文件，在`.../bin/`下打开bash页面执行：

```bash
`$ java main.Motion`
```

截图文件会以screenshot的名称保存在相应目录下

3.有jre的用户也可以直接使用我打包的Catchsreen.jar文件

4.如果没有java环境的话，可以使用我提供的exe打包版，下载Catchsreen.rar，解压之后保证exe和jre文件在同一个目录里即可。但是考虑到exe4j的中间打包过程，可能会有不确定性。
在看到：
```bash
`This executable was created with an evaluation version of exe4j`
```
点击确定即可开始截图，截图会被保存在和exe同路径的地方。
