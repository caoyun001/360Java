# Linux操作系统

教学目标（1）

1. 可以独立安装CentOS
2. 熟练使用磁盘管理命令
3. 熟练使用文件管理命令
4. 熟练使用文档编辑命令
5. 熟练使用备份压缩命令
6. 熟练使用权限命令

教学目标（2）

1. 能够完成Linux系统中jdk的安装
2. 能够完成linux系统中tomcat的安装
3. 能够完成linux系统中mysql的安装
4. 能够完成Linux系统中Redis的安装
5. 能够完成项目部署

## Linux操作系统概述

  Linux是基于Unix的开源免费的操作系统，由于系统的稳定性和安全性几乎成为程序代码运行的最佳系统环境。Linux是由Linus Torvalds（林纳斯·托瓦兹）起初开发的，由于源代码的开放性，现在已经衍生出了成千上百种不同的Linux系统。

  Linux系统的应用非常广泛，不仅可以长时间的运行我们编写的程序代码，还可以安装在各种计算机硬件设备中，比如手机、平板电脑、路由器等。尤其在这里提及一下，我们熟知是Android程序最底层就是运行在linux系统上的。

![](img/1.jpg)

## Linux分类

### 市场需求分类：

- 图形化界面版：注重用户体验，类似window操作系统，但目前成熟度不够。
- 服务器版：没有好看的界面，是以在控制台窗口中输入命令操作系统的，类似于DOS，是我们架设服务器的最佳选择。

### 原生程度分类：

- 内核版本：在Linus领导下的内核小组开发维护的系统内核的版本号。

- 发行版本：一些组织或公司在内核版基础上进行二次开发而重新发行的版本。
  - Linux发行版本不同，又可以分为n多种：![](img/2.jpg)

## Linux操作系统安装

### 虚拟机安装

  因为Linux也是一个系统，本质上跟我们电脑的Window没有区别，所以我们要学习Linux就首先将我们电脑的Window系统换成Linux系统，或者在我们电脑上安装双系统，听上去是不是很可怕。其实我们可以在我们电脑上安装一个软件，这个软甲可以模拟一台或多台虚拟的电脑机器，这就是虚拟机。

![](img/3.jpg)

![](img/4.jpg)

![](img/5.jpg)

![](img/6.jpg)

![](img/7.jpg)

![](img/8.jpg)

![](img/9.jpg)

![](img/10.jpg)





### CentOS安装

  CentOS是一个Linux的发行版本，是目前企业中用来做应用服务器系统的主要版本，CentOS的安装，其实是将该系统安装到VMware虚拟机软件中，让VMware虚拟机软件模拟出一台Linux系统的电脑。

![](img/11.jpg)

![](img/12.jpg)

![](img/13.jpg)

![](img/14.jpg)

![](img/15.jpg)

![](img/16.jpg)

![](img/17.jpg)

![](img/18.jpg)

![](img/19.jpg)

![](img/20.jpg)

![](img/21.jpg)

![](img/22.jpg)

![](img/23.jpg)

![](img/24.jpg)

![](img/25.jpg)

![](img/26.jpg)

![](img/27.jpg)

![](img/28.jpg)

![](img/29.jpg)

![](img/30.jpg)

![](img/31.jpg)

![](img/32.jpg)

![](img/33.jpg)

![](img/34.jpg)

![](img/36.jpg)

![](img/37.jpg)

![](img/38.jpg)

![](img/39.jpg)

![](img/40.jpg)



## Linux操作系统目录结构

![](img/41.jpg)

### 目录切换命令

- cd usr        切换到该目录下usr目录
- cd ../          切换到上一层目录
- cd /           切换到系统根目录
- cd ~          切换到用户主目录
- cd -           切换到上一个所在目录

## 远程连接工具：SSH使用

  在Linux执行命令很不方便，另外我们需要将自己计算机中的文件上传到Linux中，因此使用远程连接工具还是比较方便的。

### SSH安装

![](img/ssh_1.jpg)

![](img/ssh_2.jpg)

![](img/ssh_3.jpg)

![](img/ssh_4.jpg)

![](img/ssh_5.jpg)

![](img/ssh_6.jpg)

### SSH的使用

  打开安装好的软件：SSH Secure File Transfer Client

![](img/ssh_7.jpg)

![](img/ssh_8.jpg)

![](img/ssh_9.jpg)

![](img/ssh_10.jpg)



## 目录操作命令（增删改查）

  linux操作系统命令格式： 命令 -[参数]

### 查看目录：ls -[al]

- ls：查看目录
  - 参数 -a 显示全部，包含隐藏
  - 参数 -l 列表形式显示

### 增加新目录：mkdir

- mkdir 目录名字

### 搜索目录和文件：find

- find搜索目录，也能搜索文件
  - 参数 -name，以目录名或者文件名进行搜索
- 示例：在etc目录下，搜索名是 "sudo*"
  - find /etc -name "sudo.*"

### 修改目录名：mv

- mv 老目录名 新目录名
  - 示例：mv oldtest newtest
