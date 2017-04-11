# lombok插件安装.
## 使用说明参见
	[官方文档](https://projectlombok.org)
## 源码参见
	[Github](https://github.com/rzwitserloot/lombok)
## 下载
	[官方下载](https://projectlombok.org/download.html)
## 安装
### maven中央仓库
	<dependencies>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.16.16</version>
			<scope>provided</scope>
		</dependency>
	</dependencies>
### eclipse安装
	1. java -jar ${your_jar_path}\lombok-1.14.6.jar(或者双击lombok-1.14.6.jar包运行)
	2. 更改 eclipse.ini 文件
		-Dosgi.requiredJavaVersion=1.8
		-javaagent:{path}lombok.jar
		-Xbootclasspath/a:{path}lombok.jar
		-Xms256m
		-Xmx1024m
	3. 重启eclipse.如报错点击菜单Project->clean
	4. ubuntu系统如果还是报错,可以重启下机器.window系统自寻解决方法.
### 引用
	1. [eclipse安装部分内容参照](http://stackoverflow.com/questions/22310414/how-to-configure-lombok-in-eclipse-luna)