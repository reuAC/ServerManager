# ServerManager
管理人员隐身与模式切换。  
[ 中文 | [English](https://github.com/reuAC/ServerManager/blob/reuAC/README_EN.md) | [日本語](https://github.com/reuAC/ServerManager/blob/reuAC/README_JP.md) ]

## 介绍
该插件适用于Spigot1.8及以上。  

该插件支持对于拥有对应权限节点的用户进行模式切换、隐身。  
其中，隐身基于 `hidePlayer` 方法而非隐身药水。  

## 指令
* /servermanager v - 隐身状态开关
* /servermanager gm - 切换生存/观察者模式。
**控制台使用`servermanager`指令，可以重载插件配置**
**主指令缩写：`/smger`**

## 配置文件
插件成功启动后，会在plugins文件夹下生成配置文件，位于 `plugins/ServerManager/config.yml`  
其中仅有一个选项`autoInvisible`  
其后跟随这一个布尔值，它用于控制拥有隐身权限节点的用户登录游戏时是否自动隐身。  

当值为**true**时，则拥有隐身权限节点的用户登录游戏时**会**自动隐身。  
当值为**false**时，则拥有隐身权限节点的用户登录游戏时**不会**自动隐身。  

## 权限节点
* servermanager.v - 隐身权限节点（可使用隐身状态开关）
* servermanager.gm - 模式切换权限节点（可切换生存/观察者模式）

## 机制
当玩家处于观察者模式、生存模式以外的模式时，使用 `/servermanager gm`指令，则会切换到生存模式。

## 使用方法
1. 将编译完成的jar包放入plugins文件夹中，重启服务器。