- 如果修改后的新目录和老目录不在同一个路径下，产生剪切效果
  - 示例：mv oldtest /usr/local/newtest

### 复制目录：cp

- cp 复制目录命令
  - 参数 -r 递归
  - 示例：将根目录下的test目录，拷贝到/usr/local下 。 cp -r test /usr/local

### 删除目录或文件：rm

- rm：删除目录命令
  - 参数 -r 递归
  - 参数 -f 不询问
  - 示例：删除/usr/local目录下的test目录。rm -rf test

## 文件操作命令（增删改查）

### 创建文件：touch

- touct：创建新文件命令  touch 文件名

### 查看文件

- cat命令查看文件，值显示文件最后一屏
  - 示例：查看/etc/sudo.conf。  cat /etc/sudo.conf
- more命令查询文件，显示文件百分比，回车下一行，空格下一页
  - 示例：查看/etc/sudo.conf。  more /etc/sudo.conf
- less命令查看文件，支持pgUp,pgDn进行上下翻页
  - 示例：查看/etc/sudo.conf。less /etc/sudo.conf
- tail命令查看文件，支持显示的文件行数
  - 示例：使用tail-10 查看/etc/sudo.conf文件的后10行

### 修改文件：vim编辑器

- vim：文件名

- vim编辑器有三种状态

  - 命令模式

      只接受命令关键字  其他字符不接受通过输入相应的命令可以进入编辑模式

      进入编辑模式命令：i，o，a或者insert

  - 编辑模式

    对文件进行内容编辑 任何字符都接受，内容编辑完毕之后 需要退回命令模式

    退回到命令模式ESC键

  - 底行模式

    进行保存或退出操作

    命令模式进入底行模式： 冒号

    底行模式：qw写入并退出，q!退出不保存

- vim编辑器使用过程关于vim使用过程：

    vim 文件-------->命令模式--------->输入i---------->编辑模式----------->编辑文件----------->按下Esc--------->命令模式--------->按下：---------->底行模式----------->输入wq保存并退出/q！强制退出不保存

## 压缩文件管理

  Linux中的打包文件一般是以.tar结尾的，压缩的命令一般是以.gz结尾的。而一般情况下打包和压缩是一起进行的，打包并压缩后的文件的后缀名一般.tar.gz。

### tar命令：压缩和解压缩

- 参数：-z 调用gzip压缩命令压缩

- 参数：-c 打包文件
- 参数：-C 在指定的目录解压缩

- 参数：-v 显示命令的执行过程

- 参数：-f 指定文件名
- 参数：-x 解压缩
- 示例：将test目录打成压缩包，压缩后文件名为 test.tar.gz
  -  tar -zcvf test.tar.gz test
- 示例：将test.tar.gz进行解压缩
  - tar -xvf test.tar.gz
  - tar -xvf test.tar.gz -C /usr/local   解压缩到指定的目录

## pwd命令：显示当前的目录

## 其他命令

### ps命令：查看进程

- 参数：-e 显示所有程序

- 参数：-f 显示UID,PPIP

### kill命令：结束进程

参数：-9 强制杀死该进程

### grep：搜索命令

  搜索字符串，搜索文件

- 示例：搜索 /etc/sudo.conf 中包含字符串“to”的内容
  - grep to /etc/sudo.conf
  - grep to /etv/sudo.conf --color

### 管道命令：|

  将前一个命令的输出作为本次目录的输入

- 示例：ls命令列出etc目录下所有后缀名是.conf的
  - ls -al | grep .conf

### 网络命令：ifconfig

  查看本机网卡信息

### 网络命令：ping

  查看与某台主机的连接情况

### 网络命令：netstat

  查看本机被使用的端口号

参数：-a 显示所有连接

参数：-n 以网络IP地址代替名称

## linux权限命令：chmod

  权限是Linux中的重要概念，每个文件/目录等都具有权限，通过ls -l命令我们可以 查看某个目录下的文件或目录的权限

  示例：在随意某个目录下ls -l

![](img/42.jpg)

![](img/43.jpg)

- 文件的类型：
  - d：代表目录
  - -：代表文件
  - l：代表链接（可以认为是window中的快捷方式）

- 后面的9位分为3组，每3位置一组，分别代表属主的权限，与当前用户同组的     用户的权限，其他用户的权限
  - r：代表权限是可读，r也可以用数字4表示
  - w：代表权限是可写，w也可以用数字2表示
  - x：代表权限是可执行，x也可以用数字1表示

![](img/44.jpg)

### chmod命令设置权限

- chmod u=rwx,g=rw,o=r aaa.txt

## 远程安装软件命令(联网使用)：yum

  Yum（全称为 Yellow dog Updater, Modified）是一个在Fedora和RedHat以及CentOS中的软件包管理器。基于RPM包管理，能够从指定的服务器自动下载RPM包并且安装，可以自动处理依赖性关系，并且一次安装所有依赖的软件包，无须繁琐地一次次下载、安装。

- 参数：install 安装软件包
- 参数：list 查看可以安装的软件包
- 示例：查找可以安装的软件包
  - yum list | grep gcc
