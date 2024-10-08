# ServerManager
透明化とモード切替の管理。  
[ [中文](https://github.com/reuAC/ServerManager/blob/reuAC/README.md) | [English](https://github.com/reuAC/ServerManager/blob/reuAC/README_EN.md) | 日本語 ]

## 紹介
このプラグインはSpigot 1.8以上に対応しています。  

このプラグインは、対応する権限ノードを持つユーザーにモード切替や透明化を提供します。  
透明化は、透明ポーションではなく `hidePlayer` メソッドに基づいています。  

## Commands
* /servermanager v - 透明状態の切り替え
* /servermanager gm - サバイバル/スペクテイターモードの切り替え。  
**コンソールで servermanager コマンドを使用すると、プラグイン設定をリロードできます。**  
**メインコマンドの省略形：`/smger`**

## 設定ファイル
プラグインが正常に起動すると、`plugins/ServerManager/config.yml` に設定ファイルが生成されます。  
オプションは一つだけで、`autoInvisible` です。  
その後にはブール値が続きます。これは、透明化権限ノードを持つユーザーがログイン時に自動的に透明化するかどうかを制御します。  

値が`true`の場合、透明化権限ノードを持つユーザーはログイン時に`自動的に透明化`されます。  
値が`false`の場合、透明化権限ノードを持つユーザーはログイン時に`自動的に透明化されません`。

## 権限ノード
* servermanager.v - 透明化の権限ノード（透明状態の切り替えが可能）
* servermanager.gm - モード切替の権限ノード（サバイバル/スペクテイターモードの切り替えが可能）

## 仕組み
プレイヤーがサバイバルモードまたはスペクテイターモード以外のモードにいる場合、`/servermanager gm` コマンドを使用するとサバイバルモードに切り替わります。

## 使用方法
1. コンパイル済みのjarファイルをpluginsフォルダに入れ、サーバーを再起動します。