- 示例：安装gcc编译器
  - yum install gcc
- **linux操作系统下的redis数据库，是C语言源码形式出现的，因此需要C语言编译器编译为可执行文件。**
- **远程下载需要的安装包，下载到/var/cache/yum/i386/6/base/packages目录下，安装完毕后自动删除**
- 查看软件的安装位置
  - rpm -ql gcc

## 软件包管理命令：rpm

  rpm（Red Hat Package Manager）类似于window中的软件安装包

### 查看已经安装的软件包

- 参数：-a 查询所有软件包

- 参数：-q 表示查询

- 示例：查询已经安装的java
  - rpm -qa | grep java

![](img/45.jpg)

### 卸载已经安装的软件包

- 参数：-e 卸载

- 参数：--nodeps 不检查依赖性

- 示例：卸载已经安装的Java
  -  rpm -e --nodeps java-1.6.0-openjdk-1.6.0.0-1.66.1.13.0.el6.i686
  -  rpm -e --nodeps java-1.7.0-openjdk-1.7.0.45-2.4.3.3.el6.i686

###   安装软件包

- 参数：-i install 安装

- 参数：v verbose 安装详细信息

- 参数：h hash 显示进度

## Linux操作系统部署JDK

- linux版本JDK上传到linux系统中的 /usr/local下

- tar -xvf 解开压缩包

  -  tar -xvf jdk-8u191-linux-i586.tar.gz 

- 配置环境变量

  - 进入 /etc目录中，编辑文件profile
  - 以下代码复制到profile文件中

  ```
  #set java environment
  	JAVA_HOME=/usr/local/jdk1.8.0_191
  	CLASSPATH=.:$JAVA_HOME/lib.tools.jar
  	PATH=$JAVA_HOME/bin:$PATH
  	export JAVA_HOME CLASSPATH PATH 
  
  ```

  - 保存并退出

- 从新加载环境变量

  - source /etc/profile
  - 测试：任意目录下输入 javac

## Linux系统部署Tomcat

- linux版本tomcat上传到linux系统中的/usr/local下
- tar -xvf解开压缩包
  -  tar -xvf apache-tomcat-8.5.37.tar.gz
- 开放Linux8080端口对外访问
  - /sbin/iptables -I INPUT -p tcp --dport 8080 -j ACCEPT
  - /etc/rc.d/init.d/iptables save
- 启动和停止tomcat服务
  - tomcat解压目录/bin下     ./startup.sh
  - tomcat解压目录/bin下     ./shutdown.sh

## Linux系统部署MySQL数据库

- linux版本MySQL上传到linux系统中的/usr/local下
- 卸载系统中自带的MySQL
  - 查询系统中是否已经安装了MySQL    rpm -qa | grep mysql
  - 卸载MySQL    rpm -e --nodeps mysql-libs-5.1.71-1.el6.i686
- 解压MySQL压缩包
  - tar -xvf MySQL-5.6.22-1.el6.i686.rpm-bundle.tar -C /usr/local/mysql
  - 由于MySQL解压后没有文件夹，很多文件比较凌乱，必须选创建目录mysql，将所有的文件解压缩到该目录下
- rpm命令安装
  - 安装MySQL数据库服务器   rpm -ivh MySQL-server-5.6.22-1.el6.i686.rpm 
  - 安装MySQL数据库客户端   rpm -ivh MySQL-client-5.6.22-1.el6.i686.rpm
  - 启动MySQL服务   service mysql start
  - MySQL服务添加到系统中   chkconfig --add mysql
  - 跟随系统启动  chkconfig mysql on
- 设置root密码
  - MySQL首次安装的随机密码：/root/.mysql_secret 保存在此文件中
  - 登录MySQL，设置密码： set password = password('root')
- 授权远程连接
  - 默认情况下mysql为安全起见，不支持远程登录mysql，所以需要设置开启     远程登录mysql的权限
  - grant all privileges on *.* to 'root' @'%' identified by 'root';flush privileges;
- 开放3306端口
  - /sbin/iptables -I INPUT -p tcp --dport 3306 -j ACCEPT
  - /etc/rc.d/init.d/iptables save

## Linux系统部署redis数据库

- linux版本redis上传到linux系统中的/usr/local下
- 解压缩redis
  - tar -xvf tar -xvf redis-3.2.9.tar.gz
- make命令编译redis的C语言源码
  - 进入解压后的redis目录下的src目录
  - 输入make命令即可
- 启动redis服务器
  - 进入redis解压目录下的src目录
  - ./redis-server

- 后台启动
  - 将redis解压缩目录下的redis.conf文件复制到src下
  - 编译redis.conf文件，原有的daemonize no修改为daemonize yes
  - 启动redis    ./redis-server redis.conf
  - 启动redis客户端  ./redis-cli
- 关闭redis服务器
  - ./redis-cli shutdown

## 补充：解决SSH中文乱码

  在linux的/etc/sysconfig目录下有一个i18n的文件代表linux的系统编码，将其从UTF-8修改成GBK重现连接linux即可

